public class programmers_조이스틱 {
    public static void main(String[] args) {
        solution("JEAAAAAAAAAAAN");
    }

    // 참고 : https://by-dev.tistory.com/9
    public static int solution(String name) {
        int answer = 0;

        int exp = name.length() - 1;
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            answer += ('Z'- c + 1) > c - 'A' ? c - 'A' : ('Z' - c + 1); // 위로 or 아래로 더 적게 움직이는거
            if(c == 'A'){
                int nextIdx = i+1;
                int countA = 0;
                while (nextIdx < name.length() && name.charAt(nextIdx) == 'A'){ // 연속된 A의 개수를 센다
                    countA ++;
                    nextIdx++;
                }
                int tmp = (i-1)*2 + (name.length() - nextIdx) ;
//                System.out.println("i="+i+", tmp="+tmp+", name.length = "+name.length()+", nextIdx="+nextIdx);
                if(exp > tmp) exp = tmp;
            }
        }
        answer += exp;
        return answer;
    }
}
