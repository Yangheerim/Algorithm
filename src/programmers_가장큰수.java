import java.util.Arrays;
import java.util.Comparator;

public class programmers_가장큰수 {
    public static void main(String[] args) {
        int[] nums = {6, 10, 2};
        int[] nums2 = {3, 30, 34, 5, 9};
        solution(nums);
        solution(nums2);
    }
    public static String solution(int[] numbers) {
        Integer[] arr2 = Arrays.stream(numbers).boxed().toArray(Integer[] :: new);
        Arrays.sort(arr2);
        String[] nums = new String[arr2.length];
        for(int i=0; i<arr2.length; i++){
            nums[i] = arr2[i].toString();
        }

        // string끼리 비교해서 내림차순으로 정렬
        // 그냥 sort 하면 3, 30 을 정렬했을 때 30, 3이 되어버리기 때문에 최댓값이 330이 아닌 303이 되어버린다.
        // 이걸 방지하기 위해 더해보고 정렬~
//        내림차순 : return (o2+o1).compareTo(o1+o2);
//        오름차순 : return (o1+o2).compareTo(o1+o2);

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if(nums[0].charAt(0)=='0') return "0";

        String answer = "";
        for(int i=0; i<nums.length; i++){
            answer += nums[i];
        }
        return answer;
    }

}
