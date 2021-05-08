import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class kakaointernship_solution4 {
    public static void main(String[] args) {

        int[][] roads = {
                {1,2,1},
                {3,2,1},
                {2,4,1}
        };
        int[] traps = {2,3};
        solution(4,1,4, roads, traps);


    }
    static class Edge {
        int end;
        int weight;
        int direction; // 1이면 s->e 갈 수 있음(나가는 방향), -1이면 못감(들어오는 방향)

        public Edge(int e, int w, int d) {
            this.end = e;
            this.weight = w;
            this.direction = d;
        }
    }
    static class Loc{
        int idx;
        long dis;

        public Loc(int idx, long dis) {
            this.idx = idx;
            this.dis = dis;
        }
    }

    public static ArrayList<Edge>[] nodes;
    public static long solution(int n, int start, int end, int[][] roads, int[] traps) {

        nodes = new ArrayList[n+1];

        ArrayList<Integer> trap_node = new ArrayList<>();
        for(int i=0; i<traps.length; i++){
            trap_node.add(traps[i]);
        }

        for(int i=1; i<=n; i++){
            nodes[i] = new ArrayList<>();
        }

        for(int i=0; i<roads.length; i++) {
            int s = roads[i][0];
            int e = roads[i][1];
            int w = roads[i][2];
            nodes[s].add(new Edge(e, w, 1));
            nodes[e].add(new Edge(s, w, -1));
        }

        //bfs
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(start, 0));
        long min = Long.MAX_VALUE;
        while (!queue.isEmpty()) {
            Loc node = queue.poll();
//            System.out.println("지금:"+node.idx+", 더해진길이:"+node.dis+", min="+min); //

            if(node.idx == end) {
                min = Math.min(node.dis, min);
                continue;
            }
            if(node.dis>=min) continue;

            if(trap_node.contains(node.idx)){
//                System.out.println("trap!");
                reverseDirection(node.idx);
            }
            ArrayList<Edge> edges = nodes[node.idx];
            for (Edge e : edges) {
//                System.out.println("s="+node.idx+", e="+e.end+", d="+e.direction);
                if(e.end==start) continue;
                if(e.direction==1){
                    queue.add(new Loc(e.end, node.dis+e.weight));
                }
            }
        }
//        System.out.println(min);
        return min;
    }

    public static void reverseDirection(int idx){
        for (Edge e : nodes[idx]) {
            e.direction *= -1;
            for (Edge e2 : nodes[e.end]) {
                if(e2.end == idx){
                    e2.direction *= -1;
                }
            }
        }
    }

}
