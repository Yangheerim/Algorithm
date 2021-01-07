import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1753 {

    static class Node implements Comparable<Node>{
        int index;
        int distance;

        Node(int index, int distance){
            this.index = index;
            this.distance = distance; //max value
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws Exception {
        // V E
        int V, E, start_node;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start_node = Integer.parseInt(br.readLine());

        // Node 생성
        ArrayList<Node>[] nodes = new ArrayList[V+1];
        for(int i=0; i<=V; i++){
            nodes[i] = new ArrayList<Node>();
        }

        int start, end, weight; // edge info

        for(int i=0; i<E; i++){
            StringTokenizer edgeinfo = new StringTokenizer(br.readLine());
            start = Integer.parseInt(edgeinfo.nextToken());
            end = Integer.parseInt(edgeinfo.nextToken());
            weight = Integer.parseInt(edgeinfo.nextToken());
            nodes[start].add(new Node(end, weight));
        }

        // Dijkstra
        // Q : priority queue
        PriorityQueue<Node> Q = new PriorityQueue<Node>();

        // Distance
        int[] d = new int[V+1];
        for(int i=1; i<V+1; i++){
            d[i]=Integer.MAX_VALUE;
        }

        // 시작점 지정
        d[start_node] = 0;
        Q.offer(new Node(start_node, 0));

        // Q가 빌때까지 반복
        while(!Q.isEmpty()){

            Node min = Q.poll();

            for (Node adjacent : nodes[min.index]){
                if(d[adjacent.index] > d[min.index] + adjacent.distance){
                    d[adjacent.index] = d[min.index] + adjacent.distance;
                    Q.offer(new Node(adjacent.index, d[adjacent.index]));
                }
            }
        }

        // 결과 출력
        for(int i=1; i<=V; i++){
            if(d[i]<Integer.MAX_VALUE) {
                System.out.println(d[i]);
            }else{
                System.out.println("INF");
            }
        }
    }
}
