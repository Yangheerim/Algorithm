/*
baekjoon-10866번(sil4)

정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
명령은 총 여덟 가지이다.

push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

INPUT : 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

OUTPUT : 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

 */

import java.util.Scanner;

public class Deque {
    static int[] deque = new int[10000];
    static int front_idx = -1;
    static int end_idx = -1;

    public static void moveDataToFront(){
        for(int i=front_idx+1; i>0; i--){
            deque[i]=deque[i-1];
        }
        front_idx++;
//        print();
    }

    public static void moveDataToBack(){
        for(int i=0; i<front_idx; i++){
            deque[i]=deque[i+1];
        }
        front_idx--;
//        print();
    }
//    public static void print(){
//        for(int i=0; i<=front_idx; i++){
//            System.out.print(queue[i]+" ");
//        }
//        System.out.println("\n");
//    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int order_num;
        order_num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < order_num; i++) {
            String order = sc.nextLine();
            String[] tmp = order.split(" ");
            switch (tmp[0]) {
                case "push_front":
                    if (front_idx == -1 && end_idx == -1) { // 데이터가 없으면
                        front_idx++;
                        end_idx++;
                        deque[front_idx] = Integer.parseInt(tmp[1]);
                    }else{
                        front_idx++;
                        deque[front_idx] = Integer.parseInt(tmp[1]);
                    }
                    break;
                case "push_back":
                    if (front_idx == -1 && end_idx == -1) { // 데이터가 없으면
                        front_idx++;
                        end_idx++;
                        deque[end_idx] = Integer.parseInt(tmp[1]);
                    }else{
                        moveDataToFront();
                        deque[end_idx] = Integer.parseInt(tmp[1]);
                    }
                    break;
                case "pop_front":
                    if (front_idx != -1) {
                        System.out.println(deque[front_idx]);
                        front_idx--;
                        if (front_idx == -1 && end_idx == 0) end_idx--;
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "pop_back":
                    if (end_idx != -1) {
                        System.out.println(deque[end_idx]);
                        moveDataToBack();
                        if (front_idx == -1 && end_idx == 0) end_idx--;
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    if (front_idx >= 0) {
//                        print();
                        System.out.println(front_idx + 1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "empty":
                    if (front_idx == -1) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if (front_idx >= 0) {
//                        print();
                        System.out.println(deque[front_idx]);
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "back":
                    if (end_idx >= 0) {
//                        print();
                        System.out.println(deque[end_idx]);
                    } else {
                        System.out.println(-1);
                    }
                    break;
            }

        }

    }
}
