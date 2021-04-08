public class progrmmers_순위 {
    //https://in-intuition.tistory.com/25
    public int solution(int n, int[][] results) {
        boolean[][] game =  new boolean[n][n];
        int answer = 0;
        for(int i=0; i<results.length; i++){
            game[results[i][0]-1][results[i][1]-1]=true;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(game[j][i] && game[i][k]){ //j->i 이고 i->k 이면 j->k이다!
                        game[j][k]=true;
                    }
                }
            }
        }

        // 결과 계산
        for(int i=0; i<n; i++){
            int result=0;
            for(int j=0; j<n; j++){
                if(game[i][j] || game[j][i]){
                    result++;
                }
            }
            if(result==n-1){
                answer++;
            }
        }
        return answer;
    }

}
