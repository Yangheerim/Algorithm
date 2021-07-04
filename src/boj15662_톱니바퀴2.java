import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15662_톱니바퀴2 {
    static int n;
    static boolean[] visited;
    static int[][] wheels;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        wheels = new int[n+1][8];
        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }

        int tk = Integer.parseInt(br.readLine());
        for (int i = 0; i < tk; i++) {
            String[] tmp = br.readLine().split(" ");
            int wheel_num = Integer.parseInt(tmp[0]);
            int direction = Integer.parseInt(tmp[1]);

            visited = new boolean[n+1];
            compute(wheel_num, direction);
        }


        // print result
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (wheels[i][0] == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void compute(int wheel_num, int direction) {

        visited[wheel_num] = true;
        rotate(wheel_num, direction);
//        System.out.println("Rotate : "+wheel_num+"/"+(direction==-1?"cw":"ccw"));

        if (wheel_num - 1 >= 1 && !visited[wheel_num-1] && wheels[wheel_num - 1][2] != wheels[wheel_num][6+direction]) {
            compute(wheel_num - 1, direction * -1);
        }
        if (wheel_num + 1 <= n && !visited[wheel_num + 1] && wheels[wheel_num + 1][6] != wheels[wheel_num][2+direction]) {
            compute(wheel_num + 1, direction * -1);
        }

    }

    public static void rotate(int wheel_num, int direction) {
        if (direction == 1) { // cw
            int tmp = wheels[wheel_num][7];
            for (int i = 7; i >= 1; i--) {
                wheels[wheel_num][i] = wheels[wheel_num][i-1];
            }
            wheels[wheel_num][0] = tmp;
        }else{ // ccw
            int tmp = wheels[wheel_num][0];
            for (int i = 0; i < 7; i++) {
                wheels[wheel_num][i] = wheels[wheel_num][i+1];
            }
            wheels[wheel_num][7] = tmp;
        }
    }
}
