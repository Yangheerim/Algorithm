import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2563 {
    static int[][] white_board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        white_board = new int[101][101];

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            fill(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        //print result
        int count=0;
        for(int i=1; i<101; i++){
            for(int j=1; j<101; j++){
                if(white_board[i][j]==1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    static void fill(int x, int y){
        for(int i=x; i<x+10; i++){
            for(int j=y; j<y+10; j++){
                white_board[i][j]=1;
            }
        }
    }
}
