import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
Dijkstra
1->A->B->N or 1->B->A->N 중에 작은 값으로 결과 출력
INF는 Edge최대개수 * Edge의 최대 weight +1
 */
public class p1504 {
    static class Node implements Comparable<Node>{
        int index;
        int weight;
        Node(int index, int weight){
            this.index = index;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int INF = 1000*200000+1;
    public static void main(String[] args) throws IOException {
        int N, E, v1, v2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] nodes = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            nodes[i] = new ArrayList<Node>();
        }

        int n1, n2, w;
        for(int i=1; i<=E; i++){
            StringTokenizer edgeinfo = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(edgeinfo.nextToken());
            n2 = Integer.parseInt(edgeinfo.nextToken());
            w = Integer.parseInt(edgeinfo.nextToken());
            nodes[n1].add(new Node(n2, w));
            nodes[n2].add(new Node(n1, w));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st2.nextToken());
        v2 = Integer.parseInt(st2.nextToken());

        int[] d_v1 = new int[N + 1];
        int[] d_v2 = new int[N + 1];
        for(int i=1; i<=N; i++){
            d_v1[i] = INF;
            d_v2[i] = INF;
        }

        dijkstra(v1, nodes, d_v1);
        dijkstra(v2, nodes, d_v2);

        int result = Math.min(d_v1[1] + d_v1[v2] + d_v2[N], d_v1[N] + d_v1[v2] + d_v2[1]);

        if(result>=INF){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }

    }

    static private void dijkstra(int start, ArrayList<Node>[] nodes, int[] d){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        d[start]=0;
        pq.offer(new Node(start, 0));

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
