import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
문자열을 쪼개 나오는 최소 개수의 팰린드롬을 구하는 문제
dp 행렬을 만들어 풀이함.
DP[i][j] : Str[i] ~ Str[j]의 부분문자열이 팰린드롬인지 아닌지 알려주는 Boolean 배열
Result[i] : Str[1]~Str[i]의 부분문자열에 존재하는 최소 팰린드롬 개수
참고 : https://imnotabear.tistory.com/65
 */
public class p2079 {
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = (" "+br.readLine()).toCharArray();
        dp = new boolean[string.length+1][string.length+1];
        int[] result = new int[string.length+1];
//        System.out.println(string);

        // 길이가 1이면 항상 펠린드롬
        for(int i=1; i<=string.length; i++){
            dp[i][i] = true;
        }
        // 오른쪽과 같다면 (길이는 2) 펠린드롬
        for(int i=1; i<string.length-1; i++){
            if (string[i] == string[i+1]) {
                dp[i][i+1] = true;
                dp[i+1][i] = true;
            }
        }
        palindrome(string);

        // dp[][] test
//        for(int i=0; i<=string.length; i++){
//            for(int j=0; j<=string.length; j++){
//                System.out.print(dp[i][j]?"T ":"F ");
//            }
//            System.out.println();
//        }

        for(int i=1; i<=string.length; i++){
            for(int j=1; j<=i; j++){
                if(dp[i][j]){
                    if (result[i] == 0 || result[i] > result[j - 1] + 1) {
                        result[i] = result[j - 1] + 1;
                    }
                }
            }
        }
        System.out.println(result[string.length-1]);

    }

    static void palindrome(char[] str){
        for(int i=2; i<str.length; i++){
            for(int j=1; j<str.length-i; j++){
//                System.out.println("i="+i+", j="+j);
                // 문자열의 양옆 글자가 같고, 양옆 글자를 제외한 부분문자열이 팰린드롬이라면 해당 문자열은 팰린드롬
                if (str[j] == str[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j+i] = dp[j+i][j] = true;
                }
            }
        }
    }
}
