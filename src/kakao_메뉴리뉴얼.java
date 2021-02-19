import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class kakao_메뉴리뉴얼 {
    static HashMap<String, Integer> hash = new HashMap<>();

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        String[] answers = solution(orders, course);
        for (int i = 0; i < answers.length; i++) {
            System.out.println(answers[i]);
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for (int i = 0; i < orders.length; i++) {
            String order = orders[i];
            for (int j = 0; j < course.length; j++) {
                boolean[] visited = new boolean[order.length()];
                count(0, 0, course[j], order, visited);
            }
        }
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int max = 0; // 각 길이의 코스의 최대 count값
            for (String key : hash.keySet()) {
                if (key.length() == course[i] && hash.get(key) > max) { // key의 길이가 [2, 3, ...]인것들끼리 비교해서 count가 제일 큰거 저장
                    max = hash.get(key);
                }
            }
            if(max<2) continue;
            for (String key : hash.keySet()) {
                if (key.length() == course[i] && hash.get(key) == max) {
                    arr.add(key);
                }
            }
        }
        Collections.sort(arr);
        answer = arr.toArray(new String[arr.size()]);
        return answer;
    }

    public static void count(int idx, int count, int course_num, String order, boolean[] visited) {
        if (count == course_num) {
            ArrayList<Character> k = new ArrayList<>();
            for (int i = 0; i < order.length(); i++) {
                if (visited[i]) {
                    k.add(order.charAt(i));
                }
            }
            Collections.sort(k);
            String key = "";
            for(int i=0; i<k.size(); i++){
                key += k.get(i);
            }
            // 해시에 ++해주고
            if (hash.get(key) == null) {
                hash.put(key, 1);
            } else {
                int this_cnt = hash.get(key); // null?
                hash.put(key, this_cnt + 1);
            }
            return;
        }
        for (int i = idx; i < visited.length; i++) {
            visited[i] = true;
            count(i + 1, count + 1, course_num, order, visited);
            visited[i] = false;
        }
    }
}
