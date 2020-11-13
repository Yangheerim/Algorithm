import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw5607 {
    private static final int p = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tcase; t++) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int r = Integer.parseInt(line[1]);

            // n 까지의 팩토리얼을 미리 구해준다.
            long fac[] = new long[n + 1];
            fac[0] = 1;

            for (int i = 1; i <= n; i++)
                fac[i] = (fac[i - 1] * i) % p;

            // 나눌 수를 구하고(bottom)
            long bottom = (fac[r] * fac[n - r]) % p;

            // 페르마 소정리로 a^-1 과 동일한 a^p-2 를 구해준다(fermat)
            long reBottom = fermat(bottom, p - 2);

            System.out.println("#"+t+" "+(fac[n] * reBottom) % p);
        }
    }

    private static long fermat(long a, int x) {
        if (x == 0) return 1;

        long tmp = fermat(a, x / 2); // 빠른 지수승 곱셈 , 분할해서 구한당!
        long ret = (tmp * tmp) % p;     // tmp * tmp = a

        if (x % 2 == 0)
            return ret;
        else
            return (ret * a) % p;
    }
}
