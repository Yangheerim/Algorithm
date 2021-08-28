package programmers;

public class programmers_문자열압축 {

    public int solution(String s) {
        int answer = s.length();


        for (int i = 1; i < s.length(); i++) {
            if(s.length() % 2 != 0) continue;

            int idx = 0;
            String prev = "";
            String result = "";
            int cnt = 1;

            while(idx+i < s.length()){
                String now = s.substring(idx, idx + i);

                if(now.equals(prev)) { // 전꺼랑 같으면
                    cnt ++;
                }else { // 전꺼랑 다르면
                    if(cnt>1){
                        result += (cnt + now);
                    }else{
                        result += now;
                    }
                    cnt = 1;
                }

                prev = now;
                idx += i;

            }
            System.out.println(result);
            answer = Math.min(answer, result.length());

        }


        return answer;
    }

}
