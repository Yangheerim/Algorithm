package programmers;

public class programmers_광고삽입 {

    public static void main(String[] args) {
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        String[] logs2 = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        solution("02:03:55", "00:14:15", logs);
        solution("99:59:59", "25:00:00", logs2);

    }

    public static String solution(String play_time, String adv_time, String[] logs) {

        int play_time_sec = getSec(play_time);
        int adv_time_sec = getSec(adv_time);

        int[] logs_start_sec = new int[logs.length];
        int[] logs_end_sec = new int[logs.length];
        long[] total_time = new long[play_time_sec+1];

        for (int i = 0; i < logs.length; i++) {
            String[] s_e = logs[i].split("-");
            logs_start_sec[i] = getSec(s_e[0]);
            logs_end_sec[i] = getSec(s_e[1]);

            // total_time[x] = x 시각에 시작된 재생 구간의 개수 – x 시각에 종료된 재생구간의 개수
            total_time[logs_start_sec[i]]++;
            total_time[logs_end_sec[i]]--;
        }

        // total_time[x] = 시각 x부터 x+1까지 1초 간의 구간을 포함하는 재생 구간의 개수
        for (int i = 1; i < play_time_sec; i++) {
            total_time[i] += total_time[i - 1];
        }

        // total_time[x] = 시각 0부터 x+1까지 x+1초 간의 구간을 포함하는 누적 재생시간
        for (int i = 1; i < play_time_sec; i++) {
            total_time[i] += total_time[i - 1];
        }

        long max = total_time[adv_time_sec-1]; // 0초 부터 광고 재생 시 누적 뷰어 수
        int idx = 0;

        // 1초부터 광고 재생 시 광고가 3초라면
        // 1,2,3 시간동안 재생 된 누적 뷰어 수 total[3]-total[3-3] = total[3]-total[0]
        // 2,3,4 시간동안 재생 된 누적 뷰어 수 total[4]-total[4-3] = total[4]-total[1] ...
        for (int i = adv_time_sec; i < play_time_sec; i++) {
            long sum = total_time[i] - total_time[i - adv_time_sec];
            if(max < sum){
                max = sum;
                idx = i-adv_time_sec+1; // max_time 값이 마지막으로 업데이트될 때의 시각 i - at + 1
            }
        }

        return getStr(idx);
    }


    public static int getSec(String time) {
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        int sec = Integer.parseInt(times[2]);

        return hour*3600 + min*60 + sec;
    }

    public static String getStr(int second) {
        int hour = second/3600;
        int min = (second%3600)/60;
        int sec = (second%3600)%60;

        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

}
