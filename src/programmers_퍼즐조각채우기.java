package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_퍼즐조각채우기 {

    static class Loc {
        int i;
        int j;

        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int n;
    static int[] mi = {0, -1, 0, 1}; // 0,1,2,3
    static int[] mj = {1, 0, -1, 0};


    public static void main(String[] args) {

        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        System.out.println(solution(game_board, table));

    }

    public static int solution(int[][] game_board, int[][] table) {
        int cnt = 0;
        n = table.length;

        ArrayList<ArrayList<Integer>> puzzle_list = getPuzzleList(table);

        //test
        for (ArrayList<Integer> puzzle : puzzle_list) {
            for (int i = 0; i < puzzle.size(); i++) {
                System.out.print(puzzle.get(i)+" ");
            }
            System.out.println();
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (game_board[i][j] == 0) {
                    ArrayList<Integer> arr = getDirectionList(game_board, new Loc(i, j));
                    for (int t = 0; t < arr.size(); t++) {
                        System.out.print(arr.get(t)+" ");
                    }
                    System.out.println();
                    System.out.println("-----------");
                    for (ArrayList<Integer> puzzle : puzzle_list) {
                        int is_fitted = isSame(arr, puzzle);
                        if (is_fitted > 0) {
                            puzzle_list.remove(puzzle);
                            cnt += is_fitted;
                            break;
                        }
                    }

                }
            }
        }

        return cnt;
    }

    public static int isSame(ArrayList<Integer> board_direction_list, ArrayList<Integer> puzzle_direction_list) {

        if(board_direction_list.size() != puzzle_direction_list.size()) return 0;

        boolean flag = true;
        int rotate = 0;
        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            rotate = 3 * d;
            cnt = 0;
            flag = true;

            for (int i = 0; i < board_direction_list.size(); i++) {

                if (board_direction_list.get(i) != (puzzle_direction_list.get(i) + rotate) % 4) {
                    flag = false;
                    continue;
                }else{
                    cnt++;
                }

            }
            if(flag){
                return cnt;
            }
        }

        return 0;
    }

    public static ArrayList<Integer> getDirectionList(int[][] game_board, Loc start) {
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Loc> queue = new LinkedList<>();

        System.out.println("start : ("+start.i+","+start.j+")");
        queue.add(start);
        game_board[start.i][start.j] = -1;
//        result.add(-1); //start

        while (!queue.isEmpty()) {
            Loc now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];

                if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;

                if (game_board[ni][nj] == 0) {
                    queue.add(new Loc(ni, nj));
                    game_board[ni][nj] = -1;
                    result.add(d);
                }

            }
        }

        return result;
    }


    public static ArrayList<ArrayList<Integer>> getPuzzleList(int[][] table) {
        // BFS

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1) {

                    ArrayList<Integer> puzzle_directions = new ArrayList<>();
//                    boolean[][] visited = new boolean[n][n];

                    Queue<Loc> queue = new LinkedList<>();
                    queue.add(new Loc(i, j));
//                    visited[i][j] = true;
                    table[i][j] = 0;
//                    puzzle_directions.add(-1); //start

                    while (!queue.isEmpty()) {
                        Loc now = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int ni = now.i + mi[d];
                            int nj = now.j + mj[d];

                            if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;

                            if (table[ni][nj] == 1) {
                                queue.add(new Loc(ni, nj));
                                table[ni][nj] = 0;
                                puzzle_directions.add(d);
                            }

                        }
                    }
                    result.add(puzzle_directions);
                }
            }
        }

        return result;
    }

}
