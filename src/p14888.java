import java.io.*;
import java.util.StringTokenizer;
/*
Bruteforce, DFS
주어진 수열과 연산자의 개수로 가능한 연산의 경우의 수만큼 계산 후 min, max를 구하는 문제.
min, max는 각각의 연산이 완료된 후에 비교해서 넣어주도록 해야했다.
dfs를 사용했고, 하나의 연산자가 사용되면 -1해준 후 dfs를 진행함.
dfs 연산이 완료된 후에는 다른 경우의 수를 위해 원래대로 +1 해줬다.
 */
public class p14888 {
    static int[] nums;
    static int[] cals;
    static int n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        // 수열
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //연산자
        cals = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            cals[i] = Integer.parseInt(st.nextToken());
        }

        cal(0, nums[0]);
        System.out.println(max+"\n"+min);

    }

    public static void cal(int curr, int sum){

        if (curr >= n-1){ // 수열의 범위는 0~n-1
            if(sum>max){
                max = sum;
            }
            if(sum<min){
                min = sum;
            }
            return;
        }
//        System.out.println("curr: "+curr);
        for(int i=0; i<4; i++) {
//            System.out.println("-- "+i+" :");
            if (cals[i] > 0) {
                cals[i]--;
                int next_sum = sum;
                switch (i){
                    case 0: next_sum += nums[curr+1]; break;
                    case 1: next_sum -= nums[curr+1]; break;
                    case 2: next_sum *= nums[curr+1]; break;
                    case 3: next_sum /= nums[curr+1]; break;
                }
//                System.out.println("next sum : "+next_sum+", min/max :"+min+"/"+max);
                cal(curr + 1, next_sum);
                cals[i]++;
            }
        }
    }

}
