import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj13397_구간나누기2 {
    // https://velog.io/@jwkim/binary-search-13397

    static int[] arr;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        int max = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int left = 0;
        int right = max;

        int result = Integer.MAX_VALUE; // (최대-최소) 값중에 최소값!

        while (left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(mid)){
                result = Math.min(mid, result);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    public static boolean isPossible(int estimated_num) {
        int block_cnt = 0;
        ArrayList<Integer> list = new ArrayList<>(); // 구간

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {

            max = Math.max(max, num);
            min = Math.min(min, num);

            if (max - min > estimated_num) {
                block_cnt++;
                list.clear();
                max = num;
                min = num;
            }

            list.add(num);
        }
        if(block_cnt+1<=m){
            return true;
        }else{
            return false;
        }

    }



}
