package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class programmers_오픈채팅방 {
    public static void main(String[] args) {
        String[] str = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        solution(str);
    }

    public static String[] solution(String[] record) {

        int n = record.length;

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
           String[] record_split = record[i].split(" ");

            if(record_split[0].charAt(0)=='E' || record_split[0].charAt(0)=='C'){
                map.put(record_split[1], record_split[2]);
            }
        }

        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] record_split = record[i].split(" ");
            char type = record_split[0].charAt(0);
            switch (type){
                case 'E':
                    arr.add(map.get(record_split[1]) + "님이 들어왔습니다.");
                    break;
                case 'L':
                    arr.add(map.get(record_split[1]) + "님이 나갔습니다.");
                    break;
            }
        }

        String[] answer = new String[arr.size()];
        for (int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
            System.out.println(answer[i]);
        }

        return answer;
    }
}
