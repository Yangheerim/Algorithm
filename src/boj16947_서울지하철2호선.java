import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16947_서울지하철2호선 {
    static class Station{
        int idx;
        ArrayList<Station> adj;

        public Station(int idx) {
            this.idx = idx;
            this.adj = new ArrayList<>();
        }
    }
    static Station[] stations;
    static boolean[] cycle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        stations = new Station[n+1];

        for(int i=1; i<=n; i++){
            stations[i] = new Station(i);
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            stations[a].adj.add(stations[b]);
            stations[b].adj.add(stations[a]);
        }

        for(int i=1; i<=n; i++){
            cycle = new boolean[n + 1];
            cycle[i] = true;
            if(isCycle(i, i,1)) {
                break;
            }
        }

        // testing
//        for(int i=1; i<=n; i++){
//            System.out.print(cycle[i]?"T ":"F ");
//        }
//        System.out.println();

        int[] result = new int[n + 1];
        int[] dist;
        boolean[] visited;

        // get distance
        for(int i=1; i<=n; i++){
            if(cycle[i]){
                result[i] = 0;
            }else{
                // bfs
                dist = new int[n + 1];
                visited = new boolean[n + 1];
                Queue<Station> queue = new LinkedList<>();
                queue.add(stations[i]);
                outerLoop:
                while(!queue.isEmpty()){
                    Station tmp = queue.poll();
                    visited[tmp.idx] = true;
                    for (Station s : tmp.adj) {
                        if(cycle[s.idx]){
                            result[i] = dist[tmp.idx]+1;
                            break outerLoop;
                        }
                        if(!visited[s.idx]) {
                            dist[s.idx]= dist[tmp.idx]+1;
                            queue.add(s);
                        }
                    }
                }
            }
        }

        // print result
        for(int i=1; i<=n; i++){
            System.out.print(result[i]+" ");
        }

    }

    //dfs
    public static boolean isCycle(int start, int now, int count){
        for(Station s : stations[now].adj){
            if(start == s.idx && count>=3) {
                return true;
            }
            if(!cycle[s.idx]){
                cycle[s.idx] = true;
                if(isCycle(start, s.idx, count+1)) return true;
                cycle[s.idx] = false;
            }
        }
        return false;
    }

}
