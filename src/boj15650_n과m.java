package boj;

import java.io.*;

public class boj15650_n과m {
    static int n;
    static int m;
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputs = br.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        visited = new boolean[n+1];

        dfs(1, 0);

        bw.flush();
    }

    public static void dfs(int idx, int cnt) throws IOException {

        if(cnt==m){
            String str = "";
            for(int i=1; i<=n; i++){
                if(visited[i]){
                    str += i + " ";
                }
            }
            bw.write(str+"\n");
            return;
        }

        if(idx>n) return;

        visited[idx] = true;
        dfs(idx + 1, cnt + 1);

        visited[idx] = false;
        dfs(idx + 1, cnt);
    }
}
