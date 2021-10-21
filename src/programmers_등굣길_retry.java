package programmers2;

public class programmers_등굣길 {
    public static void main(String[] args) {
        int[][] puddles = {{2, 2}};
        solution(4, 3, puddles);
    }

    public static int solution(int m, int n, int[][] puddles) {

        boolean[][] map = new boolean[n+1][m+1];

        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = true; // true : 웅덩이
        }

        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (map[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] += dp[i - 1][j] % 1000000007;
                dp[i][j] += dp[i][j - 1] % 1000000007;

            }
        }


        return dp[n][m] % 1000000007;
    }
}
