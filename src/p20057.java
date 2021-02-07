import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p20057 {

    static double[][] sendpercent;
    static int[][] map;
    static int sendout = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 흩뿌려지는 모래 비율 배열
        sendpercent = new double[5][5];
        initSendPercent();

        int nowI = n / 2;
        int nowJ = n / 2;

        int[] moveI = {0,1,0,-1};
        int[] moveJ = {-1,0,1,0};

        // 토네이도 이동 (상/하/좌/우) -> 모래도 이동
        int d = 0; // 0: 좌, 1: 하, 2: 우, 3: 상
        for (int i = 1; i <= n; i++) {
            for(int j = 0; j<2; j++) {
                for(int k=0; k<i; k++) {
                    if(nowI==0 && nowJ==0) break;

                    int nextI = nowI + moveI[d % 4];
                    int nextJ = nowJ + moveJ[d % 4];
                    int send = map[nextI][nextJ];
                    map[nowI][nowJ] = 0;
                    map[nextI][nextJ] = 0;

                    moveSend(nextI, nextJ, send);
                    nowI = nextI;
                    nowJ = nextJ;
                }
                // percent rotate
                rotateSend();
                d++;
            }
        }
        System.out.println(sendout);
    }
//    public static void test(){
//        System.out.println("--------------------");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j]+"\t");
//            }
//            System.out.println();
//        }
//    }

    public static void moveSend(int map_i, int map_j, int send){
        int sum = 0;
        int remain_spot_i = 0;
        int remain_spot_j = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(sendpercent[i][j]==-1){
                    remain_spot_i = i;
                    remain_spot_j = j;
                    continue;
                }
                if(sendpercent[i][j]==0) continue;
                if (map_i+i-2<0 || map_i+i-2>=n || map_j+j-2<0 || map_j+j-2>=n) { // 격자 밖으로 나간 모래
                    sendout += send * sendpercent[i][j];
                    sum += send * sendpercent[i][j];
                    continue;
                }
                map[map_i + i - 2][map_j + j - 2] += send * sendpercent[i][j];
                sum += send * sendpercent[i][j];
            }
        }
        if (map_i + remain_spot_i - 2 < 0 || map_i + remain_spot_i - 2 >= n || map_j + remain_spot_j - 2 < 0 || map_j + remain_spot_j - 2 >= n) {
            sendout+= send-sum;
            return;
        }
        map[map_i+remain_spot_i-2][map_j+remain_spot_j-2] += send-sum;
    }
    public static void initSendPercent(){
        sendpercent[0][2] = sendpercent[4][2] = 0.02;
        sendpercent[1][2] = sendpercent[3][2] = 0.07;
        sendpercent[1][1] = sendpercent[3][1] = 0.1;
        sendpercent[1][3] = sendpercent[3][3] = 0.01;
        sendpercent[2][0] = 0.05;
        sendpercent[2][1] = -1;
    }

    public static void rotateSend(){
        double[][] B = new double[5][5];

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                B[i][j] = sendpercent[j][4-i];
            }
        }
        sendpercent = B;
    }
}
