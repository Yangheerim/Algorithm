import java.io.*;
import java.util.Stack;

// 참고 : https://kwanik.tistory.com/9
public class boj2504_괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int sum = 0;
        int tmp = 1;

        boolean isError = false;

        //짝이 맞아야 하는 괄호가 홀 수 개라면 더 이상 볼필요도 없다.
        if(str.length() % 2 == 1) {
            System.out.println("0");
            return;
        }

        for(int i=0; i<str.length(); i++){
            if (str.charAt(i) == '('){
                stack.add(str.charAt(i));
                tmp *= 2;
                continue;
            }else if(str.charAt(i) == '['){
                stack.add(str.charAt(i));
                tmp *= 3;
                continue;
            }
            if (str.charAt(i) == ')') {
                if(stack.isEmpty() || !(stack.peek() =='(')) {
                    isError = true;
                    break;
                }
                if(str.charAt(i-1) == '(')
                    sum += tmp;
                stack.pop();
                tmp /= 2;
            } else if (str.charAt(i) == ']') {
                if(stack.isEmpty() || !(stack.peek() =='[')) {
                    isError = true;
                    break;
                }
                if(str.charAt(i-1) == '[')
                    sum += tmp;
                stack.pop();
                tmp /= 3;
            }
        }

        if(isError){
            System.out.println("0");
        }else{
            System.out.println(sum);
        }


    }
}
