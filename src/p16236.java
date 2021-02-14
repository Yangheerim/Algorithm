import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p16236 {
    static class Fish{
        int i;
        int j;
        Fish(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    static int[][] map;
    static Fish shark;
    static ArrayList<Fish> fish;
    public static void main(String[] args) throws Exception {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        fish = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    shark = new Fish(i, j);
                }else if(map[i][j]!=0){
                    fish.add(new Fish(i, j));
                }
            }
        }

    }
    public static Fish findNearest(int shark_size){
        // 먹을 수 있는 물고기중에 제일 가까운거 고름
        int min_dist = Integer.MAX_VALUE;
        Fish min_loc = null;
        for(Fish f : fish){
            if(map[f.i][f.j]<shark_size){
                int d = dist(f, shark);
                if(d<min_dist){ // 더 거리가 가까우면
                    min_dist = d;
                    min_loc = f;
                }else if(d==min_dist){ // 거리가 같으면
                    if(min_loc.i>f.i){ // 새로운게 더 위쪽에 있으면
                        min_loc = f;
                    }else if(min_loc.i==f.i){
                        if(min_loc.j>f.j){ // 새로운게 더 왼쪽에 있으면
                            min_loc = f;
                        }
                    }
                }
            }
        }
        return min_loc;
    }
    public static int dist(Fish f, Fish s){
        return (f.i-s.i)*(f.i-s.i) + (f.j-s.j)*(f.j-s.j);
    }
}
