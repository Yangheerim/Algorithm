import java.io.*;
import java.util.StringTokenizer;

public class p3060 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tk = Integer.parseInt(br.readLine());
        for (int i = 0; i < tk; i++) {
            long n = Integer.parseInt(br.readLine());
            long[] amount = new long[7];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 6; j++) {
                amount[j] = Long.parseLong(st.nextToken());
            }
            long sum = 0;
            for (int j = 1; j <= 6; j++) {
                sum += amount[j];
            }

            int date = 1;
            while (sum <= n) {
                date++;
                sum *= 4;
            }
            bw.write(date + "\n");
        }
        bw.flush();
    }

}
