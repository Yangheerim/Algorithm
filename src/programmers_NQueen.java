package programmers2;

public class programmers_NQueen {

    static int count;
    static int[] queen;
    static int N;

    public int solution(int n) {

        count = 0;
        queen = new int[n];
        N = n;

        dfs(0);

        return count;
    }

    private static void dfs(int row){
        if(row == N){
            count++;
            return;
        }
        for(int col=0; col<N; col++){
            if(isPossible(row, col)){
                queen[row] = col;   // row행의 col번째 칸에 퀸 놓음
                dfs(row+1);
            }
        }
    }

    private static boolean isPossible(int row, int col){ // 이 row의 col 위치에 퀸을 놓을 수 있는지 확인

        for(int i=0; i<row; i++){
            // 같은 col에 퀸이 이미 있거나
            if(queen[i]==col) return false;

            // 대각선에 있으면 false
            if (Math.abs(i - row) == Math.abs(queen[i] - col)) { // row의 diff와 col의 diff가 같으면 대각선
                return false;
            }
        }

        return true;
    }

}
