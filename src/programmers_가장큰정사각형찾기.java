package programmers;

public class programmers_가장큰정사각형찾기 {
    public static void main(String[] args) {

    }

    public int solution(int[][] board){

        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n][m];

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0 || j==0){
                    dp[i][j] = board[i][j];
                    max = Math.max(max, dp[i][j]);
                    continue;
                }

                if(board[i][j]==0) continue;

                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;

                max = Math.max(max, dp[i][j]);
            }
        }

        return max*max;
    }

}
