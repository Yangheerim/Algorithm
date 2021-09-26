package programmers;

import java.util.LinkedList;
import java.util.Queue;

// visited로 하면 되는데 map 값을 직접 0으로 바꾸면 안된다...?


public class programmers_컬러링북 {

    static class Loc{
        int i;
        int j;

        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int global_n;
    static int global_m;

    public static void main(String[] args) {
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };
        solution(6, 4, picture);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        map = picture.clone();
        visited = new boolean[m][n];
        global_n = n;
        global_m = m;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != 0 && !visited[i][j]){
                    int size = bfs(i, j, map[i][j]);
                    maxSizeOfOneArea = Math.max(size, maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(answer[0]+", "+answer[1]);
        return answer;
    }

    public static int bfs(int i, int j, int num){ // start (i,j)

        int[] mi = {0, 0, 1, -1};
        int[] mj = {1, -1, 0, 0};

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(i, j));
        visited[i][j] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            Loc now = q.poll();

            for (int d = 0; d < 4; d++) {
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];

                if(ni<0 || ni>= global_m || nj<0 || nj>=global_n) continue;

                if (map[ni][nj] == num && !visited[ni][nj]) {
                    q.add(new Loc(ni, nj));
                    visited[ni][nj] = true;
                    cnt++;
                }
            }

        }

        return cnt;

    }
}

/*
[
[1, 1, 1, 0],
[1, 2, 2, 0],
[1, 0, 0, 1],
[0, 0, 0, 1],
[0, 0, 0, 3],
[0, 0, 0, 3]
]
 */
