package programmers2;

// 참고 : https://dev-note-97.tistory.com/236
public class programmers_자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {

        int m = key.length;
        int n = lock.length;

        int board_length = m * 2 + n - 2;
        int[][] board = new int[board_length][board_length];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i+m-1][j+m-1] = lock[i][j];
            }
        }

        int[][] new_board = new int[board_length][board_length];
        for (int r = 0; r < 4; r++) {
            for(int i = 0; i < m+n-1; i++){
                for(int j = 0; j < m+n-1; j++){

                    // 2차원 배열에 경우 array.clone() 함수를 써도, 깊은복사가 되지 않는다!!!!
                    // new_board = board.clone(); //이거 안됨ㅠ
                    for (int b = 0; b < board_length; b++) {
                        new_board[b] = board[b].clone();

                    }
                    for (int ki = 0; ki < m; ki++) {
                        for (int kj = 0; kj < m; kj++) {
                            new_board[ki + i][kj + j] += key[ki][kj];
                        }
                    }
                    if (check_board(m, n, new_board))
                        return true;
                }
            }
            key = rotate(m, key);
        }

        return false;
    }

    public static int[][] rotate(int M, int[][] key){
        int[][] new_key = new int[M][M];
        for(int i = 0; i < M; i++){
            for(int j = 0; j<M; j++){
                if(key[i][j]==1)
                    new_key[j][M - 1 - i] = 1;
                else
                    new_key[j][M - 1 - i] = 0;
            }
        }
        return new_key;
    }

    public static boolean check_board(int m, int n, int[][] board){
        for(int i = m-1; i < m-1+n; i++){
            for(int j = m-1; j < m-1+n; j++){
                if(board[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }

}
