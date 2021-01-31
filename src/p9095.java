import java.io.*;

/*
Dynamic programming
참고 : https://fbtmdwhd33.tistory.com/73, https://whereisusb.tistory.com/265
단순하게, 1의 경우의수는 {1}, 2의 경우의 수는 {1+1, 2}, 3의 경우의 수는 {1+1+1, 2+1, 1+2, 3}
예를 들어 4를 만드는 방법은 1+3, 2+2, 3+1이 있는데,
각각의 경우에수에서 그냥 더해주면 된다!
1이 되는 경우의 수 {1}에서 4을 만드려면 {1+3}을 해주고
2가 되는 경우의 수 {1+1, 2}에서 4을 만드려면 {1+1+2, 2+2}를 해주고
3이 되는 경우의 수 {1+1+1, 2+1, 1+2, 3}에서 4를 만드려면 {1+1+1+1, 2+1+1, 1+2+1, 3+1}가 되는 식!
따라서 경우의 수의 '수'는 변함이 없게된다.
점화식은 dp[n] = dp[n-1]+dp[n-2]+dp[n-3]
 */
public class p9095 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tk = Integer.parseInt(br.readLine());
        dp = new int[12];
        for (int i = 0; i < tk; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(cal(n)+"\n");
        }
        bw.flush();
    }

    public static int cal(int n){
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        if(n>3){
            return cal(n - 1) + cal(n - 2) + cal(n - 3);
        }
        return dp[n];
    }

}


