package programmers;

// https://cnwlcjf.tistory.com/64
// 각자리수 계산을 위해 나머지를 구하는 과정에서 나머지가 0일 경우 나누어지는 수 n에서 1을 빼줘야한다.

public class programmers_124나라 {
    public String solution(int n) {
        String answer = "";
        int namugy = 0;

        while (n > 0) {
            namugy = n % 3;
            n = n / 3;

            if (namugy == 0) {
                n -= 1;     //???
                namugy = 4;
            }

            answer = namugy + answer;
        }

        return answer;
    }
}
/*

1 2 4
11 12 14
21 22 24
41 42 44
111 112 114
121 122 124
141 142 144
211 212 214
221 222 224
241 242 244

3진법의 변형이라고 생각하면 된다.


 */