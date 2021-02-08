import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class p3190 {
    static int[] moveI = {0, -1, 0, 1};
    static int[] moveJ = {1, 0, -1, 0};
    static int second = 0;
    static int[][] map;
    static HashMap<Integer, Character> turn;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        int apple_num = Integer.parseInt(br.readLine());
        for (int i = 0; i < apple_num; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
        }
        int direc_change_num = Integer.parseInt(br.readLine());
        turn = new HashMap<>();
        for (int i = 0; i < direc_change_num; i++) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            turn.put(sec+1, st.nextToken().charAt(0));
        }
        // 0: 동, 1:북, 2: 서, 3: 남
        int d = 0; // direction
        move(1, 1, 1, 1,1, d, d);
        System.out.println(second);
    }

    public static void move(int hi, int hj, int ti, int tj, int length, int d, int td) {
        second++;
        map[hi][hj] = 1;
        if(turn.containsKey(second)){
            // change direction
            if(turn.get(second)=='L'){// 왼쪽
                d = (d + 1) % 4;
                map[hi][hj] = 10; // 꺾이는 포인트 (L)
            }else{ // 오른쪽
                d = (d + 3) % 4;
                map[hi][hj] = 11; // 꺾이는 포인트 (R)
            }
        }

        int next_hi = hi + moveI[d];
        int next_hj = hj + moveJ[d];
        int next_ti = ti, next_tj = tj;
        // 벽에 부딪히거나 자신의 몸에 부딪히면 종료
        if(next_hi<1 || next_hi>n || next_hj<1 || next_hj>n || map[next_hi][next_hj]==1){
            return;
        }

        if(map[next_hi][next_hj]!=2) { // 다음칸에 사과가 없으면
            map[next_hi][next_hj] = 1;
            if(map[ti][tj]==10){ // 왼쪽으로 꺾이는 포인트면
                td = (td + 1) % 4;
            }else if(map[ti][tj]==11){ // 오른쪽으로 꺾이는 포인트면
                td = (td + 3) % 4;
            }
            map[ti][tj] = 0;
            next_ti = ti + moveI[td];
            next_tj = tj + moveJ[td];
        }else{
            map[next_hi][next_hj] = 1;
            length++;
        }
        move(next_hi, next_hj, next_ti, next_tj, length, d, td);

    }

}
