
public class programmers_주식가격 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            int now = prices[i];
            int cnt = 0;
            for(int j=i+1; j<prices.length; j++){
                cnt++;
                if(prices[j]<now){
                    break;
                }

            }
            answer[i] = cnt;
        }

        return answer;
    }
}
