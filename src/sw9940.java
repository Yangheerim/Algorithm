import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class sw9940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; ++t) {
            int n = Integer.parseInt(br.readLine());
            String result = "Yes";
            String[] str = br.readLine().split(" ");
            boolean[] arr = new boolean[n + 1];
            for (int i = 0; i < n; ++i) {
                int num = Integer.parseInt(str[i]);
                arr[num] = true;
            }
            for (int i = 1; i < n + 1; ++i) {
                if (!arr[i]) {
                    result = "No";
                    break;
                }
            }
            bw.write("#" + t + " " + result + "\n");
        }
        bw.close();
        br.close();

    }
}
