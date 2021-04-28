import java.util.LinkedList;
import java.util.Queue;

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
        Loc prev;

        public Loc(int i, int j, Loc prev) {
            this.i = i;
            this.j = j;
            this.prev = prev;
        }
        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
            this.prev = null;
        }
    }

    public static void main(String[] args) {
//        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
//        int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
        int[][] board = {{0,0,0,0,0,},{0,1,1,1,0},{0,0,1,0,0},{1,0,0,0,1},{0,1,1,0,0}}; //3000이 나와야함
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        map = board;
        n = board.length;
        visited = new boolean[n][n];

        //dfs
//        Loc start = new Loc(0, 0);
//        visited[0][0] = true;
//        dfs(start, start, 0);

        return bfs();
    }

    public static int bfs(){
        Queue<Loc> queue = new LinkedList<>();
        int[][] cost = new int[n][n];
        visited[0][0] = true;
        queue.add(new Loc(0, 0));
        map[0][0] = 1;

        Loc now;

        while (!queue.isEmpty()) {
            now = queue.poll();
            int i = now.i;
            int j = now.j;
            for(int d=0; d<4; d++) {
                int ni = i + mi[d];
                int nj = j + mj[d];

                if(ni<0 || ni>=n || nj<0 || nj>=n) continue;
                int now_cost = calcCost(now.prev, new Loc(ni, nj));
                if((cost[ni][nj]==0 || cost[ni][nj]>=cost[i][j]+now_cost) && map[ni][nj]==0){
//                    if(now.prev!=null && now.prev.i==ni && now.prev.j==nj) continue;
                    // testing
//                    if(now.prev==null) {
//                        System.out.println("(?, ?) " + "(" + i + ", " + j + ") "+ "(" + ni + ", " + nj + ") =>" + now_cost);
//                    }else{
//                        System.out.println("(" + now.prev.i + ", " + now.prev.j + ") " + "(" + i + ", " + j + ") "+ "(" + ni + ", " + nj + ") =>" + now_cost);
//                    }
                    cost[ni][nj] = cost[i][j] + now_cost;
                    queue.add(new Loc(ni, nj, now));

//                     testing
                    if(now.prev==null) {
                        System.out.println("Now :(" + i + "," + j + ",(?,?))");
                        System.out.print("Queue :");
                        for (Loc l : queue) {
                            System.out.print("(" + l.i + "," + l.j + ",(?,?)) ");
                        }
                    }else{
                        System.out.println("Now :(" + i + "," + j + ",(" + now.prev.i + "," + now.prev.j + "))");
                        System.out.print("Queue :");
                        for (Loc l : queue) {
                            System.out.print("(" + l.i + "," + l.j + ",(" + l.prev.i + "," + l.prev.j + ")) ");
                        }
                    }
                    System.out.println();

                    for(int ii=0; ii<n; ii++){
                        for(int jj=0; jj<n; jj++){
                            System.out.print(cost[ii][jj]+"\t");
                        }
                        System.out.println();
                    }
                    System.out.println("-------------------------");
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(cost[i][j]+"\t");
            }
            System.out.println();
        }
        return cost[n - 1][n - 1];
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
                int now_cost = calcCost(prev, new Loc(ni, nj));

                visited[ni][nj] = true;
                cost += now_cost;
                dfs(now, new Loc(ni, nj), cost);

                visited[ni][nj] = false;
                cost -= now_cost;
            }

        }
    }

    public static int calcCost(Loc prev, Loc next){
        if(prev == null) return 100;
        if(prev.i != next.i && prev.j != next.j) return 600;
        return 100;
    }

    // dfs 경우
//    public static int calcCost(Loc prev, Loc now, Loc next){
//        if(prev.i==now.i && prev.j==now.j) return 100;
//        if(prev.i != next.i && prev.j != next.j) return 600;
//        return 100;
//    }

}
