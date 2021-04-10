import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
sum의 자료형은 long을 써야한다!
최대 1,000,000이 ^2번 더해질 수 있으므로.
 */

public class boj9613_GCD합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tk = Integer.parseInt(br.readLine());

        for(int i=0; i<tk; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0; j<n; j++){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            long sum=0;
            for(int j=0; j<n; j++){
                for(int k=j+1; k<n; k++){
                    sum += gcd(arr.get(j), arr.get(k));
                }
            }
            bw.write(sum+"\n");
        }
        bw.flush();
    }

    // 재귀 (recursive)
    public static int gcd(int a, int b){
        if(b==0) return a;
        int r = a % b;
        return gcd(b, r);
    }

}
