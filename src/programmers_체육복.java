public class programmers_체육복 {
    public static void main(String[] args) {
        int[] a = {2, 3, 4};
        int[] b = {1, 2, 3};

        solution(5, a, b);
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        boolean[] lost_ = new boolean[n+1];
        for(int i=0; i<lost.length; i++){
            lost_[lost[i]] = true;
        }
        boolean[] reserve_ = new boolean[n+1];
        for(int i=0; i<reserve.length; i++){
            if(lost_[reserve[i]]) {
                lost_[reserve[i]] = false;
                continue;
            }
            reserve_[reserve[i]] = true;
        }

        for(int i=1; i<=n; i++){
            if(lost_[i]){
                if(i-1>=1 && reserve_[i-1]){
                    reserve_[i-1] = false;
                }else if(i+1<=n && reserve_[i+1]){
                    reserve_[i+1] = false;
                }else{
                    answer--;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}
