public class programmers_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        
        for(int i=3; i<sum; i++){
            if (sum % i == 0) { // 약수이면
                int col = sum / i;
                int row = sum / col;
                
                int a = col-2;
                int b = row-2;
                
                if(a*b==yellow && col>=row){
                    answer = new int[]{col, row};
                    break;
                }
            }
        }
        return answer;
    }
}
