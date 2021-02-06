import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17144 {
    static int[][] map;
    static int[][] next_map;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map = new int[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] moveI = {-1,1,0,0};
        int[] moveJ = {0,0,-1,1};

        for(int sec = 0; sec<t; sec++) {
            next_map = new int[r + 1][c + 1];
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    next_map[i][j] = map[i][j];
                }
            }
            //1. 각 구역 별 갈 수 있는 방향 체크
            //2. /5해서 갈수있는 방향에 더하기, 확산된 만큼 원래에서 빼기
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    int diffuse = map[i][j] / 5;
                    for (int d = 0; d < 4; d++) {
                        int next_i = i + moveI[d];
                        int next_j = j + moveJ[d];
                        if (isPossibleDirection(next_i, next_j)) {
                            next_map[next_i][next_j] += diffuse;
                            next_map[i][j] -= diffuse;
                        }
                    }
                }
            }
            //3. 공기청정기 가동
            for (int i = 1; i <= r; i++) {
                if (map[i][1] == -1) {
                    next_map[i][1] = -1;
                    next_map[i + 1][1] = -1;
                    map = next_map;
                    airPuri(i);
                    break;
                }
            }
        }
        // Result
        int sum = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if(map[i][j] == -1) continue;
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }
    public static void airPuri(int start){
        // (start, 1~2) -> 공기청정기 위치
        // 위쪽(반시계)
        for (int i = start - 1; i > 1; i--) {
            map[i][1] = map[i - 1][1];
        }
        for(int j=1; j<c; j++){
            map[1][j] = map[1][j + 1];
        }
        for(int i=1; i<start; i++){
            map[i][c] = map[i + 1][c];
        }
        for(int j=c; j>2; j--){
            map[start][j] = map[start][j - 1];
        }
        map[start][2] = 0;

        start ++;
        // 아래쪽(시계)
        for(int i=start+1; i<r; i++){
            map[i][1] = map[i + 1][1];
        }
        for(int j=1; j<c; j++){
            map[r][j] = map[r][j + 1];
        }
        for(int i=r; i>start; i--){
            map[i][c] = map[i - 1][c];
        }
        for(int j=c; j>2; j--){
            map[start][j] = map[start][j - 1];
        }
        map[start][2] = 0;
    }

    public static boolean isPossibleDirection(int i, int j){
        if(i<1 || i>r){
            return false;
        }
        if(j<1 || j>c){
            return false;
        }
        if (map[i][j] == -1) {
            return false;
        }
        return true;
    }

//    static void test(int sec) {
//        System.out.println("-------------"+sec+"-------------");
//        System.out.println("map: ");
//        for (int i = 1; i <= r; i++) {
//            for (int j = 1; j <= c; j++) {
//                System.out.print(map[i][j]+"\t");
//            }
//            System.out.println();
//        }
//        System.out.println("next map: ");
//        for (int i = 1; i <= r; i++) {
//            for (int j = 1; j <= c; j++) {
//                System.out.print(next_map[i][j]+"\t");
//            }
//            System.out.println();
//        }
//    }

}
