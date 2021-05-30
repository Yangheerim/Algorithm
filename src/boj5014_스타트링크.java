import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5014_스타트링크 {
    static class Floor{
        int floor;
        int cnt;

        public Floor(int floor, int cnt) {
            this.floor = floor;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[F+1]; // 전체 층에 대해 방문 여부 체크 (1~F층)

        Queue<Floor> queue = new LinkedList<>();

        visited[S] = true;
        queue.add(new Floor(S, 0));

        while (!queue.isEmpty()) {
            Floor tmp = queue.poll();
            if(tmp.floor == G){
                System.out.println(tmp.cnt);
                return;
            }
            if(tmp.floor+U<=F && !visited[tmp.floor+U]){
                queue.add(new Floor(tmp.floor + U, tmp.cnt+1));
                visited[tmp.floor + U] = true;
            }
            if(tmp.floor-D>=1 && !visited[tmp.floor-D]){
                queue.add(new Floor(tmp.floor-D, tmp.cnt+1));
                visited[tmp.floor-D] = true;
            }
        }
        System.out.println("use the stairs");
    }
}
