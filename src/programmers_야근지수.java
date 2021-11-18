package programmers2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class programmers_야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }

        for (int i = 0; i < n; i++) {
            int max = pq.poll();
            if(max<=0) break;
            pq.add(max - 1);
        }

        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }
}
