import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DP면 점화식 세워야하나 의심,,
// n의 범위가 1부터라 밖에다가 0,1,2 다 써주면 안된당
// dp는 항상 풀고나면 코드가 너무 짧아서 현타가 온다 하하하
// https://zoonvivor.tistory.com/133
// https://hees-dev.tistory.com/30
public class boj2156_포도주시식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wines = new int[n];
        for (int i = 0; i < n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        // OOX OXO XOO
        //  현재 인덱스에서 어떻게 먹는 것이 제일 많은 양을 먹는지를 생각해봐야 함

        int[] dp = new int[n];
        dp[0] = wines[0];

        for (int i = 1; i < n; i++) {
            if(i==1){
                dp[1] = wines[0] + wines[1];
                continue;
            }
            if(i==2){
                dp[2] = Math.max(dp[1], Math.max(wines[0]+wines[2], wines[1]+wines[2]));
                continue;
            }
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i-1] + wines[i]));
        }

        System.out.println(dp[n-1]);
    }
}
