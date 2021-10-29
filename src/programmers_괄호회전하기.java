package programmers2;

import java.util.Stack;

public class programmers_괄호회전하기 {
    public static int solution(String s) {
        int answer = 0;

        String now = s;
        for(int i=0; i<s.length(); i++){
            now = rotate(now);
            if(isPossible(now)){
                answer++;
            }
        }

        return answer;
    }

    public static boolean isPossible(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            if(stack.isEmpty()){
                stack.add(now);
                continue;
            }
            if(stack.peek()=='[' && now==']'){
                stack.pop();
            }else if(stack.peek()=='{' && now=='}'){
                stack.pop();
            }else if(stack.peek()=='(' && now==')'){
                stack.pop();
            }else{
                stack.add(now);
            }

        }
        return stack.isEmpty();
    }

    public static String rotate(String s){
        return s.substring(1)+s.charAt(0);
    }
}
