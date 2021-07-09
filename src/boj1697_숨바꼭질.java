package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// BFS는 큐에서 뺀 뒤가 아니라 큐에 넣을 때 방문 표시를 해야 중복 방문이 일어나지 않습니다.

public class boj1697_숨바꼭질 {

    static class Loc{
        int time;
        int x;

        public Loc(int time, int x) {
            this.time = time;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int subin = Integer.parseInt(input[0]);
        int sister = Integer.parseInt(input[1]);

        boolean[] visited = new boolean[100001];
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(0, subin));
        visited[subin] = true;

        while (!queue.isEmpty()) {
            Loc now = queue.poll();

            if(now.x==sister){
                System.out.println(now.time);
                return;
            }

            // 걷기 (-1)
            if(now.x-1>=0 && !visited[now.x-1]){
                visited[now.x-1] = true;
                queue.add(new Loc(now.time+1, now.x-1));
            }

            // 걷기 (+1)
            if(now.x+1<=100000 && !visited[now.x+1]){
                visited[now.x+1] = true;
                queue.add(new Loc(now.time+1, now.x+1));
            }

            // 순간이동
            if(now.x*2<=100000 && !visited[now.x*2]){
                visited[now.x*2] = true;
                queue.add(new Loc(now.time+1, now.x*2));
            }

        }


    }


}
