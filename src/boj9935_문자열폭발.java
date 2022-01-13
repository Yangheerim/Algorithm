package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bum = br.readLine();

        int bum_len = bum.length();
        char last_char = bum.charAt(bum_len - 1);

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);

            if (now == last_char && stack.size() >= bum_len-1) { // 현재 문자가 마지막 문자와 같으면 비교해보기
                boolean flag = true;
                int size = stack.size();

                for (int j = 0; j < bum_len - 1; j++) { // 폭탄이 맞는지 확인
                    if (stack.get(size - 1 - j) != bum.charAt(bum_len - 2 - j)) {
                        flag = false; // 하나라도 틀린 문자면 false
                        break;
                    }
                }

                if(flag){ // 폭탄이면
                    for (int j = bum_len - 2; j >= 0; j--) {
                        stack.pop();
                    }
                }else{ // 폭탄이 아니면
                    stack.add(now);
                }

            }else{ // 아니면 그냥 넣음
                stack.add(now);
            }
        }

        if(stack.size()==0){
            System.out.println("FRULA");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        System.out.println(sb);
    }
}
