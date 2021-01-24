import java.io.*;
import java.util.StringTokenizer;
/*
p2003과 비슷하지만, 이번엔 sum이 S보다 같거나 '큰' 경우의 최소 길이를 구하는 문제
sum>=S일 경우, sum<S가 될때까지 sum-=nums[s++]을 해준다.
길이가 줄어도 sum이 S보다 클 경우가 있기 때문에 더 작은 length를 가진다면 갱신해준다.
end가 n+1까지 도달하고, 더 이상 sum>=S인 경우가 없으면 종료.
참고 : https://wellohorld.tistory.com/28
 */
public class p1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        int[] nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // two pointer algorithm
        int s=1, e=1;
        int sum=0, min_length=n+1;
        while(true){
            if(sum<S && e==n+1){
                break;
            }
            if(sum<S){
                sum += nums[e++];
            }else { //sum>=S
                while(!(sum<S)) {
                    if(e-s<min_length)
                        min_length = e-s;
                    sum -= nums[s++];
                }
            }

            if(sum>=S){
                if(e-s<min_length)
                    min_length = e-s;
            }
//            System.out.println("Test1: s="+s+", e="+e+", sum="+sum+", S="+S+", min_length="+min_length);
        }
        if(min_length<n+1) {
            System.out.println(min_length);
        }else{
            System.out.println(0);
        }
    }
}
