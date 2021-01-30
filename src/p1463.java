import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
dp를 이용한 문제
참고 : https://st-lab.tistory.com/133
 */

public class p1463 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1]; // null로 초기화됨
        dp[0] = dp[1] = 0;
        System.out.println(recur(n));
//        System.out.println(recur(n, 0));
    }

    public static int recur(int n){
        if (dp[n] == null) {
            // 6으로 나눠지는 경우
            if (n % 6 == 0) {
                dp[n] = Math.min(recur(n - 1), Math.min(recur(n / 3), recur(n / 2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (n % 3 == 0) {
                dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (n % 2 == 0) {
                dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                dp[n] = recur(n - 1) + 1;
            }
        }
        return dp[n];
    }
//    public static int recur(int n, int count){
//        if(count<2){
//            return count;
//        }
//        return Math.min(recur(n / 3, count + 1 + n % 3), recur(n / 2, count + 1 + n % 2));
//    }
}
