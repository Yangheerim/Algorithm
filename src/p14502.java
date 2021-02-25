import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
퍼지는 상태를 코드로 표현하려면 dfs를 사용해야 한다.
모든 경우를 확인해봐야했던 BruteForce 문제
 */
public class p14502 {
    static int n;
    static int m;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //i
        m = Integer.parseInt(st.nextToken()); //j

        int[][] map = new int[n + 1][m + 1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, map);
        System.out.println(max);
    }

    // dfs - 현재 위치 (i, j), count (3개 max), map?
    public static void dfs(int cnt, int[][] map) {
        if (cnt == 3) {
            spreadVirus(map);
            return;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(cnt + 1, map);
                    map[i][j]=0;
                }
            }
        }
    }

    static int[] moveI = {0,0,-1,1};
    static int[] moveJ = {-1,1,0,0};
    // 바이러스 채우기 - 2일 경우(바이러스) 상하좌우가 0이 있으면 퍼져나가도록
    public static void spreadVirus(int[][] map){
        int[][] map_copy = new int[n + 1][m + 1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                map_copy[i][j] = map[i][j];
            }
        }

        for(int i=1; i<=n; i++) {
            for (int j = 1; j <= m; j++) {
                if(map_copy[i][j] == 2){ // 바이러스가 있는 칸이면 상하좌우 확인
                    spread(i,j,map_copy);
                }
            }
        }
        int count = countSafeArea(map_copy);
        if(count>max){
            max = count;
        }
    }
    public static void spread(int i, int j, int[][] map){
        for(int d=0; d<4; d++){
            int nextI = i + moveI[d];
            int nextJ = j + moveJ[d];
            if(isPossibleSpread(nextI, nextJ, map)){
                map[nextI][nextJ] = 2;
                spread(nextI, nextJ, map);
            }
        }
    }

    public static boolean isPossibleSpread(int i, int j, int[][] map){
        if(i<1 || i>n) return false;
        if(j<1 || j>m) return false;
        if(map[i][j] != 0) return false;
        return true;
    }

    // 카운트
    public static int countSafeArea(int[][] map){
        int count = 0;
        for(int i=1; i<=n; i++) {
            for (int j = 1; j <= m; j++) {
                if(map[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
//    public static void test(int[][] map){
//        System.out.println("--------------");
//        for(int i=1; i<=n; i++) {
//            for (int j = 1; j <= m; j++) {
//                System.out.print(map[i][j]+"\t");
//            }
//            System.out.println();
//        }
//    }
}
