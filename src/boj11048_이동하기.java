package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj11048_이동하기 {

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

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[][] map = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            inputs = br.readLine().split(" ");
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(inputs[j-1]);
                //dp[i][j] = -1;
            }
        }

//        dp[1][1] = map[1][1]; // 안해도된당!

        // 대각선은 오른쪽 아래로 가는 것 또는 아래 오른쪽으로 대체 가능
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                dp[i][j] = Math.max(map[i][j]+dp[i-1][j], map[i][j]+dp[i][j-1]);
            }
        }

        System.out.println(dp[N][M]);


        // 사탕 개수의 최댓값 -> BFS!인줄 알았는데,, 아니네,, 최솟값일때 BFS,,,
        // 비슷한 문제라고 자만하지 말잣,,
        // 이거는 최댓값을 구하는거라 BFS를 해버리면 무한대가 될 수도 있다!!!

//        Queue<Loc> q = new LinkedList<>();
//        q.add(new Loc(1, 1, map[1][1]));
//        dp[1][1] = map[1][1];
//
//        int[] mi = {1, 1, 0};
//        int[] mj = {1, 0, 1};
//
//        while (!q.isEmpty()) {
//            Loc now = q.poll();
//
//            for (int d = 0; d < 3; d++) {
//                int ni = now.i + mi[d];
//                int nj = now.j + mj[d];
//
//                if(ni<1 || ni>N || nj<1 || nj>M) continue;
//
//                if (dp[ni][nj] == -1 || dp[ni][nj] < now.cnt + map[ni][nj]) {
//                    dp[ni][nj] = now.cnt + map[ni][nj];
//                    q.add(new Loc(ni, nj, now.cnt + map[ni][nj]));
//                }
//            }
//        }


    }
}
