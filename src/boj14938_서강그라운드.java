package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14938_서강그라운드 {
    public static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int r = Integer.parseInt(inputs[2]);

        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j) continue;
                map[i][j] = INF;
            }
        }

        int[] item_num = new int[n + 1];
        inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            item_num[i + 1] = Integer.parseInt(inputs[i]);
        }

        for (int i = 0; i < r; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int w = Integer.parseInt(inputs[2]);

            map[a][b] = w;
            map[b][a] = w;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        // print result
        int result = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt=0;
            for (int j = 1; j <= n; j++) {
                if(map[i][j]<=m){
                    cnt += item_num[j];
                }
            }
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }
}
