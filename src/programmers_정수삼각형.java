public class programmers_정수삼각형 {

    public static void main(String[] args) {
        int[][] a = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        solution(a);
    }

    public static int solution(int[][] triangle) {
        int n = triangle.length;

        int[][] map = new int[n][n];
        map[0][0] = triangle[0][0];

        for(int i=0; i<n-1; i++){
            for(int j=0; j<=i; j++){
                map[i + 1][j] = Math.max(map[i][j] + triangle[i + 1][j], map[i+1][j]);
                map[i + 1][j + 1] = map[i][j] + triangle[i + 1][j + 1];
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, map[n - 1][i]);
        }
        return max;
    }
}
