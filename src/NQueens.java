import java.util.Scanner;

public class NQueens {
    public static int N;
    public static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 각 행에는 하나의 열에만 퀸이 놓여질 수 있다.
        // 1 열부터 N열까지 돌면서 각 1행 N열에 퀸을 놓았을때 가능한 경우를 확인한다.
        for(int i = 1; i <= N; i++) {
            // col 배열의 쓰임새 : col[1]에는 1번 row에 놓여있는 퀸의 위치를 저장, col[2]에는 2번 row의 ~~
            int[] col = new int[N+1]; // N * N 행렬이기에 열도 인덱스를 N 까지 갖을 수 있게 한다.

            // 1행 i열에 퀸을 놓았다.
            col[1] = i;
            // 1행 i열에 퀸을 놓았을 경우 가능한 횟수를 dfs로 구한다.
            dfs(col, 1);
        }

        System.out.println(count);
    }
    // row 행까지는 퀸을 놓았다.
    // row+1행에 퀸을 놓을수 있는지 확인한다.
    // 만약 row 값이 N 과 같다면 N 행까지 퀸을 놓았다는 말이므로 count를 1 증가시켜준다.
    public static void dfs(int[] col, int row) {
        if(row == N) {
            //print
            for(int i=1; i<=N; i++){
                System.out.print(col[i]);
            }
            System.out.println();
            count++;
        }else {
            // 1열 부터 N 열까지 반복하면서 (row+1, i)에 퀸을 놓을 수 있는경우가 있는지 확인한다.
            // 있으면 다음행의 dfs를 호출한다.
            for(int i = 1; i <= N; i++) {
                // 다음 row의 i번째 col (예를들어 지금이 2번째 row이면, 3번째 row의 1번째 되는지, 2번째 되는지) 에
                // 말을 놓을 수 있는지 확인하고, 가능하다면 그 위치(다음 row의 i번째) 재귀 호출!
                col[row+1] = i;
                if(isPossible(col, row+1)) {
                    dfs(col, row+1);
                }
            }
        }
    }

    // 1행부터 row 행까지 같은 열 혹은 대각선에 위치하는 퀸이 있는지 확인한다.
    public static boolean isPossible(int[] col, int row) {
        for(int i=1; i < row; i++) {// i 행과 row 행의 열 값이 같으면
            if(col[i] == col[row])
                return false;

            if(Math.abs(i - row) == Math.abs(col[i] - col[row]))
                return false;
        }
        return true;
    }
}
