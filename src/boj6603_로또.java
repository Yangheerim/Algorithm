import java.io.*;
import java.util.StringTokenizer;

public class boj6603_로또 {
    static boolean[] visited;
    static int[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k==0) break;

            arr = new int[k];
            visited = new boolean[k];
            for(int i=0; i<k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0, k);
            bw.write("\n");
        }
        bw.flush();
    }

    public static void dfs(int idx, int count, int k) throws IOException {
        if(count==6){
            //print
            for(int i=0; i<k; i++){
                if(visited[i]) bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        if(idx==k) return;

        visited[idx] = true;
        dfs(idx + 1, count + 1, k);

        visited[idx] = false;
        dfs(idx + 1, count, k);
    }

}
