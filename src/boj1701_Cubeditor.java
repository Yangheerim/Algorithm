import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고: https://devowen.com/310
// https://jaimemin.tistory.com/629 (개념참고)

public class boj1701_Cubeditor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int max = 0;
        for(int i=0; i<str.length(); i++){
            max = Math.max(max, getPiMax(str.substring(i, str.length())));
        }

        System.out.println(max);
    }

    // KMP Algorithm
    public static int getPiMax(String pattern){
        int[] pi = new int[pattern.length()];
        int max = -1;
        int j = 0;
        for(int i=1; i<pattern.length(); i++){
            while(j>0 && pattern.charAt(i)!=pattern.charAt(j)){
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                max = Math.max(max, pi[i] = ++j);
                // pi[i] = ++j
            }
        }
        return max;
    }
}
