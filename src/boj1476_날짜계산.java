import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1476_날짜계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] date = br.readLine().split(" ");

        int E = Integer.parseInt(date[0]);
        int S = Integer.parseInt(date[1]);
        int M = Integer.parseInt(date[2]);

        int e = 1, s = 1, m = 1;
        int year = 1;
        while (true) {
            if(E==e && S==s && M==m){
                break;
            }
            e++;
            s++;
            m++;

            if(e == 16) e = 1;
            if(s == 29) s = 1;
            if(m == 20) m = 1;

            year ++;
        }
        System.out.println(year);

    }
}
