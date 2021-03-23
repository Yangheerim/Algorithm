public class programmers_네크워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];

        // 한바퀴 돌면 얘랑 연결되어있는 애들이 모두 true로 바뀐다.
        // 그 후에 false인걸 찾아서 다시 반복!
        for(int i=0; i<computers.length; i++){
            if(!visited[i]) {
                answer++;
                dfs(i, visited, computers);
            }
        }
        return answer;
    }

    public void dfs(int node, boolean[] visited, int[][] computers) {
        visited[node] = true;

        for(int i=0; i<computers.length; i++){
            if(!visited[i] && computers[node][i]==1){
                dfs(i, visited, computers);
            }
        }
    }

}
