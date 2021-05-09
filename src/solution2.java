import java.util.ArrayList;
import java.util.PriorityQueue;

public class solution2 {
    public static void main(String[] args) {
        int[] t = {2,3,3,2,1,2};
        int[] r = {0,1,2,3,1,1};
        solution(t, r);
    }

    static class Person implements Comparable<Person> {
        int idx;
        int arrive_time;
        int priority;

        public Person(int idx, int arrive_time, int priority) {
            this.idx = idx;
            this.arrive_time = arrive_time;
            this.priority = priority;
        }

        @Override
        public int compareTo(Person o) {
            if(this.priority < o.priority){
                return -1;
            }else if(this.priority > o.priority){
                return 1;
            }else{
                if(this.arrive_time < o.arrive_time){
                    return -1;
                }else if(this.arrive_time > o.arrive_time){
                    return 1;
                }
                return this.idx < o.idx ? -1: 1;
            }

        }
    }
    public static int[] solution(int[] t, int[] r) {
        int[] answer = new int[t.length];

        ArrayList<Person> people = new ArrayList<>();
        for(int i=0; i<t.length; i++){
            people.add(new Person(i, t[i], r[i]));
        }

//        PriorityQueue<Person> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.priority, p2.priority));
        PriorityQueue<Person> pq = new PriorityQueue<>();

        int time = 0;
        int order = 0;
        while(order<t.length){
            for (int i=0; i<people.size(); i++) {
                Person tmp = people.get(i);
                if(tmp.arrive_time==time){
                    pq.add(tmp);
                }
            }
            if(!pq.isEmpty()){
                answer[order] = pq.poll().idx;
                System.out.println(answer[order]);
                order++;
            }
            time++;
        }


        return answer;
    }


}
