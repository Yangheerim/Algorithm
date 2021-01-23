import java.io.*;
import java.util.StringTokenizer;
/*
제곱셈을 하다 보면 정수형 범위가 넘어가서 overflow되기 때문에
각각 모듈러를 해주면서 분할 계산을 한다.
예를들어 2^10 = 2^5*2^5 = 2^2*2^3 * 2^2*2^3 ... 이런식
모듈러 (a*b)%c = a%c * b%c 공식을 적용해야함.
 */
public class p1629 {
    static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        System.out.println(pow(a, b));
    }

    public static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a%c;
        }
        long half = pow(a, b / 2);
        half %= c;
        if (b % 2 == 0) {
            return (half * half) % c;
        } else {
            return ((half * half) % c * a )%c;
        }
    }
}

