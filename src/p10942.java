import java.io.*;
import java.util.StringTokenizer;

public class p10942 {
    static int[] nums;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(isPalindrome(s, e)+"\n");
        }
        bw.flush();
    }

    static int isPalindrome(int s, int e) {
        int i=s, j=e;
        while(true){
            if(i>=j) break;
            if(nums[i]!=nums[j])
                return 0; // palinrome 아님
            i++;
            j--;
        }
        return 1; // palinrome 맞음
    }
}
