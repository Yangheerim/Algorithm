import java.util.LinkedList;
import java.util.Queue;

public class programmers_다리를지나는트럭 {
    static class Truck{
        int weight;
        int sec;
        Truck (int w, int s){
            this.weight = w;
            this.sec = s;
        }
    }
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        solution(bridge_length, weight, truck_weights);

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waiting = new LinkedList<>();
        Queue<Truck> on_bridge = new LinkedList<>();
        for (int w : truck_weights) {
            waiting.add(new Truck(w, 0));
        }

        int time = 0;
        int now_total_weight = 0;
        // 다리를 건너기를 기다리는 트럭이 없고, 다리 위에도 트럭이 없으면 끝
        // 즉, 다리를 건너기를 기다리는 트럭이 있거나, 다리 위에 트럭이 있으면 계속 진행
        while (!waiting.isEmpty() || !on_bridge.isEmpty()) {
            time++;

            // 다리위에 비어있지 않으면,
            // 트럭이 다리 위에 올라간 시간 >= 다리의 길이
            // 조건을 만족하면 다리를 다 건너간거기 때문에 on_brige queue에서 빼준다.
            if(!on_bridge.isEmpty()){
                Truck t = on_bridge.peek(); // 참조만 (지우지 않음)
                if(time-t.sec>=bridge_length){
                    now_total_weight -= t.weight;
                    on_bridge.poll();
                }
            }

            // 기다리고 있는 트럭들이 있을 때
            // 기다리는 트럭중에 첫번째 트럭이 다리 위에 올라가도 최대 무게보다 같거나 작으면
            // on_brige에 올리고 waiting에서 뺀다
            if(!waiting.isEmpty()){
                if(now_total_weight+waiting.peek().weight<=weight){
                    Truck t = waiting.poll();
                    now_total_weight += t.weight;
                    on_bridge.offer(new Truck(t.weight, time));
                }
            }

        }
        System.out.println(time);
        return time;
    }

}
