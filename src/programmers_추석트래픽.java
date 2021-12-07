package programmers2;

import java.util.Arrays;

public class programmers_추석트래픽 {

    public static void main(String[] args) {
        String[] l = {  "2016-09-15 01:00:04.001 2.0s",
                        "2016-09-15 01:00:07.000 2s"};
        String[] l2 = {  "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        String[] l3 = {  "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        solution(l);
        solution(l2);
        solution(l3);
    }

    static class Request{
        int start;
        int end;

        public Request(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int solution(String[] lines) {

        int n = lines.length;
        Request[] requests = new Request[n];

        for (int i = 0; i < n; i++) {
            String[] tmp = lines[i].split(" ");
            int[] times = getTimes(tmp[1], tmp[2]);
            requests[i] = new Request(times[0], times[1]);
        }

        Arrays.sort(requests, (a,b) -> a.end-b.end);

        int max = 0;

        for (int i = 0; i < n; i++) {
            int start = requests[i].end;
            int limit = start + 999;

            int idx = i+1;
            int now = start;
            int cnt = 1;
            while(true){
                if(idx>=n) break;
                now = requests[idx].start;
                idx++;
                if(now>limit) {
                    continue;
                    // break 아니고 continue! end time을 기준으로 정렬해놓았기 때문에
                    // start time은 인덱스 상으로 더 뒤에 있어도 앞에있는게 있을 수 있음.
                }
                cnt++;
            }

            max = Math.max(max, cnt);
        }
        return max;
    }

    // 밀리초로 환산
    public static int[] getTimes(String endTime, String duration){

        int start = 0;
        int end = 0;

        int dur = (int) ((Double.parseDouble(duration.substring(0, duration.length() - 1)) * 1000));

        String[] time = endTime.split("\\.");
        end += Integer.parseInt(time[1]); //ms
        time = time[0].split(":");
        end += Integer.parseInt(time[0]) * 60 * 60 * 1000; //hour
        end += Integer.parseInt(time[1]) * 60 * 1000; //min
        end += Integer.parseInt(time[2]) * 1000; //sec

        start = end - dur + 1;

        return new int[]{start, end};
    }
}
