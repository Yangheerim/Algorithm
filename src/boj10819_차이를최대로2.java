import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj10819_차이를최대로2 {
    static int[] nums;
    static boolean[] visited;
    static int n;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(arr, 0);

        System.out.println(result);
    }

    public static void dfs(ArrayList<Integer> arr, int count) {
        if(count==n){
            result = Math.max(getResult(arr), result);
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr.add(nums[i]);
                dfs(arr, count+1);
//                arr.remove(arr.get(arr.size()-1));
//                이렇게 하면 마지막 수와 마지막이 아닌 수 중에 같은 수가 있을 경우 index가 더 작은 객체가 remove된다.
                arr.remove(arr.size()-1);
                visited[i] = false;
            }
        }
    }

    public static int getResult(ArrayList<Integer> arr){
        int sum=0;
        for(int i=0; i<n-1; i++){
            sum += Math.abs(arr.get(i)-arr.get(i+1));
        }
        return sum;
    }
}
