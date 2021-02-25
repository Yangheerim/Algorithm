import java.io.*;
import java.util.StringTokenizer;
/*
dfs or bfs 사용하는 문제.
visited 배열을 만들어 이미 카운트 된 건지 확인한다.
각각 상하좌우, 4방향 대각선까지 (index의 범위 내에서) 총 8개의 방향을 확인하면 된다.
 */
public class p4963 {
    static int[][] map;
    static boolean[][] visited;
    static int[] move_i = {-1,-1,0,1,1,1,0,-1};
    static int[] move_j = {0,1,1,1,0,-1,-1,-1};
    static int w;
    static int h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0){
                break;
            }
            map = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count =0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && map[i][j]==1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }

    static void dfs(int i, int j){
        visited[i][j] = true;
        for(int d=0; d<8; d++){
            int next_i = i + move_i[d];
            int next_j = j + move_j[d];

            if ((0 <= next_i && next_i < h) && (0 <= next_j && next_j < w)) {
                if(!visited[next_i][next_j] && map[next_i][next_j]==1){
                    dfs(next_i, next_j);
                }
            }
        }
    }

}
