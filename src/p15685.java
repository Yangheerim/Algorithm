import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
드래곤 커브
커브를 0세대, 1세대, 2세대 ... 늘려나가며 구하는 문제
좌표의 범위가 0~100이니까 총 101개이다. 100개로 생각해서 틀림.
이것 역시 방향과 시계/반시계 회전을 잘 봐야함.
또한, y의 증가 방향은 아래쪽이라고 문제에서 제시됨.
조건들을 잘 봐야할 듯!
 */
public class p15685 {
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, -1, 0, 1};
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        grid = new int[101][101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); // 시작방향
            int g = Integer.parseInt(st.nextToken()); // 세대
            makeDragonCurv(x, y, d, g);
        }
        System.out.println(calcSquares());
    }

    // d --> 0: 동 / 1: 북 / 2: 서 / 3: 남
    public static void makeDragonCurv(int xx, int yy, int d, int g) {

        ArrayList<Integer> arr = new ArrayList<>();
        int x = xx;
        int y = yy;
        grid[x][y] = 1;
        int nx = x + moveX[d];
        int ny = y + moveY[d];
        grid[nx][ny] = 1;
        x = nx;
        y = ny;
        arr.add(d);
        // g가 1세대부터 실행
        for (int i = 1; i <=g; i++) { // i는 세대를 나타냄
            int arr_length = arr.size();
            for (int j = arr_length-1; j >= 0; j--) {
                int last_d = arr.get(j); // 첫번째 값을 반환하고 제거
                d = (last_d + 1) % 4; // 시계방향 회전
                nx = x + moveX[d];
                ny = y + moveY[d];
                grid[nx][ny] = 1;
                x = nx;
                y = ny;
                arr.add(d);
            }
        }
    }

    public static int calcSquares() {
        int count = 0;
        for(int x=0; x<=99; x++){
            for(int y=0; y<=99; y++){
                if(grid[x][y]==0) continue;
                if(grid[x+1][y]==0) continue;
                if(grid[x+1][y+1]==0) continue;
                if(grid[x][y+1]==0) continue;
                count++;
            }
        }
        return count;
    }

}
