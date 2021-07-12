package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1261_알고스팟 {

    static class Loc{
        int i;
        int j;
        int cnt;

        public Loc(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        int[][] map = new int[n + 1][m + 1];
        int[][] cnt = new int[n + 1][m + 1]; // memorization

        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j-1)));
                cnt[i][j] = -1;
            }
        }

        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(1, 1, 0));
        cnt[1][1] = 0; // start point

        int[] mi = {0, 0, -1, 1};
        int[] mj = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            Loc now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];

                if (ni < 1 || ni > n || nj < 1 || nj > m) {
                    continue;
                }
                int tmp_cnt = now.cnt;
                if(map[ni][nj]==1){
                    tmp_cnt++;
                }
//                System.out.println("ni="+ni+"/nj="+nj+"/tmp_cnt="+tmp_cnt);
                if(cnt[ni][nj] == -1 || cnt[ni][nj]>tmp_cnt){
                    cnt[ni][nj] = tmp_cnt;
                    queue.add(new Loc(ni, nj, tmp_cnt));
                }

            }
        }

        System.out.println(cnt[n][m]);

    }
}
