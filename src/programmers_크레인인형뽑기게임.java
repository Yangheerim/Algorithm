import java.util.Stack;
public class programmers_크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<moves.length; i++){
            int doll = getTopDoll(board, moves[i]);
            if(doll == 0) continue;
            if(stack.size()==0) {
                stack.push(doll);
                continue;
            }
            if(stack.peek() == doll){
                cnt += 2;
                stack.pop();
                continue;
            }
            stack.push(doll);

        }
        System.out.println(cnt);
        return cnt;
    }

    public static int getTopDoll(int[][] board, int idx){
        int result = 0;
        for(int i=0; i<board.length; i++){
            if(board[i][idx-1] != 0){
                result = board[i][idx-1];
                board[i][idx-1] = 0;
                break;
            }
        }
        return result;
    }
}
