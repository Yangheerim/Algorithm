package programmers2;

public class programmers_멀리뛰기 {
    static int count;
    public long solution(int n) {
        count = 0;
        jump(0, n);

        return count;
    }
    private void jump(int sum, int n){
        if (sum == n) {
            count ++;
            count %= 1234567;
            return;
        }

        if(sum+1<=n){
            jump(sum+1, n);
        }
        if(sum+2<=n){
            jump(sum+2, n);
        }
    }
}
