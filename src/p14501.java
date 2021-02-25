import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
Dynamic Programming
i번째 날에 벌 수 있는 최대 페이를 dp를 이용하여 구하면 된다.
 */
public class p14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int days = Integer.parseInt(br.readLine());
        Work[] works = new Work[days + 1];

        for (int i = 1; i <= days; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp_time = Integer.parseInt(st.nextToken());
            int tmp_pay = Integer.parseInt(st.nextToken());

            works[i] = new Work(tmp_time, tmp_pay);
        }
        int[] dp = new int[days + 2];
        //test
//        for(int j = 1; j<=days+1; j++){
//            System.out.print(dp[j]+" ");
//        }
//        System.out.println();
        for (int i = 1; i <= days; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            if(i+works[i].time<=days+1)
                dp[i + works[i].time] = Math.max(dp[i + works[i].time], dp[i] + works[i].pay);
            //test
//            for(int j = 0; j<=days+1; j++){
//                System.out.print(dp[j]+" ");
//            }
//            System.out.println();
        }
        System.out.println(dp[days+1]);
    }

    static class Work{
        int time;
        int pay;

        Work(int time, int pay){
            this.time = time;
            this.pay = pay;
        }
    }
}
