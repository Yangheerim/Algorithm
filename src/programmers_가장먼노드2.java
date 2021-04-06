import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_가장먼노드2 {
    static Node[] nodes;

    static class Node{
        int idx;
        int dis;
        ArrayList<Node> adj;

        public Node(int idx) {
            this.idx = idx;
            this.dis = 0;
            this.adj = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {3,6}, {4,3}, {3,2},{1,3},{1,2},{2,4},{5,2}
        };
        solution(6, arr);
    }

    public static int solution(int n, int[][] edge) {

        nodes = new Node[n+1];

        for(int i=1; i<=n; i++){
            nodes[i] = new Node(i);
        }

        for(int i=0; i< edge.length; i++){
            int n1 = edge[i][0];
            int n2 = edge[i][1];
            nodes[n1].adj.add(nodes[n2]);
            nodes[n2].adj.add(nodes[n1]);
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(nodes[1]);

        // bfs
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node adj : node.adj) {
                if(adj.dis==0){ // 1부터의 거리가 계산되지 않았으면 = 방문하지 않았으면
                    adj.dis = node.dis + 1;
                    queue.add(adj);
                }
            }
        }

        // get result
        int max = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=2; i<=n; i++){
            int tmp = nodes[i].dis;
            if(tmp>max){
                max = tmp;
                arr.clear();
                arr.add(i);
            }else if(tmp==max){
                arr.add(i);
            }
        }

        return arr.size();
    }


}
