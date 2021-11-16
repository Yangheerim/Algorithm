package programmers2;

import java.util.Arrays;

//  각 원소의 합이 S가 되는 것이 집중 하기보다 어떻게 하면 최대 곱이 나올 것인지에 집중!!
public class programmers_최고의집합 {

    public static void main(String[] args) {
        solution(2, 8);
    }

    static long max_multi = 0;
    static int[] answer = {-1};
    public static int[] solution(int n, int s) {

        int[] set = new int[n];
        findSet(0, 0, n, s, set);

        Arrays.sort(answer);

        System.out.println(answer[0]+", "+answer[1]);
        return answer;
    }

    private static void findSet(int idx, int sum, int n, int s, int[] set){

        if(idx==n-1){
            if(s-sum==0) return;
            set[n-1] = s - sum;

            int multi = 1;
            for(int i=0; i<n; i++){
                multi *= set[i];
            }
            System.out.println(multi);
            if(multi>max_multi){
                answer = set.clone();
                max_multi= multi;
            }
            return;
        }

        for(int i=1; i<=s; i++){
            if (sum + i <= s) {
                set[idx] = i;
                findSet(idx+1, sum+i, n, s, set);
            }
        }
    }
}
