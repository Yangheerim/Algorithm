/*
baekjoon-1978

주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

INPUT: 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
OUTPUT: 주어진 수들 중 소수의 개수를 출력한다.

if
4
1 3 5 7

3

SUCCESS!
 */


import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (isPrimeNum(arr[i])) {
                count++;
                System.out.println("==> "+arr[i]);
            }
        }
        System.out.println(count);
    }

    public static boolean isPrimeNum(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
