import java.util.Arrays;
import java.util.PriorityQueue;

public class programmers_디스크컨트롤러 {

    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,9},{2,6}};
        solution(jobs);
    }

//    public static int solution(int[][] jobs) {
//
//        Job[] job_list = new Job[jobs.length];
//        for(int i=0; i< jobs.length; i++){
//            job_list[i] = new Job(jobs[i][0], jobs[i][1]);
//        }
//        Arrays.sort(job_list);
//        int answer = 0;
//        int now = 0;
//        int cnt = 0;
//        while(true) {
//            Job j = new Job(0,1001); // 소요시간이 가장 적은 job 찾기
//            for (int i = 0; i < job_list.length; i++) {
//                if(!job_list[i].completed && job_list[i].arrive_time<=now){
//                    if(job_list[i].duration<j.duration){
//                        j = job_list[i];
//                    }
//                }
//            }
//            if(j.duration == 1001) {
//                now ++;
//                continue;
//            }
//
//            now += j.duration;
//            j.completed = true;
//            cnt++;
//            answer += now - j.arrive_time;
//            if(cnt == jobs.length) break;
//        }
//        System.out.println(answer/3);
//        return answer/3;
//    }

    // https://codevang.tistory.com/316
    public static int solution(int[][] jobs) {

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int answer = 0;
        int now = 0;
        int cnt = 0;
        int job_idx=0;

        while (cnt<jobs.length) { // 모든 job이 완료 될때까지

            // now 시점까지 들어온 모든 요청을 큐에 넣기
            while(job_idx<jobs.length && jobs[job_idx][0]<=now){
                pq.add(jobs[job_idx++]);
            }

            if(pq.isEmpty()){ // 큐에 없다 = 지금 실행가능한 job이 없다 -> 실행가능한 job 시간으로 건너뛴다!
                now = jobs[job_idx][0];
            }else{ // 큐에 있는 job 중 가장 수행시간이 짧은 요청부터 수행
                int[] temp = pq.poll();
                answer += temp[1] + now - temp[0];
                now += temp[1];
                cnt++;
            }
        }


        return (int) Math.floor(answer / jobs.length);
    }
}
