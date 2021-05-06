import java.util.ArrayList;
import java.util.Arrays;

public class programmers_튜플 {
    public static void main(String[] args) {
        System.out.println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
    }
    public static int[] solution(String s) {
        ArrayList<String> result = new ArrayList<>();

        String[] sets = s.substring(2, s.length()-2).split("},\\{");
        Arrays.sort(sets, (s1, s2)->Integer.compare(s1.length(), s2.length()));

        for (String set : sets) {
            for(String chunk : set.split(",")){
                if(!result.contains(chunk)){
                    result.add(chunk);
                    break;
                }
            }
        }
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = Integer.parseInt(result.get(i));
            System.out.println(answer[i]);
        }

        return answer;
    }

}
