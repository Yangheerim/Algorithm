import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
최소 동전의 개수로 주어진 n을 만드는 문제
greedy 방법 이용
 */
public class p11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for(int i = 0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i=n-1; i>=0; i--){
            if(coins[i]<=k){
                count += k/coins[i];
                k = k % coins[i];
            }
        }
        System.out.println(count);
    }
}
