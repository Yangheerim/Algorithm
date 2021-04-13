public class sol2 {
    static int n;
    static int[][] needs_;
    static int result = 0;

    public static int solution(int[][] needs, int r) {

        n = needs[0].length; // n은 전체 부품개수
        needs_ = needs;
        boolean[] visited = new boolean[n];

        dfs(0, 0, visited, r);

        return result;
    }

    public static void dfs(int idx, int cnt, boolean[] visited, int r){

        if(cnt==r){
            int num = howManyProduct(visited);
            result = Math.max(result, num);
            return;
        }

        if(idx==n) return;

        visited[idx] = true;
        dfs(idx + 1, cnt+1, visited, r);

        visited[idx] = false;
        dfs(idx + 1, cnt, visited, r);
    }

    public static int howManyProduct(boolean[] visited){
        int cnt=0;
        for(int i=0; i<needs_.length; i++){
            boolean flag = true;
            for(int j=0; j<needs_[0].length; j++){
                if (needs_[i][j] == 1 && !visited[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
        }
        return cnt;
    }

}
