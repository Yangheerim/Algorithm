import java.util.HashMap;

public class kakaointernship_solution1 {
    public static void main(String[] args) {
        solution("2three45sixseven");
        solution("123");
    }
    public static int solution(String s) {

        HashMap<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        String answer = "";
        String str = "";
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(Character.isDigit(tmp)){
                if(str.length()!=0) {
                    answer += map.get(str);
                    str = "";
                }
                answer += tmp;
            }else{
                str += tmp;
            }
            if (map.get(str) != null) {
                answer += map.get(str);
                str = "";
            }
        }

        return Integer.parseInt(answer);
    }
}
