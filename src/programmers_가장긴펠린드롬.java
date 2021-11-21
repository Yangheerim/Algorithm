package programmers2;

public class programmers_가장긴펠린드롬 {
    public int solution(String s)
    {
        int max = 0;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int length = j - i + 1;
                if (max > length) {
                    continue;
                }
                // s라는 문자열을 substring으로 잘라서 넘기면 효율성 통과 못함!
                // 문자열 자체의 인덱스 값을 넘겨주어 확인할 것
                if (isPalindrome(s, i, j)) {
                    max = length;
                }
            }
        }

        return max;
    }

    public static boolean isPalindrome(String str, int i, int j){
        //5 -> 0 1 2 3 4
        //6 -> 0 1 2 3 4 5

        int left = i;
        int right = j;

        while(left<right){
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
