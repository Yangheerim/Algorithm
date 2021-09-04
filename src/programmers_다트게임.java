package programmers;

import java.util.HashMap;

public class programmers_다트게임 {
    public static void main(String[] args) {
        solution("1S2D*3T");
        solution("1D2S#10S");
        solution("1D2S0T");
        solution("1S*2T*3S");
    }
    public static int solution(String dartResult) {


        int[] stage = new int[3];

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('S', 1);
        map.put('D', 2);
        map.put('T', 3);

        int now = -1;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if(Character.isDigit(c)){ // 숫자면
                if(dartResult.charAt(i+1)=='0'){ // 10일 때
                    stage[++now] = 10;
                    i++;
                }else {
                    stage[++now] = Integer.parseInt(c + "");
                }
                continue;
            }

            if (c == 'S' || c == 'D' || c == 'T') {
                stage[now] = (int) Math.pow(stage[now], map.get(c));
                continue;
            }

            if (c == '*') { // option
                if(now==0){
                    stage[0] *=2;
                }else{
                    stage[now] *=2;
                    stage[now-1] *=2;
                }
            } else if (c == '#') {
                stage[now] *= -1;
            }
        }

        int answer = 0;
        answer = stage[0] + stage[1] + stage[2];
        System.out.println(answer);
        return answer;
    }
}
