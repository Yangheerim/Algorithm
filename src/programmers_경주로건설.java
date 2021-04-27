public class programmers_경주로건설 {
    static int[][] map;
    static boolean[][] visited;
    static int[] mi = {0, 0, 1, -1};
    static int[] mj = {1, -1, 0, 0};
    static int n;
    static int result = Integer.MAX_VALUE;

    static class Loc{
        int i;
        int j;

        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
//        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        map = board;
        n = board.length;
        visited = new boolean[n][n];

        Loc start = new Loc(0, 0);
        visited[0][0] = true;
        dfs(start, start, 0);

        return result;
    }

    public static void dfs(Loc prev, Loc now, int cost){

//        System.out.println("("+now.i+", "+now.j+") , cost="+cost);
        if(cost>result) return;

        if(now.i == n-1 && now.j == n-1){
            result = Math.min(result, cost);
            return;
        }

        for(int d=0; d<4; d++){
            int ni = now.i + mi[d];
            int nj = now.j + mj[d];

            if(ni<0 || ni>=n || nj<0 || nj>=n) continue;
            if(!visited[ni][nj] && map[ni][nj]==0){
                int now_cost = calcCost(prev, now, new Loc(ni, nj));

                visited[ni][nj] = true;
                cost += now_cost;
                dfs(now, new Loc(ni, nj), cost);

                visited[ni][nj] = false;
                cost -= now_cost;
            }

        }
    }

    public static int calcCost(Loc prev, Loc now, Loc next){
        if(prev.i==now.i && prev.j==now.j) return 100;
        if(prev.i != next.i && prev.j != next.j) return 600;
        return 100;
    }

}
