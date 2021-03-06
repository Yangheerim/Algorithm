import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 코드 참고 :  https://developer-mac.tistory.com/69
public class boj11052_카드구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] price = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            price[i] = Integer.parseInt(st.nextToken());
            dp[i] = price[i];
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i/2; j++){
//                System.out.println("dp["+i+"]="+dp[i]+", dp["+(i-j)+"]+price["+j+"]="+(dp[i - j]+price[j]));
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);

            }
        }
        System.out.println(dp[n]);
    }
}
