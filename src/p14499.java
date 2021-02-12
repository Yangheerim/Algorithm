import java.io.*;
import java.util.StringTokenizer;
/*
주사위!
주사위를 특정 방향으로 회전시킬 때
어떤 면이 바닥으로 가고, 다른 면들은 어디로 가는지를 코드로 작성해 주면
금방 풀리는 문제.
 */
public class p14499 {
    static int n;
    static int m;
    static int[] dice;
    static int[] moveI = {0, 0, 0, -1, 1};
    static int[] moveJ = {0, 1, -1, 0, 0};
    static int[][] map;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int ii = Integer.parseInt(st.nextToken());
        int jj = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] comm = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            comm[i] = Integer.parseInt(st.nextToken());
        }
        dice = new int[7];

        move(ii, jj, comm);
        bw.flush();
    }

    static void move(int ii, int jj, int[] comm) throws IOException {

        int i = ii;
        int j = jj;

        //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
        for(int k=0; k<comm.length; k++){
            int d = 0; // 돌렸을때 주사위의 면
            if(comm[k]==1) d=3;
            else if(comm[k]==2) d=4;
            else if(comm[k]==3) d=2;
            else d=5;

            int ni = i + moveI[comm[k]];
            int nj = j + moveJ[comm[k]];

            if (ni < 0 || nj < 0 || ni >= n || nj >= m) {
                continue;
            }

            if(map[ni][nj]!=0){
                dice[d] = map[ni][nj];
                map[ni][nj]=0;
                moveDice(comm[k]);
            }else{
                map[ni][nj] = dice[d];
                moveDice(comm[k]);
            }
            i=ni;
            j=nj;
            bw.write(dice[1]+"\n");
        }
    }
    //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
    static void moveDice(int d){ // direction
        if(d==1){
            int tmp = dice[6];
            dice[6] = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[4];
            dice[4] = tmp;
        }else if(d==2){
            int tmp = dice[6];
            dice[6] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[3];
            dice[3] = tmp;
        }else if(d==3){
            int tmp = dice[6];
            dice[6] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[5];
            dice[5] = tmp;
        }else if(d==4){
            int tmp = dice[6];
            dice[6] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[2];
            dice[2] = tmp;
        }
    }
}
