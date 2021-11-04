package programmers2;

public class programmers_JadenCase문자열만들기 {
    public static void main(String[] args) {
        solution("3people unFollowed me");
    }
    public static String solution(String s) {
        String answer = "";

        s = s.toLowerCase();

        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            if(now == ' '){
                answer += " ";
            }else if((i==0 && isLowerCase(now)) || (i>0 && s.charAt(i-1)==' ' && isLowerCase(now))){
                answer += Character.toUpperCase(now);
            }else{
                answer += now;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static boolean isLowerCase(char c){
        return c>='a' && c<='z';
    }
}
