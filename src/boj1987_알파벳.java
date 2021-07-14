package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj1987_알파벳 {
    static char[][] map;
    static int r;
    static int c;
    static boolean[][] visited;
    static ArrayList<Character> arr;
    static int[] mi = {0, 0, -1, 1};
    static int[] mj = {1, -1, 0, 0};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        r = Integer.parseInt(inputs[0]);
        c = Integer.parseInt(inputs[1]);

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        arr = new ArrayList<>();
        visited = new boolean[r][c];

        visited[0][0] = true;
        arr.add(map[0][0]);

        dfs(0,0,1);

        System.out.println(result);
    }

    public static void dfs(int i, int j, int cnt){
        boolean flag = false;

        for (int d = 0; d < 4; d++) {
            int ni = i + mi[d];
            int nj = j + mj[d];

            if (ni < 0 || ni >= r || nj < 0 || nj >= c) {
                continue;
            }

            char c = map[ni][nj];

            if(!visited[ni][nj] && !arr.contains(c)){
                flag = true;
                visited[ni][nj] = true;
                arr.add(c);

                dfs(ni, nj, cnt+1);

                visited[ni][nj] = false;
                arr.remove(arr.indexOf(c));
//                arr.remove(c); // 이렇게 했더니 안됨
            }
        }

        if(!flag) {
            result = Math.max(result, cnt);
        }
    }
}
