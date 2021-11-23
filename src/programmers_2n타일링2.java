package programmers2;

public class programmers_2n타일링2 {
    public int solution(int n) {

        // dp
        // BOTTOM-UP

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            dp[i] %= 1000000007;
        }


        return dp[n];
    }
}
