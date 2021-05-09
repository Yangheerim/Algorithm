import java.util.ArrayList;

public class programmers_행렬테두리회전하기 {

    public static void main(String[] args) {
        int[][] queries = {
                {2,2,5,4},
                {3,3,6,6},
                {5,1,6,3}
        };
        solution(6, 6, queries);
    }

    static int[][] map;
    public static int[] solution(int rows, int columns, int[][] queries) {

        map = new int[rows+1][columns+1];
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("-----------------");

        ArrayList<Integer> mins = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] tmp = queries[i];
            mins.add(rotate(tmp[0], tmp[1], tmp[2], tmp[3]));
        }
        int[] answer = new int[mins.size()];
        for (int i = 0; i < mins.size(); i++) {
            answer[i] = mins.get(i);
        }
        return answer;
    }

    public static int rotate(int i1, int j1, int i2, int j2) {

        int min = Integer.MAX_VALUE;

        int tmp = map[i1][j1];
        for (int i = i1; i < i2; i++) {
            map[i][j1] = map[i + 1][j1];
            min = Math.min(min, map[i][j1]);
        }
        for (int j = j1; j < j2; j++) {
            map[i2][j] = map[i2][j+1];
            min = Math.min(min, map[i2][j]);
        }
        for (int i = i2; i > i1; i--) {
            map[i][j2] = map[i - 1][j2];
            min = Math.min(min, map[i][j2]);
        }
        for (int j = j2; j > j1; j--) {
            map[i1][j] = map[i1][j-1];
            min = Math.min(min, map[i1][j]);
        }
        map[i1][j1+1] = tmp;
        min = Math.min(min, map[i1][j1+1]);

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("-----------------");

        return min;
    }
}
