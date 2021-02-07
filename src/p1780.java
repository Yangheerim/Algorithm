import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
9개로 쪼개며 확인하는 divide & conquer 문제
 */
public class p1780 {
    static int[] result = new int[3]; // [0]:-1. [1]:0, [2]:1
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //input
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, n);
        for(int i=0; i<3; i++){
            System.out.println(result[i]);
        }
    }
    // 종이 내 숫자가 다 같은 수인지 알아내는 함수
    static public boolean isAllSame(int x, int y,  int n){
        int num = matrix[x][y];
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(num != matrix[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    // 나누는 함수
    static public void divide(int x, int y,  int n){
        if(isAllSame(x, y, n) || n==1){
            result[matrix[x][y]+1] += 1;
            return;
        }

        // 9개로 나눔
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                divide(x+(n/3)*i, y+(n/3)*j, n/3);
            }
        }
    }
}
