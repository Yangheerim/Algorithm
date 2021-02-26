import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*
Heap
효율성을 높이기 위해 priority queue를 써야한다~
참고 : https://hzoou.tistory.com/141
 */
public class programmers_더맵게 {

    public static void main(String[] args) {
        int[] scovile = {1, 2, 3, 9, 10, 12};
        solution(scovile, 7);
    }

    // 이렇게 하면 효율성 ok~
    public static int solution(int[] scoville, int K) {

        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }

        while (pq.peek() < K) {
            int mixed = pq.poll() + pq.poll() * 2;
            pq.add(mixed);
            count++;
            if (pq.size() == 1 && pq.peek() < K) return -1;
        }

        System.out.println(count);
        return count;
    }

    // 이렇게 하면 효율성 제로
    public static int solution2(int[] scoville, int K) {

        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int s : scoville) {
            arr.add(s);
        }
        Collections.sort(arr);
        while (arr.get(0) < K) {
            arr.add(arr.get(0) + arr.get(1) * 2);
            arr.remove(0); // index 0
            arr.remove(0); // index 1
            count++;

            Collections.sort(arr);

            if (arr.size() == 1 && arr.get(0) < K) return -1;
        }

        System.out.println(count);
        return count;
    }

}
