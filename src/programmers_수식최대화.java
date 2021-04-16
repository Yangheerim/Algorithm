import java.util.ArrayList;
import java.util.HashSet;

public class programmers_수식최대화 {
    static ArrayList<String> priority_list;
    static HashSet<Character> set;
    static int n;

    public static void main(String[] args) {
        solution("100-200*300-500+20");
        solution("50*6-3*2");
        solution("2-990-5+2");
    }

    public static long solution(String expression) {
        long answer = 0;

        ArrayList<String> expression_array = new ArrayList<>();
        set = new HashSet<>();

        // 수식 나눠서 ArrayList에 저장
        String num = "";
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if(ch == '+' || ch =='-' || ch == '*') {
                expression_array.add(num);
                expression_array.add(""+ch);
                num = "";

                set.add(ch);

                continue;
            }
            num += ch;
        }
        expression_array.add(num); // 마지막 숫자

        n = set.size();
        getPriority();

        for (String s : priority_list) {

            // initialize
            ArrayList<String> arr = new ArrayList<>();
            for(String ss : expression_array){
                arr.add(ss);
            }

            for(int i=0; i<n; i++){ //n은 연산자의 개수
                char ope = s.charAt(i);

                for(int j=1; j<arr.size();j=j+2){
                    if(arr.get(j).charAt(0) == ope){
                        long a = Long.parseLong(arr.get(j - 1));
                        long b = Long.parseLong(arr.get(j + 1));
                        long result = 0;
                        switch (ope){
                            case '+': result=a+b; break;
                            case '-': result=a-b; break;
                            case '*': result=a*b; break;
                        }
                        arr.remove(j - 1);
                        arr.remove(j-1);
                        arr.remove(j-1);
                        arr.add(j - 1, String.valueOf(result));
                        j=-1;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(arr.get(0))));
        }
        System.out.println(answer);
        return answer;
    }

    public static void getPriority(){
        priority_list = new ArrayList<>();
        char[] operations = new char[n];
        boolean[] visited = new boolean[n];
        int i=0;
        for (Character c:set) {
            operations[i++] = c;
        }
        dfs("", operations, visited);
    }

    // 조합 아니고 순열으로 풀어야함. 경우의 수니까!
    public static void dfs(String result, char[] operations, boolean[] visited){
        if(result.length()==n){
            priority_list.add(result);
            return;
        }

        for(int i=0; i<n; i++){

            if(!visited[i]){
                visited[i] = true;
                result += operations[i];
                dfs(result, operations, visited);
                result = result.substring(0, result.length() - 1);
                visited[i] = false;
            }
        }

    }

}
