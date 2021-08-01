package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%80-2638-%EC%B9%98%EC%A6%88-java : visit 배열만 참고!
public class boj2638_치즈 {

    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] mi = {0, 0, 1, -1};
    static int[] mj = {1, -1, 0, 0};
    static ArrayList<Loc> cheese_melt;

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

        int time = 0;

        cheese_melt = new ArrayList<>();

        while(true){
            cheese_melt.clear();
            visited = new boolean[n][m];

            setExternalAir(); // -1은 외부 공기, 0은 내부 공기

            for (int i = 1; i < n-1; i++) {
                for (int j = 1; j < m-1; j++) {
                    if(map[i][j]==1){ // 치즈이면
                        if (isMelt(i,j)) { // 1시간 내에 녹을 치즈면 == 두 변이 외부 공기와 맞닿아있으면
                            cheese_melt.add(new Loc(i, j));
                        }
                    }

                }
            }

            if(cheese_melt.size()==0) break;

            // 겉 치즈 녹음
            for (Loc l : cheese_melt) {
                map[l.i][l.j] = 0;
            }

            time ++;
        }



        System.out.println(time);
    }

    public static boolean isMelt(int i, int j){
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int ni = i + mi[d];
            int nj = j + mj[d];

            if(ni<0 || nj<0 || ni>n || nj>m) continue;

            if(map[ni][nj] == -1) cnt++;
        }

        return cnt >= 2;
    }

    public static void setExternalAir(){

        Queue<Loc> q = new LinkedList<>();

        q.add(new Loc(0, 0));
        map[0][0] = -1;

        while (!q.isEmpty()) {
            Loc now = q.poll();

            for (int d = 0; d < 4; d++) {
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];

                if(ni<0 || nj<0 || ni>=n || nj>=m ) continue;

                if(visited[ni][nj] || map[ni][nj] == 1) continue;

                visited[ni][nj] = true;
                map[ni][nj] = -1; // 외부 공기는 -1로 초기화
                q.add(new Loc(ni, nj));

            }

        }

    }
}
