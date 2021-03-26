public class programmers_등굣길 {
    // 참고 : https://velog.io/@ajufresh/%EB%93%B1%EA%B5%A3%EA%B8%B8
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];

        for(int[] puddle : puddles){
            map[puddle[1]][puddle[0]] = -1;
        }

        map[1][1] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j] == -1){
                    map[i][j] = 0;
                    continue;
                }
                if(i != 0)
                    map[i][j] += map[i - 1][j] % 1000000007; // 숫자가 이 값을 초과할 수 있기 때문에 계산 과정에서 나머지 구하기

                if(j != 0)
                    map[i][j] += map[i][j - 1] % 1000000007; // 왼쪽

            }
        }

        return map[n][m] % 1000000007;
    }
}
