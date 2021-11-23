package programmers2;

public class programmers_2n타일링 {
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    public int solution(int n) {

        map = new int[2][n];
        visited = new boolean[2][n];
        cnt = 0;

        putTiles(0, n);

        return cnt;
    }

    public static void putTiles(int j, int n){

        if(j==n){
            cnt++;
            return;
        }

        // 세로
        visited[0][j] = visited[1][j] = true;
        putTiles(j+1, n);
        visited[0][j] = visited[1][j] = false;

        if(j+1>=n){
            return;
        }

        // 가로
        visited[0][j] = visited[0][j+1] = true;
        visited[1][j] = visited[1][j+1] = true;
        putTiles(j+2, n);
        visited[0][j] = visited[0][j+1] = false;
        visited[1][j] = visited[1][j+1] = false;
    }
}
