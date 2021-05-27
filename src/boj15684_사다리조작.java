import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15684_사다리조작 {

    static int N;
    static int M;
    static int H;
    static boolean[][] ladder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        if (M == 0) {
            System.out.println(0);
            return;
        }

        ladder = new boolean[H + 1][N]; // idx 1부터

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }
        
        if(isAllItoI()){
            System.out.println(0);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (dfs(i, 0)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);

    }

    public static boolean dfs(int add_num, int count) {
        if (count == add_num) {
            return isAllItoI();
        }
        for (int h = 1; h <= H; h++) { // 가로선
            for (int n = 1; n <= N-1; n++) { // 세로 가운데
                if (!ladder[h][n]) {
                    if ((n - 1 < 1 || !ladder[h][n - 1]) && (n + 1 >= N || !ladder[h][n + 1])) { // 양옆에 사다리가 없으면 추가한다
                        ladder[h][n] = true;
                        if (dfs(add_num, count + 1)) {
                            return true;
                        }
                        ladder[h][n] = false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isAllItoI() {
        for (int n = 1; n < N; n++) {
            int now = n; // 현재 세로선
            for (int h = 1; h <= H; h++) { // 가로선
                if (now <= N - 1 && ladder[h][now]) { // 현재 세로선 기준 오른쪽에 길이 있으면
                    now++;
                } else if (now > 0 && ladder[h][now - 1]) { // 왼쪽에 길이 있으면
                    now--;
                }
            }
            if (now != n) return false;
        }

        return true;
    }
}
