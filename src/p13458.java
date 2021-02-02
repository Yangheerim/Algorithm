import java.io.*;
import java.util.StringTokenizer;
/*
알고리즘 분류 : 수학
각각의 시험장마다 총감독 무조건 1명, 부감독 n명 해서 구하는 문제
우선 총 감독이 케어할 수 있는 응시자들의 수를 뺀다.
그 뺀 수가 0보다 크면 부감독이 얼마나 들어가야하는지 구한다.
- 나누기를 하면 알수 있음. 나누어 떨어지면 딱 나눈만큼, 나누어 떨어지지 않으면 +1
다만, 각 시험장의 응시자 수 (최대 1,000,000명) * 감독 수 (최대 1,000,000+a)하면 int형으로 불가하므로 long으로 계산.
 */
public class p13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] test = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            test[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int max_main = Integer.parseInt(st.nextToken());
        int max_sub = Integer.parseInt(st.nextToken());

        long sum = 0;
        for(int i=0; i<n; i++){
            long count = 0;
            int student = test[i];

            // 총은 무조건 하나 있음.
            student -= max_main;
            count++;

            if(student>0){
                count += student / max_sub;
                if(student % max_sub != 0){
                    count++;
                }
            }
            sum += count;

        }
        System.out.println(sum);
    }
}
