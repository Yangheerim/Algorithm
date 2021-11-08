package programmers2;

import java.util.ArrayList;

public class programmers_이진변환반복하기 {
    public static void main(String[] args) {
        solution("110010101001");
    }
    public static int[] solution(String s) {
        int step = 0;
        int count = 0;

        while(!s.equals("1")) {
            int prev_length = s.length();
            s = s.replaceAll("0", "");

            int diff = prev_length - s.length();
            count += diff;
            s = Integer.toBinaryString(s.length());
            step++;
        }


        return new int[]{step, count};
    }
}
