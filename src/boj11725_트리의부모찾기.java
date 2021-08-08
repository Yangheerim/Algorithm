package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj11725_트리의부모찾기 {

    static class Node{
        int idx;
        int root;
        ArrayList<Node> adj;

        public Node(int idx) {
            this.idx = idx;
            this.root = 0;
            this.adj = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n - 1; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }

        boolean[] visited = new boolean[n + 1];

        Queue<Node> q = new LinkedList<>();
        nodes[1].root = -1; //root
        q.add(nodes[1]);

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (Node no : now.adj) {
                if(!visited[no.idx]){ // 방문 안했으면
                    visited[no.idx] = true;
                    no.root = now.idx;
                    q.add(no);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(nodes[i].root);
        }

    }
}
