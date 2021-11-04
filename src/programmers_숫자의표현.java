package programmers2;

public class programmers_숫자의표현 {
    public int solution(int n) {
        int answer = 0;

        int sum = 0;
        for(int i=1; i<=n; i++){
            int tmp = i;
            while(sum<n){
                sum += tmp++;
            }
            if(sum==n) answer++;
            sum = 0;
        }


        return answer;
    }
}
