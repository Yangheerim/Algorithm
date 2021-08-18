package programmers;

import java.util.Stack;

//https://velog.io/@yuiopre98/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-level-3-%ED%91%9C-%ED%8E%B8%EC%A7%91

public class programmers_표편집2 {
    public static void main(String[] args) {
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C", "D 3", "Z", "C", "Z"};
        solution(8,2, cmd);
    }

    public static String solution(int n, int k, String[] cmd) {

        Stack<Integer> stack = new Stack<>();

        int cursor = k; // 현재위치
        int table_size = n;

        for(int i=0; i<cmd.length; i++){
            String[] inputs = cmd[i].split(" ");
            char order = inputs[0].charAt(0);

            switch (order){
                case 'U':
                    cursor -= Integer.parseInt(inputs[1]);
                    break;
                case 'D':
                    cursor += Integer.parseInt(inputs[1]);
                    break;
                case 'C':
                    stack.push(cursor);
                    table_size--;
                    if (cursor == table_size) {
                        cursor--;
                    }
                    break;
                case 'Z':
                    if(stack.pop()<=cursor) cursor++;
                    table_size++;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<table_size; i++){
            sb.append("O");
        }
        while (!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }

        return sb.toString();
    }
}
