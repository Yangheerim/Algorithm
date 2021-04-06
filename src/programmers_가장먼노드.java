import java.util.ArrayList;


// 시간초과,,
public class programmers_가장먼노드 {
    static Node[] nodes;
    static int[] dist;

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

    public static void main(String[] args) {
        int[][] arr = {
                {3,6}, {4,3}, {3,2},{1,3},{1,2},{2,4},{5,2}
        };
        solution(6, arr);
    }

    public static int solution(int n, int[][] edge) {

        nodes = new Node[n+1];
        dist = new int[n+1];

        for(int i=1; i<=n; i++){
            nodes[i] = new Node(i);
            dist[i] = 20001;
        }

        for(int i=0; i< edge.length; i++){
            int n1 = edge[i][0];
            int n2 = edge[i][1];
            nodes[n1].adj.add(nodes[n2]);
            nodes[n2].adj.add(nodes[n1]);
        }

        nodes[1].visited = true;
        dfs(1, 0);

        int max = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(dist[i]>max){
                max = dist[i];
                arr.clear();
                arr.add(i);
            }else if(dist[i]==max){
                arr.add(i);
            }
        }


        return arr.size();
    }

    public static void dfs(int idx, int count){

        if(dist[idx]==20001 || dist[idx]>count){
            dist[idx] = count;
        }

        for (Node n : nodes[idx].adj) {
            if(!n.visited){
                n.visited = true;
                dfs(n.idx, count+1);
                n.visited = false;
            }
        }

    }

}
