import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16234_인구이동 {

    static int n;
    static int L;
    static int R;

    static int[][] nums;
    static int[][] group;

    static class Loc{
        int i;
        int j;

        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        nums = new int[n][n];
        group = new int[n][n]; // 처음엔 모두 0

        for(int i=0; i<n; i++){ // 인구수 initial input
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    public static void move(){


    }

    public static void bfs(){
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(0, 0));

        int[] mi = {0,0,1,-1};
        int[] mj = {1,-1,0,0};

        while(!queue.isEmpty()){
            Loc tmp = queue.poll();
            for(int d=0; d<4; d++) {
                int ni = tmp.i + mi[d];
                int nj = tmp.j + mj[d];
                if(ni<0 || ni>=n || nj<0 || nj>=n) continue;

                if(group[ni][nj]==0) {
                    if (isOpenPossible(tmp, new Loc(ni, nj))) { // L이상 R이하라면 열어줌 = group에 포함
                        group[ni][nj] = group[tmp.i][tmp.j];
                        queue.add(new Loc(ni, nj));
                    }
                }else if(group[ni][nj] != group[tmp.i][tmp.j]){// 인접한게 방문한거긴 한데 나랑 다르면 group을 똑같게
                    unionGroup(tmp, new Loc(ni, nj));
                }

            }
        }
    }

    public static void unionGroup(Loc a, Loc b){
        int group_a = group[a.i][a.j];
        int group_b = group[b.i][b.j];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (group[i][j] == group_b) {
                    group[i][j] = group_a;
                }
            }
        }
    }

    public static boolean isOpenPossible(Loc a, Loc b){
        int diff = Math.abs(nums[a.i][a.j] - nums[b.i][b.j]);
        return diff >= L && diff <= R;
    }

}
