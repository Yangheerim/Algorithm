import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
정수 N개로 이루어진 수열이 있을 때,
크기가 양수인 부분수열이라는 것은 수열의 순서와 상관 없이 포함/불포함의 조건으로 이루어지는 수열을 말함!
예를들어 1 2 3 4 5 의 수열의 부분수열은 1 2 3 과 1 2 5, 2 4 5 모두 가능하다.
그래서 dfs를 활용해서 각각 부분수열에 포함시킬건지-말건지를 재귀로 풀어내면 된다.
 */
public class p1182 {
    static int n;
    static int s;
    static int[] nums;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        //합이 0일 경우 공집합도 포함되므로 그 수를 하나 빼주고 출력
        System.out.println(s==0?count-1:count);
    }

    static void dfs(int current, int sum) {
        if(current == n) {
            if (sum == s)
                count++;
            return;
        }

        dfs(current + 1, sum + nums[current]); // 현재 수를 부분수열에 포함한 경우
        dfs(current + 1, sum);  // 부분수열에 포함하지 않은 경우
    }
}
