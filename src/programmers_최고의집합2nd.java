package programmers2;

import java.util.Arrays;

//  각 원소의 합이 S가 되는 것이 집중 하기보다 어떻게 하면 최대 곱이 나올 것인지에 집중!!
// https://tosuccess.tistory.com/76
public class programmers_최고의집합2nd {
    public int[] solution(int n, int s) {
        int[] answer = {-1};

        if(n>s){
            return answer;
        }
        answer = new int[n];
        int tmp = s % n;
        if (tmp == 0) {
            for (int i = 0; i < n; i++) {
                answer[i] = s / n;
            }
        }else{
            int position = n - tmp; // 1씩 더해줘야하는 인덱스 위치
            for (int i = 0; i < position; i++) {
                answer[i] = s / n;
            }
            for (int i = position; i < n; i++) {
                answer[i] = s / n + 1;
            }
        }

        return answer;
    }
}
