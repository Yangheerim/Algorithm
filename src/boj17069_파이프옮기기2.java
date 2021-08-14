package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://gre-eny.tistory.com/312
// https://rebas.kr/838

/*
dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]
dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]
dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]

최종적으로 답은 dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2] 이 된다.
+) long type으로 해야함!
 */

public class boj17069_파이프옮기기2 {

    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(inputs[j-1]);
            }
        }

        if(map[n][n]==1){
            System.out.println(0);
            return;
        }

        long[][][] dp = new long[n+1][n+1][3];
        dp[1][2][0] = 1; //??


        // DP
        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) {
                if(map[i][j]==1) continue;

                // 가로 (0)
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                if(i==1) continue; // 맨 윗줄이면 continue

                // 세로 (1)
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if(map[i-1][j]==1 || map[i][j-1]==1) continue;

                dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }

        System.out.println(dp[n][n][0]+dp[n][n][1]+dp[n][n][2]);
    }
}
