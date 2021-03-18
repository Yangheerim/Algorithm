import java.util.ArrayList;
import java.util.Stack;

public class programmers_기능개발 {
    public static void main(String[] args) {
        int[] p = {93, 30, 55};
        int[] s = {1, 30, 5};
        solution(p, s);
    }
    public static int[] solution(int[] progresses, int[] speeds) {

        Stack<Integer> stack = new Stack<>();
        for(int i=progresses.length-1; i>=0; i--){
            int progress = progresses[i];
            int speed = speeds[i];
            int day_cnt = 0;
            while(true){
                progress += speed;
                day_cnt++;
                if(progress>=100){
                    break;
                }
            }
            stack.push(day_cnt);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            int cnt = 1;
            while(!stack.isEmpty() && stack.peek()<=cur){ 
                stack.pop();
                cnt++;
            }
            result.add(cnt);
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
