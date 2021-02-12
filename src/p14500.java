import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
테스리스의 ㅏ 모양을 제외하고는 dfs를 통해 4방향으로 4개를 선택하면 만들어진다.
dfs를 구현한 뒤 예외를 처리하여 max값을 구하는 BruteForce 문제
 */
public class p14500 {
    static int m;
    static int n;
    static int max=0;
    static int[] moveI = {0, 0, 1, -1};
    static int[] moveJ = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
                Exception(i, j);
            }
        }
        System.out.println(max);

    }
    static void dfs(int i, int j, int count, int sum){
        if(count==4){
            max = Math.max(max, sum);
            return;
        }

        for(int d=0; d<4; d++){
            int ni = i + moveI[d];
            int nj = j + moveJ[d];
            if (ni < 0 || nj < 0 || ni > n-1 || nj > m-1) continue;
            if (!visited[ni][nj]) {
                visited[ni][nj] = true;
                dfs(ni, nj, count + 1, sum+map[ni][nj]);
                visited[ni][nj] = false;
            }

        }

    }

    static void Exception(int i, int j) {
        int wing = 4;
        int min = Integer.MAX_VALUE;
        int sum = map[i][j];
        for(int d=0; d<4; d++){
            int ni = i + moveI[d];
            int nj = j + moveJ[d];
            if(wing<=2) return; // 날개기 2개이하일때 = 꼭짓점에 있을때
            if (ni < 0 || nj < 0 || ni > n-1 || nj > m-1) {
                wing--;
                continue;
            }
            min = Math.min(min, map[ni][nj]);
            sum = sum + map[ni][nj];
        }
        //날개가 4개일때 가장 작은 날개를 없애야 ㅗ,ㅏ,ㅓ,ㅜ 모양이 나온다.
        if (wing == 4) {
            sum = sum - min;
        }
        max = Math.max(max, sum);
    }

}
