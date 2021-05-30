import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2606_바이러스 {
    static class Node{
        int idx;
        ArrayList<Node> adj;
        boolean visited;

        public Node(int idx) {
            this.idx = idx;
            this.adj = new ArrayList<>();
            this.visited = false;
        }
    }
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int link = Integer.parseInt(br.readLine());

        nodes = new Node[n+1];
        for(int i=1; i<=n; i++){
            nodes[i] = new Node(i);
        }
        for(int i=0; i<link; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        nodes[1].visited = true;
        queue.add(nodes[1]);

        int cnt = 0;

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node n : tmp.adj) {
                if(!n.visited){
                    n.visited = true;
                    queue.add(n);
                    cnt++;
                }
            }

        }
        return cnt;
    }
}
