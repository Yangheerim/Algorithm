import java.io.*;
import java.util.StringTokenizer;
/*
N칸의 1차원 배열이 있을 때, 부분 배열 중 그 원소의 합이 M이 되는 경우의 수를 구하는 것
모든 경우의 수를 다 테스트해보면, 구간 합을 구간합 배열로 O(1)만에 구한다고 해도 경우의 수가 (N^2)이 된다.
그래서 사용하는게 two pointer algorithm!
start와 end를 지정한 후,
end를 하나씩 뒤로 밀며 해당 수(nums[end++])는 sum에 더해준다.
하나씩 밀어준 뒤 sum이 m과 같아지면 count++해주고,
sum>=m이면 start++해주면서 start값을 sum에서 뺀다. (그러면 start~end 사이의 합이 자동으로 구해짐)
e가 n+1까지 도달하면 끝! (나는 인덱스를 1부터 했으므로)
 */
public class p2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        int[] nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // two pointer algorithm
        int s=1, e=1;
        int sum=0, result_ctn=0;
        while(true){
            if(sum>=m){
                sum -= nums[s++];
            }else if(e==n+1){
                break;
            }else {
                sum += nums[e++];
            }
            if(sum==m){
                result_ctn++;
            }
        }
        System.out.println(result_ctn);
    }
}
