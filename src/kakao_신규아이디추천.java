public class kakao_신규아이디추천 {
    public static void main(String[] args) {
        System.out.println(solutions("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solutions("z-+.^."));
        System.out.println(solutions("=.="));
        System.out.println(solutions("123_.def"));
        System.out.println(solutions("abcdefghijklmn.p"));

    }
    public static String solutions(String new_id){
        String answer = new_id;

        // step 1
        answer = answer.toLowerCase();

        // step 2 - 숫자와 알파벳, 콤마(,), 언더바(_) 이외의 문자 모두 제거
        answer = answer.replaceAll("[^-_.a-z0-9]", "");

        // step 3 - 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        answer = answer.replaceAll("[.]{2,}", ".");

        // step 4
        answer = answer.replaceAll("^[.]|[.]$", "");

        // step 5
        if (answer.equals("")) {
            answer = "a";
        }

        // step 6
        if(answer.length()>15){
            answer = answer.substring(0, 15);
            if(answer.charAt(14) == '.'){
                answer = answer.substring(0, 14);
            }
        }

        // step 7
        if(answer.length()<=2){
            while(!(answer.length()>2)) {
                int idx = answer.length() - 1;
                answer += answer.charAt(idx);
            }
        }

        return answer;
    }


}
