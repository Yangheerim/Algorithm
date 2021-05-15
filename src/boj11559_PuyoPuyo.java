import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj11559_PuyoPuyo {

    static class Loc {
        int i;
        int j;

        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static Character[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 12 * 6 map
        map = new Character[12][6];

        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 4개 이상 붙어있는 블록이 있는지 탐색

        boolean[][] visited;
        int[] mi = {0, 0, 1, -1};
        int[] mj = {1, -1, 0, 0};

        int pop_cnt = 0;
        boolean isEnd = true;

        while(true) {
            visited = new boolean[12][6];
            isEnd = true;

            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {

                    if (!visited[i][j] && map[i][j] != '.') {
                        Queue<Loc> queue = new LinkedList<>();
                        ArrayList<Loc> pop_list = new ArrayList<>();
                        queue.add(new Loc(i, j));
                        visited[i][j] = true;
                        char c = map[i][j];

                        while (!queue.isEmpty()) {
                            Loc tmp = queue.poll();
                            pop_list.add(tmp);

                            for (int d = 0; d < 4; d++) {
                                int ni = tmp.i + mi[d];
                                int nj = tmp.j + mj[d];
                                if (ni < 0 || nj < 0 || ni > 11 || nj > 5) continue;
                                if (map[ni][nj] == c && !visited[ni][nj]) {
                                    queue.add(new Loc(ni, nj));
                                    visited[ni][nj] = true;
                                }
                            }
                        }

                        if (pop_list.size() >= 4) {
                            // 블록 터트림
                            popBlocks(pop_list);
                            pop_list.clear();
                            isEnd = false;
                        }
                    }
                }
            }
            if (isEnd) {
                break;
            }
            pop_cnt++;
            relocationBlocks();
        }
        System.out.println(pop_cnt);
    }

    public static void popBlocks(ArrayList<Loc> pop_list) {
        for (Loc l : pop_list) {
            map[l.i][l.j] = '.';
        }
    }

    public static void relocationBlocks() {
        // 빈 공간이 있으면 중력에 의해 밑으로 떨어짐

        // 이렇게 하면 시간초과 ,,,
//        int empty_cnt = 0;
//        for (int i = 0; i < 6; i++) {
//            empty_cnt = 0;
//            for (int j = 11; j >= 0; j--) {
////                System.out.println("j="+j+", i="+i);
//                if (map[j][i] == '.') {
//                    empty_cnt++;
//                } else if (empty_cnt > 0) { // 인형이 있는데 밑에가 비어있으면
//                    for (int k = j; k >= empty_cnt; k--) {
//                        map[k + empty_cnt][i] = map[k][i];
//                    }
//                    j = 11;
//                    empty_cnt = 0;
//                }
//            }
//        }


        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {

                if (map[j][i] == '.') { // 비었으면 위에꺼 내림 (하나씩!)

                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }


//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 6; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }

}
