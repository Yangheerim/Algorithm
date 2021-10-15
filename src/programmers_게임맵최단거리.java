package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_게임맵최단거리 {
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

    public static void main(String[] args) {
        int[][] maps = {
                {1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}
        };
        solution(maps);
    }

    public static int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];

        int[] mi = {0, 0, -1, 1};
        int[] mj = {1, -1, 0, 0};

        Queue<Loc> q = new LinkedList<>();

        q.add(new Loc(0, 0, 1));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Loc now = q.poll();
            // System.out.println(now.i+","+now.j);

            if (now.i == n - 1 && now.j == m - 1) {
                return now.cnt;
            }

            for(int d=0; d<4; d++){
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];

                if(ni<0 || ni>=n || nj<0 || nj>=m) continue;

                if(!visited[ni][nj] && maps[ni][nj] == 1){
                    visited[ni][nj] = true;
                    q.add(new Loc(ni, nj, now.cnt + 1));
                }
            }
        }

        return -1;
    }
}
