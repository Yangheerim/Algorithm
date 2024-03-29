package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class boj2667_단지번호붙이기 {

    static ArrayList<Integer> arr;
    static int[][] map;
    static boolean[][] visited;
    static int n;

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
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
                if(map[i][j]==0){
                    visited[i][j] = true;
                }
            }
        }

        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    bfs(i, j);
                }
            }
        }

        Collections.sort(arr);

        System.out.println(arr.size());
        for (int a : arr) {
            System.out.println(a);
        }

    }

    public static void bfs(int i, int j){

        int[] mi = {0, 0, -1, 1};
        int[] mj = {1, -1, 0, 0};

        Queue<Loc> q = new LinkedList<>();

        q.add(new Loc(i, j));
        visited[i][j] = true;
        int cnt = 0;

        while (!q.isEmpty()) {

            Loc now = q.poll();
            cnt++;
            //System.out.println("("+now.i+","+now.j+")"+" count="+cnt);

            for (int d = 0; d < 4; d++) {
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];

                if (ni < 0 || nj < 0 || ni >= n || nj >= n) continue;

                if (!visited[ni][nj]) {
                    visited[ni][nj] = true;
                    q.add(new Loc(ni, nj));
                }
            }

        }
        arr.add(cnt);
    }
}
