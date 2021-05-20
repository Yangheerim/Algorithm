import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1080_행렬 {
    static int[][] matA;
    static int[][] matB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        matA = new int[n][m];
        matB = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matA[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matB[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int cnt = 0;
        for (int i = 0; i <= n-3; i++) {
            for (int j = 0; j <= m-3; j++) {
                if (matA[i][j] != matB[i][j]) {
                    flip(i, j);
                    cnt++;
                }
            }
        }
        if(isSameMat(n, m)){
            System.out.println(cnt);
        }else{
            System.out.println(-1);
        }

    }

    public static boolean isSameMat(int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matA[i][j]!=matB[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void flip(int start_i, int start_j) {
        for (int i = start_i; i < start_i + 3; i++) {
            for (int j = start_j; j < start_j + 3; j++) {
                matA[i][j] = 1 - matA[i][j];
            }
        }
    }
}
