package programmers2;

import java.util.Collections;
import java.util.PriorityQueue;

public class programmers_이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};

        PriorityQueue<Integer> pq_min = new PriorityQueue<>();
        PriorityQueue<Integer> pq_max = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<operations.length; i++){
            String[] tmp = operations[i].split(" ");
            if(tmp[0].charAt(0)=='I'){
                pq_min.add(Integer.parseInt(tmp[1]));
                pq_max.add(Integer.parseInt(tmp[1]));
            }else{
                if(pq_max.isEmpty() || pq_min.isEmpty()) continue;
                if (tmp[1].equals("1")) {
                    int max = pq_max.poll();
                    pq_min.remove(max);
                }else{
                    int min = pq_min.poll();
                    pq_max.remove(min);
                }
            }
        }

        return pq_max.isEmpty() ? answer : new int[]{pq_max.poll(), pq_min.poll()};
    }
}
