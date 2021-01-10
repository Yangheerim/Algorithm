import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
Dijkstra
A -> X -> A 의 왕복 거리가 가장 큰 걸 구하는 문제
 */
public class p1238 {
    static int INF = 10000001;
    static class Node implements Comparable<Node>{
        int index;
        int weight;

        Node(int index, int distance) {
            this.index = index;
            this.weight = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        int N, M, X;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] nodes = new ArrayList[N+1];
        ArrayList<Node>[] rev_nodes = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            nodes[i] = new ArrayList<Node>();
            rev_nodes[i] = new ArrayList<Node>();
        }

        int n1, n2, w;
        for(int i=1; i<=M; i++){
            StringTokenizer edgeinfo = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(edgeinfo.nextToken());
            n2 = Integer.parseInt(edgeinfo.nextToken());
            w = Integer.parseInt(edgeinfo.nextToken());
            nodes[n1].add(new Node(n2, w));
            rev_nodes[n2].add(new Node(n1, w));
        }
        int[] dis = new int[N+1], rev_dis = new int[N+1];
        for(int i=1; i<=N; i++){
            dis[i] = INF;
            rev_dis[i] = INF;
        }
        dijkstra(X, nodes, dis);
        dijkstra(X, rev_nodes, rev_dis);

        int max=0;
        for(int i=1; i<=N; i++){
            int sum = dis[i] + rev_dis[i];
            if(sum > max){
                max = sum;
            }
        }
        System.out.println(max);
    }
    static void dijkstra(int X, ArrayList<Node>[] nodes, int[] d){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        d[X]=0;
        pq.offer(new Node(X, 0));

        while(!pq.isEmpty()){
            Node min = pq.poll();

            for(Node n : nodes[min.index]){
                if(d[n.index]>d[min.index]+n.weight){
                    d[n.index] = d[min.index] + n.weight;
                    pq.offer(new Node(n.index, d[n.index]));
                }
            }
        }
    }
}
