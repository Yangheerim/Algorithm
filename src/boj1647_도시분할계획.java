package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

// 2개의 도시로 분할해야 하므로 프림 알고리즘을 통해 MST를 만든 후
// 가장 비용이 높은 간선 하나를 제거하면
// 2개의 도시로 나눠지고 최소 비용을 구할 수 있다.

public class boj1647_도시분할계획 {
    // Prim Algorithm으로 풀 것!

    static class Node implements Comparable<Node>{
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node e) {
            return this.weight - e.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        ArrayList<Node>[] nodes = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int w = Integer.parseInt(inputs[2]);

            nodes[a].add(new Node(b, w));
            nodes[b].add(new Node(a, w));
        }

        // 해당 노드가 선택되었는지 아닌지 판단하기 위한 boolean 배열
        boolean visited[] = new boolean[N+1];

        int cnt = 0; // 선택된 노드 수 카운트, 전부 선택되었으면 (== count가 n이면) 종료
        int result = 0;
        int max_weight = 0;

        PriorityQueue<Node> q = new PriorityQueue<Node>();

        q.add(new Node(1, 0));

        while (true) {
            Node cur = q.poll(); // extract min

            if (visited[cur.idx]) continue; // 이미 방문했었으면 패스

            visited[cur.idx] = true;
            //System.out.println(cur.idx);
            result += cur.weight;
            max_weight = Math.max(max_weight, cur.weight);
            cnt++;

            if (cnt == N) break;

            for (Node v : nodes[cur.idx]) {
                if (!visited[v.idx]) {
                    q.add(new Node(v.idx, v.weight));
                }
            }
        }
        //System.out.println("result:"+result+"/max_weight:"+max_weight);
        System.out.println(result-max_weight);

    }
}
