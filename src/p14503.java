import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14503 {
    static int n;
    static int m;
    static int[][] map;
    // 해당 방향에서 왼쪽방향이 되기 위해 더해주는 값!
    static int[] moveI = {0, -1, 0, 1};
    static int[] moveJ = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //i
        m = Integer.parseInt(st.nextToken()); //j

        st = new StringTokenizer(br.readLine());
        // 현재 로봇청소기의 위치와 방향
        int now_i = Integer.parseInt(st.nextToken());
        int now_j = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 0:북, 1:동, 2:남, 3:서

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        robotAction(now_i, now_j, d,0);

        System.out.println(result());
    }
    public static void robotAction(int i, int j, int d, int rotate_cnt) {
        if (rotate_cnt == 4) {
            int idx = (d+3)%4;
            int back_i = i+moveI[idx];
            int back_j = j+moveJ[idx];
            if (map[back_i][back_j]==1) return;

            robotAction(back_i, back_j, d, 0);

        } else {
            map[i][j] = 2; // 현재 위치 청소
            int left_i = i + moveI[d];
            int left_j = j + moveJ[d];
            d = (d + 3) % 4;
            if(map[left_i][left_j] != 0){
                robotAction(i, j, d, rotate_cnt + 1);
            }else{ //map[left_i][left_j] == 0
                robotAction(left_i, left_j, d, 0);
            }
        }
    }

    public static int result(){
        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] ==2) cnt++;
            }
        }
        return cnt;
    }

}
