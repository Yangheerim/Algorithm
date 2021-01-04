/*
DFS & BFS
 */

import java.util.*;
import java.util.Queue;
import java.util.Stack;

class Graph{
    class Node {
        int index;
        boolean marked; // stack이나 queue에 들어갔는지 여부
        LinkedList<Node> adjacent;
        Node(int index){
            this.index = index;
            marked = false;
            adjacent = new LinkedList<Node>();
        }
    }
    // 그래프는 노드의 집합
    Node[] nodes;
    int size;

    // size를 받아 처리하는 instructor
    Graph(int size){
        this.size = size;
        nodes = new Node[size+1];
        for(int i=0; i<=size; i++){
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2){
        Node n1 = nodes[i1]; // 얕은 복사는 같은 주소값을 가리킨다.
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }

    // 인접한 노드가 여러 개일 때, 낮은 index의 노드를 먼저 가도록 소팅
    void sortAdjacent(){
        for(int i=1; i<=size; i++){
            Collections.sort(nodes[i].adjacent, new Comparator<Node>() {
               @Override
               public int compare(Node n1, Node n2) {
                   if(n1.index > n2.index) // if(o1.n < o2.n) : 역순
                       return +1;    // 양수의 대명사를 +1이라고 본다.
                   else
                       return -1;
               }
           });
        }
    }

    // DFS : queue 사용
    void dfs(int start_idx){
        Stack<Node> stack = new Stack<Node>();
        Node start = nodes[start_idx];
        stack.push(start);
        start.marked = true;
        while(!stack.isEmpty()){
           Node now = stack.pop();
           // 인접한 노드들에 대해서 stack에 들어간적 없는 노드들을 stack에 넣어줌
           for (Node n : now.adjacent){
               if(!n.marked){
                   n.marked = true;
                   stack.push(n);
               }
           }
           print(now.index); // 뺀건 프린트
        }
    }
    // DFS recursive
    void dfsR(Node node){
        if(node.marked) return;
        node.marked=true;
        print(node.index);
        for (Node n : node.adjacent) {
            dfsR(n);
        }
    }
    void dfsR(int start_index){
        Node n = nodes[start_index];
        dfsR(n);
    }

    void bfs(int start_idx){
        markInitialize();
        Queue<Node> queue = new LinkedList<>();
        Node start = nodes[start_idx];
        queue.offer(start);
        start.marked = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(Node n : now.adjacent){
//                System.out.println("test ---> marked is "+n.marked);
                if(!n.marked){
                    n.marked = true;
                    queue.offer(n);
                }
            }
            print(now.index); // 뺀건 프린트
        }
    }

    // marked false로 초기화
    void markInitialize(){
        for(int i=0; i<=size; i++){
            nodes[i].marked = false;
        }
    }

    void print(int index){
        System.out.print(index+" ");
    }
}
public class p1260 {

    public static void main(String[] args) {
        Graph graph;
        int n_num, e_num, start_idx;

        Scanner sc = new Scanner(System.in);

        String[] info = sc.nextLine().split(" ");
        n_num = Integer.parseInt(info[0]);
        e_num = Integer.parseInt(info[1]);
        start_idx = Integer.parseInt(info[2]);

        // n_num개의 node를 가진 그래프 생성
        graph = new Graph(n_num);

        for(int i=0; i<e_num; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            graph.addEdge(n1, n2);
        }

        //result
        graph.sortAdjacent();
        graph.dfsR(start_idx); // dfs
        System.out.println();
        graph.bfs(start_idx);  // bfs

    }

}
