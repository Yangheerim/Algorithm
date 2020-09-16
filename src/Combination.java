/*
baekjoon-2407번(sil2)

nCm을 출력한다.

INPUT : n과 m이 주어진다. (5 ≤ n ≤ 100, 5 ≤ m ≤ 100, m ≤ n)
OUTPUT : nCm을 출력한다.

if
100 6

1192052400

Fail... 숫자가 너무 커서 다른 방법이 필요
 */

import java.util.Scanner;

public class Combination {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;   // nCm
        n = sc.nextInt();
        m = sc.nextInt();
//        System.out.println("n, m --->"+n+", "+m);
        long result = factorial(n) / factorial(m) * factorial(n - m);
        System.out.println(result);
    }

    public static long factorial(int n){
        long result = 1;
        for(int i =1; i<=n; i++){
            result *= i;
        }
//        System.out.println(n+"/"+result);
        return result;
    }
//    https://5stralia.tistory.com/7
}
