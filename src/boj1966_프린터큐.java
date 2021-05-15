import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1966_프린터큐 {

    static class Task{
        int idx;
        int priority;

        public Task(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tk = Integer.parseInt(br.readLine());

        for (int i = 0; i < tk; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // task 개수
            Task[] tasks = new Task[n];
            int target = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tasks[j] = new Task(j, Integer.parseInt(st.nextToken()));
            }

            bw.write(findTargetPrintTime(tasks, target)+"\n");

        }
        bw.flush();
    }

    // target index를 가진 task가 완료되는 시간을 리턴
    public static int findTargetPrintTime(Task[] tasks, int target){
        Queue<Task> queue = new LinkedList<>(Arrays.asList(tasks));

        int time = 1;
        while (!queue.isEmpty()) {
            Task now = queue.poll();
            boolean flag_is_exist_high_priority = false;
            for (Task queue_task : queue) {
                if(queue_task.priority>now.priority){
                    flag_is_exist_high_priority = true;
                    break;
                }
            }
            if(flag_is_exist_high_priority){
                queue.add(now);
            }else{
                if(now.idx == target){
                    return time;
                }
                time++;
            }

        }
        return -1;

    }

}
