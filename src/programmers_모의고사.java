import java.util.ArrayList;
import java.util.Collections;

public class programmers_모의고사 {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,2};
        solution(arr);
    }

    public static int[] solution(int[] answers) {
        int[][] pattern = {
                {},
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] score = new int[4];
        for(int i=0; i< answers.length; i++){
            for(int s=1; s<=3; s++){
                int idx = i % (pattern[s].length);
                if(pattern[s][idx] == answers[i]){
                    score[s]++;
                }
            }
        }
        int max = 0;
        for(int s=1; s<=3; s++){
            max = Math.max(max, score[s]);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int s=1; s<=3; s++){
            if(score[s]==max){
                arr.add(s);
            }
        }
        Collections.sort(arr);
        int[] answer = new int[arr.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = arr.get(i);
            System.out.println(answer[i]);
        }

        return answer;
    }


}
