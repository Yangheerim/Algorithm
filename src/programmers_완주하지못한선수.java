import java.util.*;

public class programmers_완주하지못한선수 {
    public static void main(String[] args) {
        HashMap<String, Integer> hash = new HashMap<>();
        String[] p = {"mislav", "stanko", "mislav", "ana"};
        String[] c = {"stanko", "ana", "mislav"};
        System.out.println(solution(p, c));
    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < participant.length-1; i++) {
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }
        return participant[participant.length-1];
    }


}
