import java.util.Arrays;
import java.util.Collections;

public class sol1_0704 {
    public static void main(String[] args) {
        int[] prices = {13000, 88000, 10000};
        int[] discounts = {30, 20};
        System.out.println(solution(prices, discounts));
    }

    public static int solution(int[] prices, int[] discounts) {

        Integer[] prices2 = Arrays.stream(prices).boxed().toArray(Integer[]::new);
        Integer[] discounts2 = Arrays.stream(discounts).boxed().toArray(Integer[]::new);

        Arrays.sort(prices2, Collections.reverseOrder());
        Arrays.sort(discounts2, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < 1000; i++) {

            sum += prices2[i] * (100-discounts2[i]) / 100;

            if(prices2.length-1 == i){ // 제품이 더이상 없으면
                return sum;
            }
            if (discounts2.length-1 == i) { // 쿠폰이 더이상 없으면
                for (int j = i+1; j < prices2.length; j++) {
                    sum += prices2[j];
                }
                return sum;
            }

        }
        return sum;
    }
}
