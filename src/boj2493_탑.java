import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj2493_탑 {

    static class Top{
        int idx;
        int height;
        int received;

        public Top(int idx, int height) {
            this.idx = idx;
            this.height = height;
            this.received = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");

        Top[] tops = new Top[n];

        for (int i = 0; i < n; i++) {
            tops[i] = new Top(i+1, Integer.parseInt(str[i]));
        }

        Stack<Top> stack = new Stack<>();

        for (int i = n-1; i >= 0; i--) {

            if(stack.isEmpty() || stack.peek().height > tops[i].height) {
                stack.push(tops[i]);
            }else if(stack.peek().height <= tops[i].height){
                while(!stack.isEmpty() && stack.peek().height <= tops[i].height){
                    Top tmp = stack.pop();
                    tmp.received = tops[i].idx;
                }
                stack.push(tops[i]);
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            sb.append(tops[i].received+" ");
        }
        System.out.println(sb);

    }
}
