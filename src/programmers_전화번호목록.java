package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class programmers_전화번호목록 {

    public static void main(String[] args) {
        String[] strs = {"119", "97674223", "1195524421"};
        String[] strs1 = {"123","456","789"};
        String[] strs2 = {"1","2","235","567","88"};
        System.out.println(solution(strs));
        System.out.println(solution(strs1));
        System.out.println(solution(strs2));
    }

    static class Node{
        char num;
        ArrayList<Node> adj;
        boolean is_end;

        public Node(char num) {
            this.num = num;
            this.adj = new ArrayList<>();
            this.is_end = false;
        }
    }

    public static boolean solution(String[] phone_book) {

        // 둘다됨
        Arrays.sort(phone_book, (s1, s2)->s1.compareTo(s2));
//        Arrays.sort(phone_book, (s1, s2)->s1.length()-s2.length());

        Node root = new Node('r');

        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];

            Node now = root;

            OuterLoop:
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (now.adj.size()==0) {
                    Node new_node = new Node(c);
                    now.adj.add(new_node);
                    now = new_node;

                    if (j == s.length() - 1) {
                        now.is_end = true;
                    }
                    continue;
                }


                for (Node n : now.adj) {
                    if (n.num == c) {
                        if(n.is_end){ // 접두사가 있으면
                            return false;
                        }else{
                            now = n;
                            continue OuterLoop;
                        }
                    }
                }

                // 현재 숫자의 노드가 없으면 새로 생성한다.
                Node new_node = new Node(c);
                now.adj.add(new_node);
                now = new_node;

                if (j == s.length() - 1) {
                    now.is_end = true;
                }

            }
        }

        return true;
    }

}
