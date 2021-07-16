package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// https://c-king.tistory.com/122
public class boj1325_효율적인해킹 {

    static class Computer{
        int idx;
        ArrayList<Computer> adj;

        public Computer(int idx) {
            this.idx = idx;
            this.adj = new ArrayList<>();
        }
    }

    static Computer[] comps;
    static int n;
    static int m;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        // A->B 신뢰이면 B를 해킹하면 A도 해킹할 수 있음.
        // B의 인접리스트에 A를 저장

        comps = new Computer[n + 1];
        for (int i = 1; i <= n; i++) {
            comps[i] = new Computer(i);
        }

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            comps[b].adj.add(comps[a]);
        }

        answer = new int[n + 1];
        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            visited[i] = true;
            dfs(i, i, 1);
        }

        int max = 0;
        for(int i=1; i<=n; i++){
            max = Math.max(max, answer[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(max == answer[i]){
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int start, int now, int cnt){

        for (Computer c : comps[now].adj) {
            if (!visited[c.idx]) {
                visited[c.idx] = true;
                dfs(start, c.idx, cnt + 1);
                answer[start] ++;
            }
        }

    }
}
