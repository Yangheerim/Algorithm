import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
greedy algorithm
dp를 사용해서 이미 계산된거는 계산하지 않도록 한다.
move 메소드 안의 if(dp[i][j]!=0) ~~ 가 뽀인트! 이거 안해주면 시간초과 남.
dfs를 사용해서 이동-이동-이동 하는 로직을 구현했다.
 */
public class p1937 {
    static int[][] area;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        area = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, move(i, j));
            }
        }
        System.out.println(result);
    }

    public static int move(int i, int j) {

        // dp 배열을 만들어서 이미 계산이 된 경우에는 가져다 쓴다!
        if(dp[i][j]!=0)
            return dp[i][j];

        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};

        int day = 1;
        for (int d = 0; d < 4; d++) {
            int next_i = i + x[d];
            int next_j = j + y[d];
            if (next_i >= 0 && next_i < n && next_j >= 0 && next_j < n) {
                if (area[next_i][next_j] > area[i][j]){
                    day = Math.max(move(next_i, next_j)+1, day);
                    dp[i][j] = day;
                }
            }
        }
        return day;
    }
}
