import java.util.ArrayList;
import java.util.Scanner;

public class LIS_nlogn {
    static int n;
    static ArrayList<Integer> lis = new ArrayList<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] nums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }

        lis.add(0); // index를 1부터

        int lb;
        for (int i = 1; i <= n; i++) {
            lb = lowerbound(nums[i]);
            if (lis.size() == lb) { // 제일 큰수이면
                lis.add(nums[i]);
            } else if (lis.get(lb) > nums[i]) {
                lis.set(lb, nums[i]);
            }
        }
        System.out.println(lis.size()-1);
    }

    static int lowerbound(int num) {
        int start = 0;
        int end = lis.size();
        int middle;

        if (end == 0) return end;

        while (start < end) {
            middle = (start + end) / 2;
            if (lis.get(middle) < num) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return end;
    }

}
