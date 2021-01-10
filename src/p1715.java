import java.io.*;
import java.util.PriorityQueue;
/*
정렬, priority queue 사용
 */
public class p1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기본이 오름차순, 내림차순 하고싶으면 괄호 안에 Collections.reverseOrder()
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            result += sum;
            pq.offer(sum);
        }
        System.out.println(result);
    }
}
