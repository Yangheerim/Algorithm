package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class programmers_압축 {

    public static void main(String[] args) {
//        solution("KAKAO");
        solution("TOBEORNOTTOBEORTOBEORNOT");
    }

    public static int[] solution(String msg) {

        HashMap<String, Integer> map = new HashMap<>();

        // 1
        for (int i = 65; i <= 90; i++) {
            String key = (char) i + "";
            map.put(key, i-64);
        }

        int idx = 0;
        int last_num = 27;

        ArrayList<Integer> result = new ArrayList<>();

        while(true){
            // 2
            String w = msg.charAt(idx++)+"";

            while(idx<msg.length() && map.containsKey(w+msg.charAt(idx))){ // 다음 문자가 포함된 문자열이 map에 있으면
                w += msg.charAt(idx++); // 가장 긴 문자열 w 업데이트
            }

            result.add(map.get(w));
            System.out.println(map.get(w));

            if (idx >= msg.length()) {
                break;
            }

            map.put(w+msg.charAt(idx), last_num++);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
