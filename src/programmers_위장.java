
import java.util.HashMap;

public class programmers_위장 {

    public static void main(String[] args) {

        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        String[][] clothes2 = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };
        solution(clothes);
        solution(clothes2);

    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();

        // type별로 옷 종류가 몇개인지 세기
        for(int i=0; i<clothes.length; i++){
            String cloth_type = clothes[i][1];
            hash.put(cloth_type, hash.getOrDefault(cloth_type, 1) + 1);
        }

        for (String key : hash.keySet()) {
            answer *= hash.get(key);
        }

        return answer-1;
    }


}
