package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = map[0][0];

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i+1][j] = Math.max(dp[i][j] + map[i+1][j], dp[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i][j] + map[i+1][j+1], dp[i+1][j+1]);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        System.out.println(max);

    }

    // (i+1, j)랑랑 (i+1, j+1) : 저장되어 있는 것보다 더 크면 업데이트- Math.max

    // 1
    // 2 3
    // 4 5 6
    // 7 8 9 10
}
