package programmers;

import java.util.HashMap;

public class programmers_n진수게임 {

    public static void main(String[] args) {
        solution(2,4,2,1);
        solution(16, 16, 2, 1);
    }

    // 진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
    public static String solution(int n, int t, int m, int p) {
        String answer = "";

        int num = 0;
        int turn = 0;

        // turn : 1 2 3 4 5 6
        //      ->1 2 3 1 2 3
        // turn % 3 => 1,2,0 이게 1,2,3이 나와야함  %3 +1 하면 되긴 한데..
        // turn을 0부터?
        // turn : 0 1 2 3 4 5
        //      ->1 2 3 1 2 3

        OuterLoop:
        while(true){
            String converted = getConvertStr(num, n);
            if(converted.length()==0){
                converted = "0";
            }

            for (int i = 0; i < converted.length(); i++) {
                if (turn % m + 1 == p) {
                    answer += converted.charAt(i);
                    if(answer.length()>=t){
                        break OuterLoop;
                    }
                }
                turn ++;
            }
            num ++;
        }
        System.out.println(answer);
        return answer;
    }

    public static String getConvertStr(int num, int n){ // n : 진법
        StringBuilder builder = new StringBuilder();

        HashMap<Integer, String> map = new HashMap<>();
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");

        while (num >= 1) {
            int tmp = num % n;
            builder.insert(0, tmp < 10 ? tmp : map.get(tmp));
            num /= n;
        }

        return builder.toString();
    }
}
