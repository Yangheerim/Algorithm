import java.util.Collections;
import java.util.PriorityQueue;

public class programmers_이중우선순위큐 {

    public int[] solution(String[] operations) {

        PriorityQueue<Integer> pq_min = new PriorityQueue<>();
        PriorityQueue<Integer> pq_max = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i< operations.length; i++){
            String[] ope = operations[i].split(" ");
            int a = Integer.parseInt(ope[1]);
            if(ope[0].equals("I")){
                pq_min.offer(a);
                pq_max.offer(a);
            }else{
                if(pq_max.size()==0) continue;

                if(a==1){
                    int max = pq_max.poll();
                    pq_min.remove(max);
                }else{
                    int min = pq_min.poll();
                    pq_max.remove(min);
                }
            }
        }

        int[] answer = new int[2];
        if(pq_max.size()!=0){
            answer[0] = pq_max.poll();
            answer[1] = pq_min.poll();
        }

        return answer;
    }

}
