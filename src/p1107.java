import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
Brute Force
모든 경우의수를 다 해보는 방법
참고 : https://geehye.github.io/baekjoon-1107/#
 */
public class p1107 {
    static List<Integer> miss;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int channel = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        miss = new ArrayList<>();
        if(m>0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                miss.add(Integer.parseInt(st.nextToken()));
            }
        }

        // 채널 100부터 시작하므로 100에서 원하는 채널까지 +키 또는 -키만으로 이동했을 때의 횟수를 최솟값 min에 저장.
        // 절대값을 구하는 Math.abs()사용!
        int min = Math.abs(channel - 100);

        // 이동하려고 하는 채널이 0부터 50만까지이다. ????
        // 밑에서부터 위로 50만까지 갈 수도 있지만, 위에서부터 밑으로 50만까지 갈 수 있으므로 0부터 100만까지의 모든 숫자를 확인한다.
        // 이동하려는 채널에서 임의의 채널 i를 빼면 i부터 + 또는 - 키로 움직이는 횟수가 나온다.
        // 여기에 i를 가기 위해 눌렀던 버튼 개수를 더해준 횟수가 현재까지 구한 방법보다 작은지 비교한다.
        for(int i=0; i<=1000000; i++){
            int length = check(i);
            if(length>0)
                min = Math.min(min, Math.abs(channel - i) + length);
        }
        System.out.println(min);

    }

    // 채널이 숫자키로만 이동 가능한지 확인하는 메서드
    public static int check(int num) {
        // 0일경우 모듈러 연산이 불가능하기 때문에 따로 처리
        if(num == 0) return miss.contains(num)? 0 : 1;

        int length = 0;
        // 1의자리부터 각 숫자가 망가진 숫자인지 확인. 망가졌으면 숫자키로만 이동이 불가하므로 0 리턴.
        while(num>0){
            if(miss.contains(num%10))
                return 0;
            length++;
            num/=10;
        }
        return length;
    }
}
