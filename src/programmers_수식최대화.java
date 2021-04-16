import java.util.ArrayList;

public class programmers_수식최대화 {

    public static void main(String[] args) {
        solution("100-200*300-500+20");
    }

    public static long solution(String expression) {
        long answer = 0;

        ArrayList<String> arr = new ArrayList<>();
        boolean[] flag = new boolean[3];

        // 수식 나눠서 ArrayList에 저장
        String num = "";
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if(ch == '+' || ch =='-' || ch == '*') {
                arr.add(num);
                arr.add(""+ch);
                num = "";

                switch (ch){
                    case '+': flag[0] = true; break;
                    case '-': flag[1] = true; break;
                    case '*': flag[2] = true; break;
                }

                continue;
            }
            num += ch;
        }
        arr.add(num); // 마지막 숫자

//        for (String s : arr) {
//            System.out.println(s);
//        }




        char[] operator = new char[3]; // 0->1->2순위


        return answer;
    }

    public void getPriority(boolean[] operation){
        ArrayList<String> prio_list = new ArrayList<>();

        for()

    }
    public void dfs(){

    }

}
