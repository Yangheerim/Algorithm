import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
dfs로 풀 시 시간초과
bfs로 풀이함
 */

public class boj2178_미로탐색 {

    static int[] moveI = {-1, 1, 0, 0};
    static int[] moveJ = {0, 0, -1, 1};
//    static int cnt;
    static int[][] map;
    static boolean[][] visited;

    static class Loc{
        int i;
        int j;

        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            String tmp = br.readLine();
            char[] sliced = tmp.toCharArray();
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(sliced[j]));
            }
        }
//        cnt = Integer.MAX_VALUE;
        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(n, m);
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs(int n, int m){
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Loc loc = queue.poll();
            for(int d=0; d<4; d++){
                int ni = loc.i + moveI[d];
                int nj = loc.j + moveJ[d];
                if(ni<0 || ni>=n || nj<0 || nj>=m) continue;
                if(!visited[ni][nj] && map[ni][nj]==1) {
                    visited[ni][nj] = true;
                    queue.add(new Loc(ni, nj));
                    map[ni][nj] = map[loc.i][loc.j] + 1;
                }
            }
        }
    }

    public static void dfs(int i, int j, int count, int n, int m) {

        if(i==n-1 && j==m-1) {
//            cnt = Math.min(cnt, count);
            return;
        }

        for(int d=0; d<4; d++){
            int ni = i + moveI[d];
            int nj = j + moveJ[d];
            if(ni<0 || ni>=n || nj<0 || nj>=m) continue;
            if(!visited[ni][nj] && map[ni][nj]==1) {
                visited[ni][nj] = true;
                dfs(ni, nj, count + 1, n, m);
                visited[ni][nj] = false;
            }
        }

    }


}
