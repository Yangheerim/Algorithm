import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
BruteForce 탐색
dfs를 이용하여 각각의 확률을 구해 모두 더해서 답을 내는 방식.
최대 범위가 어디까지인지 잘 확인한 후, 배열의 범위를 선언해주고 움직여야 한다.
확률은 계속 곱해진다. (0<=p<=1)
 */
public class p1405 {
    static int n;
    static double prob[] = new double[4];
    static boolean visited[][] = new boolean[30][30];
    static int move_i[] = {0, 0, 1, -1};
    static int move_j[] = {1, -1, 0, 0};
    static double result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            prob[i] = Integer.parseInt(st.nextToken())*0.01;
        }

        // map의 범위는 1~29 (14+원점+14), 가운데에서 시작
        visited[15][15] = true;
        dfs(15, 15, 0, 1.0);

        System.out.println(result);
    }

    public static void dfs(int i, int j, int cnt, double val) {
        // n번 움직였다면 멈추고, 그 확률을 result에 저장 (더해줌)
        if(cnt == n) {
            result += val;
            return;
        }

        // 동서남북 확인
        for (int d = 0; d < 4; d++) {
            int next_i = i + move_i[d];
            int next_j = j + move_j[d];
            // 해당 방향의 위치가 방문되지 않은 곳(단순함을 지키는 곳)인지 확인
            if (!visited[next_i][next_j]) {
                visited[next_i][next_j] = true;
                dfs(next_i, next_j, cnt + 1, val * prob[d]);
                visited[next_i][next_j] = false; // dfs 끝나면 다음을 위해 다시 false로 변경
            }
        }
    }
}
