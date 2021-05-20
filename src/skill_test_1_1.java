import java.util.Arrays;

public class skill_test_1_1 {

    static class Stage{
        int idx;
        double fail;

        public Stage(int idx) {
            this.idx = idx;
            this.fail = 0;
        }
    }

    public static void main(String[] args) {

        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        solution(5, stages);

    }

    public static int[] solution(int N, int[] stages) {
        Stage[] stage_info = new Stage[N];
        for (int i = 0; i < N; i++) {
            stage_info[i] = new Stage(i+1);
        }

        int player = 0;
        int not_clear = 0;
        for (int i = 1; i <= N; i++) {
            player = 0;
            not_clear = 0;
            for (int j = 0; j < stages.length; j++) {
                if(stages[j]==i){
                    not_clear++;
                }
                if(stages[j]>=i){
                    player++;
                }
            }
            if(player==0) {
                stage_info[i - 1].fail = 0;
                continue;
            }
            stage_info[i - 1].fail = (double)not_clear / (double)player;

        }

        Arrays.sort(stage_info, (s1, s2)-> Double.compare(s2.fail,s1.fail));
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stage_info[i].idx;
        }

        return answer;
    }

}
