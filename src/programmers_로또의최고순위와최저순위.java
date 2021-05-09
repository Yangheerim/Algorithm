import java.util.ArrayList;

public class programmers_로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {

        int match_count = 0;
        int unknown = 0;

        ArrayList<Integer> lotto = new ArrayList<>();
        ArrayList<Integer> win = new ArrayList<>();
        for(int i=0; i<lottos.length; i++){
            lotto.add(lottos[i]);
            win.add(win_nums[i]);
        }

        for(int i=0; i<lottos.length; i++){
            if(lotto.get(i)==0) {
                unknown++;
                continue;
            }
            if(win.contains(lotto.get(i))){
                match_count++;
            }
        }

        int max = match_count + unknown;
        int min = match_count;

        max = max > 1 ? 7 - max : 6;
        min = min > 1 ? 7 - min : 6;


        int[] answer = {max, min};

        return answer;
    }
}
