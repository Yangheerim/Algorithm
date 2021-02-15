import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;
/*
아기상어
BFS
참고 : https://seungahyoo.tistory.com/74
 */
public class p16236 {
    static int[][] map;
    static Fish shark;
    static int n;
    static int[] mi = { -1, 1, 0, 0 };
    static int[] mj = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    shark = new Fish(i, j);
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs(){
        int shark_size = 2;
        int shark_eat = 0;
        ArrayList<Fish> eatable_fish = new ArrayList<>();
        Queue<Fish> q = new LinkedList<Fish>();
        int sec = 0;
        int total_sec = 0; // 상어가 엄마의 도움 없이 물고기를 잡아먹을 수 있는 시간(초)
        boolean[][] visited = new boolean[n][n];
        q.add(shark); // 상어의 처음 위치
        visited[shark.i][shark.j] = true;

        while(!q.isEmpty()){
            int q_size = q.size();
            int si=0, sj=0;
            for(int s=0; s<q_size; s++){ // 같은 거리만큼 떨어진 곳을 확인
                Fish shark = q.poll(); // 상어의 현재 위치
                si = shark.i;
                sj = shark.j;
                for(int d=0; d<4; d++){ // 현재 위치로부터 상하좌우 방문하지 않은 곳을 확인
                    int ni = si + mi[d];
                    int nj = sj + mj[d];

                    if(ni<0 || nj<0 || ni>=n || nj>=n) continue; // 인덱스가 벗어나면 못감
                    if(visited[ni][nj] || map[ni][nj]>shark_size) continue; // 이미 방문했거나 상어크기보다 큰 물고기가 있으면 못감

                    q.add(new Fish(ni, nj)); // 큐에 add
                    visited[ni][nj] = true;
                    if(map[ni][nj]!=0 && map[ni][nj]<shark_size){
                        eatable_fish.add(new Fish(ni, nj));
                    }
                }
            }
            sec++;

            if(!eatable_fish.isEmpty()){
                Collections.sort(eatable_fish);
                Fish meal = eatable_fish.get(0); // 먹을 물고기
                eatable_fish.clear();

                shark_eat++;
                if(shark_size == shark_eat){ // 자신의 크기만큼 물고기를 먹었으면 크기가 1 커진다
                    shark_size++;
                    shark_eat = 0;
                }

                map[si][sj] =0; // 이동할거니까 0으로 바꿔줌
                si = meal.i;
                sj = meal.j;
                map[si][sj] =9; // 이동 후 상어의 위치 업데이트

                q.clear(); // 먹은 후에는 그 지점부터 다시 bfs 순회
                q.add(meal);
                total_sec += sec;
                sec = 0;

                for(int i=0;i<n;i++) { //visit initialize
                    Arrays.fill(visited[i], false);
                }

                visited[si][sj] = true;
            }

        }

        return total_sec;
    }

    static class Fish implements Comparable<Fish>{
        int i;
        int j;
        Fish(int i, int j){
            this.i = i;
            this.j = j;
        }
        @Override
        public int compareTo(Fish o) {
            if (this.i == o.i) {
                return this.j - o.j;
            } else {
                return this.i - o.i;
            }
        }
    }
}
