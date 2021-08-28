package programmers;

import java.util.Stack;

public class programmers_괄호변환 {

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        return convert(p);
    }

    public static String convert(String str){

        if(str.length()==0) return "";
        if(isCorrectStr(str)) return str;

        String u = "";
        String v = "";

        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='('){
                cnt1 ++;
            }else{
                cnt2 ++;
            }
            if(cnt1==cnt2){
                u = str.substring(0, i + 1);
                v = str.substring(i+1);
                break;
            }
        }

        String result = "";

        if(isCorrectStr(u)){
            result = u + convert(v);
        }else{
            result = "(" + convert(v) +")";
            result += reverse(u.substring(1,u.length()-1));
        }

        return result;
    }

    public static String reverse(String str){
        String result = "";
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='('){
                result += ')';
            }else{
                result += '(';
            }
        }
        return result;
    }

    public static boolean isCorrectStr(String u){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < u.length(); i++) {
            if(stack.isEmpty() || u.charAt(i)=='('){
                stack.add(u.charAt(i));
            }else if(stack.peek()=='(' || u.charAt(i)==')'){
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
