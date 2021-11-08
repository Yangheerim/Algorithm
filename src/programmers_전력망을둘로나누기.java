package programmers2;

public class programmers_전력망을둘로나누기 {

    public static void main(String[] args) {
        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        solution(4, wires);
    }

    static boolean[][] adj;
    public static int solution(int n, int[][] wires) {

        adj = new boolean[n+1][n+1]; // 1부터

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            adj[a][b] = adj[b][a] = true;
        }

        int min = n;

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            adj[a][b] = adj[b][a] = false;
            boolean[] visited = new boolean[n + 1];
            visited[1] = true;
            dfs(1, visited, n);

            int cnt = 0;
            for(int j=1; j<=n;j++){
                if(visited[j]) cnt++;
            }
            min = Math.min(min, Math.abs((n - cnt)-cnt));

            adj[a][b] = adj[b][a] = true;
        }
        return min;
    }
    public static void dfs(int now, boolean[] visited, int n){
        for (int i = 1; i <= n; i++) {
            if(!visited[i] && adj[now][i]){
                visited[i] = true;
                dfs(i, visited, n);
            }
        }
    }
}
