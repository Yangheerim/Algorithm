package programmers;

import java.util.ArrayList;
import java.util.Stack;

public class programmers_표편집 {
    public static void main(String[] args) {
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C", "D 3", "Z", "C", "Z"};
        solution(8,2, cmd);
    }

    static class Row{
        int idx;
        boolean deleted;
        int deleted_idx;

        public Row(int idx) {
            this.idx = idx;
            this.deleted = false;
            deleted_idx = -1;
        }
    }

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";

        ArrayList<Row> table = new ArrayList<>();
        Stack<Row> stack = new Stack<>();

        Row[] rows = new Row[n]; // initial 0
        for(int i=0; i<n; i++){
            rows[i] = new Row(i);
            table.add(rows[i]);
        }

        int cursor = k; // 현재위치

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
                    Row tmp = table.get(cursor);
                    tmp.deleted_idx = cursor;
                    tmp.deleted = true;
                    stack.push(tmp);
                    table.remove(table.get(cursor));
                    if(cursor == table.size()){
                        cursor --;
                    }
                    break;
                case 'Z':
                    Row tmp2 = stack.pop();
                    tmp2.deleted = false;
                    table.add(tmp2.deleted_idx, tmp2);
                    if(tmp2.deleted_idx<=cursor) cursor++;
                    break;
            }
        }
        for(int i=0; i<n; i++){
            if(rows[i].deleted){
                answer += "X";
            }else{
                answer += "O";
            }
        }

        return answer;
    }
}
