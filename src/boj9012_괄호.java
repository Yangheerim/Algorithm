import java.io.*;
import java.util.Stack;

public class boj9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<n; i++){
            String str = br.readLine();
            stack.clear();
            for(int j=0; j<str.length(); j++){
                if(stack.isEmpty()){
                    stack.add(str.charAt(j));
                    continue;
                }
                if (stack.peek() == '(' && str.charAt(j) == ')') {
                    stack.pop();
                    continue;
                }
                stack.add(str.charAt(j));
            }

            if(stack.isEmpty()){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }

        }
        bw.flush();
    }
}
