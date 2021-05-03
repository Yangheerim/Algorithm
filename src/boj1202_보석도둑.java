import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 참고 : https://devowen.com/300
// 가방에 넣을 수 있는 것들중에 가장 비싼거를 고른다! 시간초과 때문에 priority queue 사용
// sum은 최대 100,000,000개의 가방에 1,000,000의 무게씩 들어갈 수 있으므로 long타입 사용

public class boj1202_보석도둑 {
    static class Jew implements Comparable<Jew>{
        int weight;
        int price;

        public Jew(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jew o) {
            return this.weight - o.weight; // weight 오름차순
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Jew> jews = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jews.add(new Jew(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        ArrayList<Integer> bags = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(jews, (j1, j2) -> Integer.compare(j1.weight, j2.weight)); // 오름차순
        Collections.sort(bags, (b1, b2) -> Integer.compare(b1, b2)); // 오름차순

        long sum = 0;
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x)); // 내림차순
        for (int i = 0; i < k; i++) {
            while (idx < n && jews.get(idx).weight <= bags.get(i)) {
                pq.add(jews.get(idx).price);
                idx++;
            }
            if (!pq.isEmpty()) sum += pq.poll();
        }

        System.out.println(sum);
    }
}
