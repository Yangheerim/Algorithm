import java.io.*;
/*
Dynamic Programming
dp를 활용해 fibonacci를 돌리는 방식 그대로,
0과 1이 호출되는 횟수 또한 메모리제이션 하는 방식으로 하면 된다.
0과 1을 따로 저장해둬야 하기 때문에 이중 배열을 사용함.
이 문제에서는 fib의 '값'을 구하는 것이 아니기 때문에 굳이 해주지 않아도 됨.
 */
public class p1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tk = Integer.parseInt(br.readLine());

        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        for(int j = 2; j<41; j++){
            for (int k = 0; k < 2; k++) {
                dp[j][k] = dp[j - 1][k] + dp[j - 2][k];
            }
        }

        for (int i = 0; i < tk; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n][0]+" "+dp[n][1]+"\n");
        }
        bw.flush();
    }

    // 이렇게 하면 시간초과..
//    static int fib(int n) {
//        if (n == 0) {
//            count0++;
//            return 0;
//        } else if (n == 1) {
//            count1++;
//            return 1;
//        } else {
//            return fib(n - 1) + fib(n - 2);
//        }
//    }

}
