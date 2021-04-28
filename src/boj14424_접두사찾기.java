import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj14424_접두사찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<String> str = new ArrayList<>();
        ArrayList<String> check = new ArrayList<>();
        for(int i=0; i<n; i++){
            str.add(br.readLine());
        }
        for(int i=0; i<m; i++){
            check.add(br.readLine());
        }

        int cnt = 0;
        for(String c : check){
            for (String s : str) {
                if(s.startsWith(c)) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
