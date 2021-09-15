package programmers;

import java.util.Stack;

public class programmers_짝지어제거하기 {

    public static void main(String[] args) {

    }

    public int solution(String s)
    {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }

            if (stack.peek() == s.charAt(i)) {
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }

        }


        return stack.isEmpty() ? 1 : 0;
    }


    // 효율성 제로
//    public int solution(String s)
//    {
//        int answer = 0;
//
//        OuterLoop:
//        while(true) {
//            boolean flag = false; // 제거된 게 있으면 true
//
//            for (int i = 0; i < s.length() - 1; i++) {
//                if (s.charAt(i) == s.charAt(i + 1)) {
//                    if(s.length()==2){
//                        answer = 1;
//                        break OuterLoop;
//                    }
//
//                    s = s.substring(0, i) + s.substring(i + 2);
//                    flag = true;
//                }
//            }
//            if(!flag) break;
//        }
//
//        return answer;
//    }
}
