import java.util.Arrays;

public class programmers_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int n = people.length;
        boolean[] selected = new boolean[n];


        for(int i=0; i<n; i++){
            if(selected[i]) continue;
            int now = people[i];
            int max = 0;
            int max_idx = -1;
            for (int j = i+1; j < n; j++) {
                if(selected[j]) continue;
                if(now+people[j]<=limit){
                    if(max<people[j]){
                        max = people[j];
                        max_idx = j;
                    }
                }
            }

            selected[i] = true;
            if(max_idx!=-1){
                selected[max_idx] = true;
            }

            answer++;

        }

        return answer;
    }
}
