import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj16435_스네이크버드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] foods = new int[n];
        for(int i=0; i<n; i++){
            foods[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(foods);

        for(int i=0; i<n; i++){
            if(foods[i]<=length){
                length++;
            }else{
                System.out.println(length);
                return;
            }
        }
        System.out.println(length);
    }

}
