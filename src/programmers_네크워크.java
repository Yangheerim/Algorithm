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

    // BFS로 풀이
//    public int solution(int n, int[][] computers) {
//        int answer = 0;
//        visited = new boolean[computers.length];
//
//        for (int i = 0; i < computers.length; i++) {
//            if (!visited[i]) {
//                answer++;
//                BFS(i, computers);
//            }
//        }
//        return answer;
//    }
//
//    public static void BFS(int i, int[][] arr) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(i);
//
//        while (!queue.isEmpty()) {
//            int cur = queue.poll();
//            visited[cur] = true;
//
//            for (int j = 0; j < arr.length; j++) {
//                if (!visited[j] && arr[cur][j] == 1) {
//                    queue.add(j);
//                }
//            }
//        }
//    }


}
