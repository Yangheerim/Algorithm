package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj7576_토마토 {

    static class Loc{
        int i;
        int j;
        int day;

        public Loc(int i, int j, int day) {
            this.i = i;
            this.j = j;
            this.day = day;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        int[][] map = new int[n][m];
        Queue<Loc> queue = new LinkedList<>();

        int tomato_not = 0;
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);

                // 안익은 토마토 수 카운트 - 나중에 --;
                if(map[i][j]==0) tomato_not++;

                // 익은 토마토는 큐에 넣기
                if(map[i][j]==1){
                    queue.add(new Loc(i, j, 0));
                }
            }
        }

        int day = 0;

        int[] mi = {0, 0, -1, 1};
        int[] mj = {1, -1, 0, 0};

        // 같은 시간에 여러개가 있으면 동시에 퍼져야함
        while (!queue.isEmpty()) {
            Loc now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];

                if(ni<0 || ni>=n || nj<0 || nj>=m) continue;
                if(map[ni][nj] == 0){
                    map[ni][nj] = 1;
                    tomato_not --;
                    queue.add(new Loc(ni, nj, now.day+1));
                    day = Math.max(day, now.day+1);
                }
            }
        }

        if(tomato_not==0){
            System.out.println(day);
        }else{
            System.out.println(-1);
        }

    }

//    static void print(int[][] map, int n, int m){
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("----------");
//    }
}
