import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class p1922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int result = 0;

        List<Vertex> list[] = new ArrayList[V];

        for (int i = 0; i < V; i++) list[i] = new ArrayList<Vertex>();

        // input
        for (int i = 0; i < E; i++) {
            String input2[] = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]) - 1;
            int b = Integer.parseInt(input2[1]) - 1;
            int c = Integer.parseInt(input2[2]);
            // 리스트 배열을 사용하여 각 vertex별로 어떤 노드와 연결되어있는지에 대한 정보를 저장
            list[a].add(new Vertex(b, c));
            list[b].add(new Vertex(a, c));
        }

        // 선택되었는지 아닌지 판단하기 위한 boolean 배열
        boolean visited[] = new boolean[V];
        // 현재 선택된 정점들로부터 도달할 수 있는 최소 거리 저장 배열
        int distance[] = new int[V];

        // 모두 최대 값으로 key를 갱신
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0; // 처음 노드는 0
        int cnt = 0;

        PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
        q.offer(new Vertex(0, distance[0]));

        while (true) {
            Vertex cur = q.poll(); // extract min

            if (visited[cur.v]) continue; // 이미 방문했었으면 패스
            visited[cur.v] = true;
            result += cur.w;
            cnt++;

            if (cnt == V) break;

            for (Vertex v : list[cur.v]) { // 인접한애들 확인해서 아직 방문안했고 distance가 더 크면 갱신
                if (!visited[v.v] && distance[v.v] > v.w) {
                    distance[v.v] = v.w;
                    q.offer(new Vertex(v.v, distance[v.v]));
                }
            }
        }
        System.out.println(result);
    }

    // class Edge
    static class Vertex implements Comparable<Vertex> {
        int v;
        int w;

        Vertex(int vertex, int weight) {
            this.v = vertex;
            this.w = weight;
        }

        @Override
        public int compareTo(Vertex e) {
            return this.w > e.w ? 1 : -1;
        }
    }


}