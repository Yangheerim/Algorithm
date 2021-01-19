import java.io.*;
import java.util.StringTokenizer;
/*
아무생각없이 for문으로 다 더했더니 시간초과가 났다.
괜히 한번 해본 array와 arrayList의 시간 차이는 없음 ㅋ
a부터 b까지의 합은 구간 0~b까지의 누적합에서 구간 0~a-1까지 누적합을 뺀 것이다 라는 개념으로 접근함.
 */
public class p11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int tk = Integer.parseInt(st.nextToken());

        int[] nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        int accumulated_sum=0;
        nums[0] = 0;
        for(int i=1; i<=n; i++){
            accumulated_sum+=Integer.parseInt(st.nextToken());
            nums[i]=accumulated_sum;
        }
        for(int i=1; i<=tk; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(nums[end]-nums[start-1]+"\n");
        }
        bw.flush();
    }
}
