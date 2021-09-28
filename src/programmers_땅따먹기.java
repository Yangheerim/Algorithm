package programmers;

public class programmers_땅따먹기 {
    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        solution(land);
    }

    static int solution(int[][] land) {

        int n = land.length;

        int[][] dp = new int[n][4];
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i][1];
            dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3])) + land[i][2];
            dp[i][3] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + land[i][3];
        }

        int answer = Math.max(Math.max(dp[n-1][0], dp[n-1][1]), Math.max(dp[n-1][2], dp[n-1][3]));


        return answer;
    }

}
