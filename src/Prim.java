import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Prim {
    static int INF = 10000000;
    static ArrayList<Integer> queue = new ArrayList<>();
    static int Vnum;
    static int Enum;
    static int[] vertices;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ve = br.readLine();
        StringTokenizer st = new StringTokenizer(ve);
        Vnum = Integer.parseInt(st.nextToken());
        Enum = Integer.parseInt(st.nextToken());

        vertices = new int[Vnum + 1];
        for (int i = 0; i <= Vnum; i++) {
            vertices[i] = INF;
        }

        edges = new Edge[Enum];
        for (int i = 0; i < Enum; i++) {
            String info = br.readLine();
            StringTokenizer info_t = new StringTokenizer(info);
            int s = Integer.parseInt(info_t.nextToken());
            int e = Integer.parseInt(info_t.nextToken());
            int w = Integer.parseInt(info_t.nextToken());
            edges[i] = new Edge(s, e, w);
        }

        // 시작 노드 설정 - 1번 노드
        vertices[1] = 0;

        // 큐에 vertex 넣기
        for (int i = 1; i <= Vnum; i++) {
            queue.add(i);
        }

        int u;
        while (!queue.isEmpty()) {
            u = ExtractMin();
            ArrayList<Integer> adj = adjacentVertex(u);
            for (int i = 0; i < adj.size(); i++) {
                int v = adj.get(i);
                if (queue.contains(v) && weight(u, v) < vertices[v]) {
                    vertices[v] = weight(u, v);
                }
            }
        }
        printResult();
    }

    static void printResult() {
        int sum = 0;
        for (int i = 1; i <= Vnum; i++) {
            sum += vertices[i];
        }
        System.out.println(sum);
    }

    static int weight(int v1, int v2) {
        for (int i = 0; i < Enum; i++) {
            if ((edges[i].s == v1 && edges[i].e == v2) || (edges[i].s == v2 && edges[i].e == v1)) {
                return edges[i].w;
            }
        }
        return -1;
    }

    static ArrayList<Integer> adjacentVertex(int vertex) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < Enum; i++) {
            if (edges[i].s == vertex) {
                result.add(edges[i].e);
            } else if (edges[i].e == vertex) {
                result.add(edges[i].s);
            }
        }
        return result;
    }

    // Extract-Min
    static int ExtractMin() {
        int min = INF;
        int min_vertex = 0;
        for (int i = 0; i < queue.size(); i++) {
            int v_index = queue.get(i);
            if (i == 0 || vertices[v_index] < min) {
                min = vertices[v_index];
                min_vertex = v_index;
            }
        }
        queue.remove((Integer) min_vertex);
        return min_vertex;
    }

    // class Edge
    static class Edge {
        int s;
        int e;
        int w;

        Edge(int start, int end, int weight) {
            this.s = start;
            this.e = end;
            this.w = weight;
        }
    }


}