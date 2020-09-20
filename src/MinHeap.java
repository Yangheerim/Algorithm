/*
baekjoon-1927번(sil1)
널리 잘 알려진 자료구조 중 최소 힙이라는 것이 있다. 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.

배열에 자연수 x를 넣는다.
배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.

INPUT : 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
입력되는 자연수는 2^31보다 작다.

OUTPUT : 입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.

 */


import java.util.ArrayList;
import java.util.Scanner;

public class MinHeap {

    public static ArrayList<Integer> heap;


    public static void main(String[] args) {
        heap = new ArrayList<>();
        heap.add(0);    // heap 노드의 index를 1부터 시작하기 위해 값을 하나 넣어준다.

        Scanner sc = new Scanner(System.in);
        int order_num;
        order_num = sc.nextInt();

        for (int i = 0; i < order_num; i++) {
            int order = sc.nextInt();
            if(order>0){
                insert(order);
            }else if (order == 0){
                int result = delete();
                System.out.println(result);
            }
        }

    }

    public static void insert(int data) {
        heap.add(data);
        int position = heap.size() - 1; // index를 맞추기 위해 임의로 넣었던 값이 하나 있으므로, 마지막 index는 size-1

        // 새로 들어온 값이 루트가 되거나, 부모<자식 일 때까지 반복
        // == position이 루트가 아니고 부모>자식이면 swap
        while (position > 1 && heap.get(position / 2) > heap.get(position)) {
            // 부모
            int tmp = heap.get(position);
            heap.set(position, heap.get(position / 2));
            heap.set(position / 2, tmp);

            position /= 2;
        }
    }

    public static int delete() {
        if (heap.size() - 1 < 1) {
            return 0;
        }

        int deleteData = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int position = 1;
        while (position * 2 < heap.size()) { //???
            int small_position = position * 2; // left node position

            // left node의 값과 right node의 값 중 더 작은값과 swap하기 때문에 비교해봄
            if (heap.size() > position * 2 + 1) { // right노드가 있으면
                // 더 작은 값을 가진 노드의 position을 겟
                small_position = heap.get(position * 2) < heap.get(position * 2 + 1) ? position * 2 : position * 2 + 1;
            }
            if (heap.get(position) > heap.get(small_position)) { // 부모 값이 더 크면 바꿔줘야함.
                int tmp = heap.get(position);
                heap.set(position, heap.get(small_position));
                heap.set(small_position, tmp);
                position = small_position;
            } else {
                break;
            }
        }
        return deleteData;
    }

}
