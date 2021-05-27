import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj9205_맥주마시면서걸어가기 {
    static class Loc{
        int i;
        int j;
        boolean visited;

        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
            this.visited = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tk = Integer.parseInt(br.readLine());

        for(int t=0; t<tk; t++){
            int n = Integer.parseInt(br.readLine());

            Loc[] locs = new Loc[n+2];
            for(int i=0; i<n+2; i++){
                st = new StringTokenizer(br.readLine());
                locs[i] = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Loc start = locs[0];
            Loc end = locs[n+1];
            Queue<Loc> queue = new LinkedList<>();
            queue.add(start);

            boolean flag = false; //갈수없음

            while (!queue.isEmpty()){
                Loc tmp = queue.poll();
                if(tmp.equals(end)){
                    flag = true;
                    break;
                }
                for(int i=1; i<n+2; i++){
                    if(!locs[i].visited && isPossible(tmp, locs[i])){
                        locs[i].visited = true;
                        queue.add(locs[i]);
                    }
                }
            }

            if(flag){
                bw.write("happy\n");
            }else {
                bw.write("sad\n");
            }
        }
        bw.flush();
    }

    public static boolean isPossible(Loc l1, Loc l2) {
        int dis = Math.abs(l1.i - l2.i) + Math.abs(l1.j - l2.j);
        return dis<= 1000;
    }

}
