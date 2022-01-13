package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2573_빙산 {

    static int[][] map;
    static int n;
    static int m;
    static int[] mi = {0, 0, 1, -1};
    static int[] mj = {1, -1, 0, 0};
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

        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int day = 0;

        while(true){
            day++;
            // 하루동안 녹음
            int result = melting();
            if (result == 0) { // 녹은게 없으면
                System.out.println(0);
                return;
            }

            // 분리 되었는지 확인
            if(isSeparated()){
                break; // 분리 되었으면 종료
            }
        }

        System.out.println(day);
    }

    public static int melting(){ // 하루동안 녹는중
        int[][] updated_map = new int[n][m]; // 새로운(녹은 게 반영될) 맵

        int melted = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) { // 빙산이면 주변 바닷물이 몇칸인지 센 후 그만큼 빼주기
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        if (map[i + mi[d]][j + mj[d]] == 0) {
                            cnt++;
                        }
                    }
                    updated_map[i][j] = Math.max(map[i][j] - cnt, 0);
                    melted++;
                }
            }
        }
        map = updated_map; // 새로운 맵으로 업데이트

        return melted; // 녹은 빙산의 개수 리턴
    }


    public static boolean isSeparated(){ // 분리되었는지 확인

        visited = new boolean[n][m];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j); // bfs로 상하좌우 이어져있는 빙산 찾기
                    cnt++;
                }
            }
        }

        return cnt>1; // 서로 이어져있는 빙산이 1개 이상이면 분리된 것
    }


    public static void bfs(int i, int j) { // start i, j

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Loc now = q.poll();

            for (int d = 0; d < 4; d++) {
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];
                if(ni<0 || ni>=n || nj<0 || nj>=m) continue;
                if (map[ni][nj] != 0 && !visited[ni][nj]) { // 옆에 붙어있는 빙산이고 아직 방문 안했으면
                    visited[ni][nj] = true;
                    q.add(new Loc(ni, nj));
                }
            }
        }
    }
}
