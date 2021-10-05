package programmers;

import java.util.Stack;

public class programmers_올바른괄호 {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if(stack.isEmpty() || now=='('){
                stack.push(now);
                continue;
            }

            if(now==')' || stack.peek()=='('){
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
