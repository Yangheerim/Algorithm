package programmers;

public class programmers_문자열압축 {

    public static void main(String[] args) {
        solution("abcabcabcabcdededededede");

    }

    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length()/2; i++) {
            System.out.println("i="+i);

            int idx = 0;
            String prev = "";
            String result = "";
            int cnt = 1;

            while(idx < s.length()){
                String now;
                if(idx+i<s.length()) {
                    now = s.substring(idx, idx + i);
                }else{
                    now = s.substring(idx, s.length());
                }

                if(now.equals(prev)) { // 전꺼랑 같으면
                    cnt ++;
                }else { // 전꺼랑 다르면
                    if(cnt>1){
                        result += (cnt + prev);
                    }else{
                        result += prev;
                    }
                    cnt = 1;
                }

                prev = now;
                idx += i;

            }

            if(cnt>1){
                result += (cnt + prev);
            }else{
                result += prev;
            }

            answer = Math.min(answer, result.length());

        }

        return answer;
    }

}
