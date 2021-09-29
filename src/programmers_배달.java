package programmers;

public class programmers_배달 {

    public static void main(String[] args) {



    }

    static final int INF = 1000001;
    public int solution(int N, int[][] road, int K) {

        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j) continue;
                map[i][j] = INF;
            }
        }

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];

            if (map[a][b] > w) {
                map[a][b] = w;
                map[b][a] = w;
            }

        }

        int[] dist = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            dist[i] = (dist[i]==0) ? INF : map[1][i];
        }

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        for (int i = 1; i <= N - 1; i++) { // n-1번 반복

            // extract-min
            int min_idx = 1;
            int min_value = INF;
            for (int j = 2; j <= N; j++) {
                if (!visited[j] && dist[j] < min_value) {
                    min_value = dist[j];
                    min_idx = j;
                }
            }

            visited[min_idx] = true;

            for (int j = 2; j <= N; j++) {
                if (dist[j] > dist[min_idx] + map[min_idx][j]) {
                    dist[j] = dist[min_idx] + map[min_idx][j];
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            System.out.println(dist[i]);
            if(dist[i]>=K) answer ++;
        }


        return answer;
    }
}
