package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj17070_파이프옮기기1 {

    static class Loc{
        int i;
        int j;
        int direction;

        public Loc(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.direction = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(inputs[j-1]);
            }
        }

        if(map[n][n]==1){
            System.out.println(0);
            return;
        }

        // BFS
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(1, 2, 0));

        int count = 0;

        while (!q.isEmpty()) {
            Loc now = q.poll();

            if (now.i == n && now.j == n) {
                count++;
                continue;
            }

            if (now.direction == 0) { // 현재 방향이 가로 (0) -> 가로(0) or 대각선(2)

                if(now.j+1<=n && map[now.i][now.j+1] != 1){ // 가로 : 벽이 아니면
                    q.add(new Loc(now.i, now.j + 1, 0));
                }

                if(now.i+1<=n && now.j+1<=n) {
                    if (map[now.i][now.j + 1] != 1 && map[now.i + 1][now.j + 1] != 1 && map[now.i + 1][now.j] != 1) { // 대각선
                        q.add(new Loc(now.i + 1, now.j + 1, 2));
                    }
                }

            }else if(now.direction == 1){ // 현재 방향이 세로 (1) -> 세로(1) or 대각선(2)
                if(now.i+1<=n && map[now.i+1][now.j] != 1){ // 세로
                    q.add(new Loc(now.i+1, now.j, 1));
                }

                if(now.i+1<=n && now.j+1<=n) {
                    if (map[now.i][now.j + 1] != 1 && map[now.i + 1][now.j + 1] != 1 && map[now.i + 1][now.j] != 1) { // 대각선
                        q.add(new Loc(now.i + 1, now.j + 1, 2));
                    }
                }
            }else{ // 현재 방향이 대각선 (2) -> 가로(0) or 세로(1) or 대각선(2)
                if(now.j+1<=n && map[now.i][now.j+1] != 1){ // 가로
                    q.add(new Loc(now.i, now.j + 1, 0));
                }
                if(now.i+1<=n && map[now.i+1][now.j] != 1){ // 세로
                    q.add(new Loc(now.i+1, now.j, 1));
                }

                if(now.i+1<=n && now.j+1<=n) {
                    if (map[now.i][now.j + 1] != 1 && map[now.i + 1][now.j + 1] != 1 && map[now.i + 1][now.j] != 1) { // 대각선
                        q.add(new Loc(now.i + 1, now.j + 1, 2));
                    }
                }
            }

        }

        if(count==0) {
            System.out.println(0);
        }else {
            System.out.println(count);
        }
    }
}
