import java.util.HashMap;

public class programmers_다단계칫솔판매 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        solution(enroll, referral, seller, amount);
    }

    static class Node {
        String name;
        Node parent;
        int profits;

        public Node(String name) {
            this.name = name;
            this.parent = null;
            this.profits = 0;
        }
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Node root = new Node("center");
        Node[] nodes = new Node[enroll.length];

        HashMap<String, Node> map = new HashMap<>();
        for(int i=0; i<nodes.length; i++){
            nodes[i] = new Node(enroll[i]);
            map.put(enroll[i], nodes[i]);
        }
        for(int i=0; i<referral.length; i++){
            if(referral[i].charAt(0) == '-'){
                nodes[i].parent = root;
                continue;
            }
            nodes[i].parent = map.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            dfs(map.get(seller[i]), amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            answer[i] = map.get(enroll[i]).profits;
        }
        return answer;
    }

    public static void dfs(Node node, int money){
        if(node.parent != null){
            // 분배해주고
            int share = (int)(money * 0.1);
            System.out.println(node.name+"->"+node.parent.name+"에게 "+share+"원 나눠줌");
            if (share > 0) {
                node.profits += money - share;
                dfs(node.parent, share);
            }else{
                node.profits += money;
            }
        }else{
            node.profits += money;
        }
    }



}
