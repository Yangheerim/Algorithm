/*
baekjoon-10828번(sil4)

정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
명령은 총 다섯 가지이다

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

INPUT : 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

OUTPUT : 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.


 */

import java.util.Scanner;

public class Stack<P> {

    public static void main(String[] args) {

        int[] stack = new int[10000];

        int top_idx = -1;

        Scanner sc = new Scanner(System.in);
        int order_num;
        order_num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < order_num; i++) {
            String order = sc.nextLine();
            String[] tmp = order.split(" ");
            switch (tmp[0]) {
                case "push":
                    top_idx++;
//                    System.out.println("idx = "+top_idx);
                    stack[top_idx] = Integer.parseInt(tmp[1]);
                    break;
                case "pop":
                    if (top_idx >= 0) {
                        System.out.println(stack[top_idx]);
                        top_idx--;
                    }else{
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    if (top_idx >= 0) {
                        System.out.println(top_idx + 1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "empty":
                    if (top_idx == -1) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "top":
                    if(top_idx>=0) {
                        System.out.println(stack[top_idx]);
                    }else{
                        System.out.println(-1);
                    }
                    break;
            }

        }

    }
}
