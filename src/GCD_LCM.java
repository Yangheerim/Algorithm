import java.util.Scanner;


/*
baekjoon-2609(sil4)

두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

INPUT : 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
OUTPUT : 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

if
24 18

6
72

 */

public class GCD_LCM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        System.out.println(gcd(n1, n2));
        System.out.println(lcm(n1, n2));
    }

    public static int gcd(int a, int b) {

        if (b == 0) return a;
        int r = a % b;
        return gcd(b, r);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
