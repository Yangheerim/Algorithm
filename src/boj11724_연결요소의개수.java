import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11724_연결요소의개수 {
    static Node[] nodes;
    static class Node{
        int idx;
        boolean visited;
        ArrayList<Node> adj;

        public Node(int idx) {
            this.idx = idx;
            this.visited = false;
            this.adj = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodes = new Node[n+1];
        for(int i=1; i<=n; i++) {
            nodes[i] = new Node(i);
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }


        int count = 0;
        for(int i=1; i<=n; i++){
            if(!nodes[i].visited) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int idx){
        for(Node node : nodes[idx].adj){
            if(!node.visited){
                node.visited = true;
                dfs(node.idx);
            }
        }
    }
}
