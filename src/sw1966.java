import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1966 {

    static int[] nums = new int[50];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer num_list = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nums[j] = Integer.parseInt(num_list.nextToken());
            }

            quickSort(nums, 0, N-1);
            System.out.print("#"+(i+1));
            for (int j = 0; j < N; j++) {
                System.out.print(" "+nums[j]);
            }
            System.out.println();
        }
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int key = start;
        int i = start + 1;
        int j = end;
        int temp;

        while(i<=j){
            while(i<=end && nums[i]<=nums[key]){
                i++;
            }
            while(j>start && nums[j]>=nums[key]){
                j--;
            }

            if(i>j){ // i와 j가 엇갈린 상태면 키 값과 교체
                temp = nums[key];
                nums[key] = nums[j];
                nums[j]= temp;
            }else{ // 엇갈리지 않은 상태라면 i와 j를 교체
                temp = nums[i];
                nums[i] = nums[j];
                nums[j]= temp;
            }

            quickSort(nums, start, j-1);
            quickSort(nums, j+1, end);
        }

    }

}
