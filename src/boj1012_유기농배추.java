package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1012_유기농배추 {

    static class Loc{
        int i;
        int j;

        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tk = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(tk-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int m = Integer.parseInt(inputs[0]);
            int n = Integer.parseInt(inputs[1]);
            int k = Integer.parseInt(inputs[2]);

            map = new int[n][m];

            for (int i = 0; i < k; i++) {
                inputs = br.readLine().split(" ");
                int x = Integer.parseInt(inputs[0]);
                int y = Integer.parseInt(inputs[1]);
                map[y][x] = 1;
            }

            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] == 1){
                        bfs(i, j, n, m);
                        cnt++;
                    }
                }
            }

            sb.append(cnt+"\n");

        }
        System.out.println(sb);
    }

    public static void bfs(int i, int j, int n, int m) {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(i, j));
        map[i][j] = -1; // visited

        int[] mi = {0, 0, -1, 1};
        int[] mj = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            Loc now = q.poll();

            for (int d = 0; d < 4; d++) {
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];

                if(ni<0 || nj<0 || ni>=n || nj>=m) continue;

                if(map[ni][nj]==1){
                    map[ni][nj]=-1;
                    q.add(new Loc(ni, nj));
                }
            }
        }
    }
}
