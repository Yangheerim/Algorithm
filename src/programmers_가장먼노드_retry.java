package programmers2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_가장먼노드 {
    static class Node{
        int idx;
        int distance;
        ArrayList<Node> adj;

        public Node(int idx) {
            this.idx = idx;
            this.distance = -1;
            this.adj = new ArrayList<>();
        }
    }
    public int solution(int n, int[][] edge) {

        Node[] nodes = new Node[n + 1];
        for(int i=1; i<=n; i++){
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < edge.length; i++) {
            nodes[edge[i][0]].adj.add(nodes[edge[i][1]]);
            nodes[edge[i][1]].adj.add(nodes[edge[i][0]]);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(nodes[1]);
        nodes[1].distance = 0;

        int max = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (Node node : now.adj) {
                if(node.distance > -1) continue;
                node.distance = now.distance + 1;
                max = Math.max(max, node.distance);
                q.add(node);
            }
        }

        int cnt = 0;
        for(int i=1; i<=n; i++){
            if(nodes[i].distance==max) cnt++;
        }

        return cnt;
    }
}
