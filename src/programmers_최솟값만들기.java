package programmers2;

import java.util.Arrays;

public class programmers_최솟값만들기 {
    // 최솟값을 구하기 위한 규칙은 각 배열에서 가장 작은 값과 가장 큰 값을 곱하는 것

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;

        for (int i = 0; i < n; i++) {
            answer += A[i]*B[n-1-i];
        }

        return answer;
    }
}
