package programmers;

public class programmers_합승택시요금 {
    public static final int INF = 60000001;

    public int solution(int n, int s, int a, int b, int[][] fares) {

        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < fares.length; i++) {
            int n1 = fares[i][0];
            int n2 = fares[i][1];
            int w = fares[i][2];

            map[n1][n2] = w;
            map[n2][n1] = w;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j) continue;
                map[i][j]= INF;
            }
        }
        System.out.println();
        floydWarshall(n, map); // 모든 점 -> 모든점 최단거리 구하기

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }

        int min = INF;
        for(int k=1; k<=n; k++){
            min = Math.min(min, map[s][k] + map[k][a] + map[k][b]);
        }

        return min;
    }

    public static void floydWarshall(int n, int[][] map){
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
    }

}
