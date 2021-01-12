import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
웜홀,
N개 정점이 있는데 이 중 아무거나 시작점을 자신으로 했을 때 자신으로 돌아오는 최단거리가 0보다 작은 경우가 하나라도 있냐는 문제
즉, 음의 싸이클이 존재하는가?의 문제임 (아니 이걸 문제만 보고 어떻게알아)
'시간이 줄어들면서 출발 위치로 돌아오는 것' 싸이클인데, 음수싸이클!
 */

public class p1865 {
    static class Node{
        int end;
        int weight;
        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    static int TC, N, M, W;
    static int INF = 2500*10000+1;
    static ArrayList<Node>[] nodes;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TC = Integer.parseInt(br.readLine());

        for(int tc=0; tc<TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            d = new int[N + 1];
            nodes = new ArrayList[N+1];
            for(int i=0; i<=N; i++){
                nodes[i] = new ArrayList<Node>();
            }
            int start, end, weight;
            for (int i = 1; i <= M; i++) {
                StringTokenizer edgeinfo = new StringTokenizer(br.readLine());
                start = Integer.parseInt(edgeinfo.nextToken());
                end = Integer.parseInt(edgeinfo.nextToken());
                weight = Integer.parseInt(edgeinfo.nextToken());
                nodes[start].add(new Node(end, weight));
                nodes[end].add(new Node(start, weight));
            }
            for (int i = 1; i <= W; i++) {
                StringTokenizer edgeinfo = new StringTokenizer(br.readLine());
                start = Integer.parseInt(edgeinfo.nextToken());
                end = Integer.parseInt(edgeinfo.nextToken());
                weight = Integer.parseInt(edgeinfo.nextToken());
                nodes[start].add(new Node(end, -weight));
            }

            boolean cycle = false;
            for(int i = 1; i <= N; i++) {
                if(bellmanFord(i)) {
                    cycle = true;
                    bw.write("YES" + "\n");
                    break;
                }
            }

            if(!cycle)
                bw.write("NO" + "\n");

            // 이거간단함
            // https://ukyonge.tistory.com/182 참고

//            while(isPossible && cnt < N) {
//                isPossible = false;
//                cnt++;
//                for(int v=1; v<=N; v++) {
//                    for(Point po : arrList[v]) {
//                        if(dist[v] + po.y < dist[po.x]) {
//                            dist[po.x] = dist[v] + po.y;
//                            isPossible = true;
//                        }
//                    }
//                }
//            }
//            if(cnt == N)
//                System.out.println("YES");
//            else
//                System.out.println("NO");


        }
        bw.flush();
    }
    static boolean bellmanFord(int start) {
        Arrays.fill(d, INF);
        d[start]=0;
        boolean update = false;

        for(int i=1; i<=N-1; i++){
            update = false;

            // 최단거리 초기화.
            for (int j = 1; j <= N; j++) {
                for (Node road : nodes[j]) {
                    if (d[j] != INF && d[road.end] > d[j] + road.weight) {
                        d[road.end] = d[j] + road.weight;
                        update = true;
                    }
                }
            }

            // 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료.
            if (!update) {
                break;
            }
        }

        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Node road : nodes[i]) {
                    if (d[i] != INF && d[road.end] > d[i] + road.weight) {
                        return true; // 음수 싸이클 있음
                    }
                }
            }
        }
        return false; // 음수 싸이클 없음
    }
}
