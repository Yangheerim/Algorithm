import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고: https://imnotabear.tistory.com/117, https://bowbowbow.tistory.com/6
public class boj16916_부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String sub = br.readLine();

        System.out.println(KMP(str, sub));

    }

    public static int[] getPi(String pattern){
        int[] pi = new int[pattern.length()];
        int j = 0;
        for(int i=1; i<pattern.length(); i++){
            while(j>0 && pattern.charAt(i)!=pattern.charAt(j)){
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    public static int KMP(String origin, String ptn) {
        int[] pi = getPi(ptn);
        int answer = 0;
        int j=0;
        for(int i=0;i<origin.length();i++) {
            while(j>0 && origin.charAt(i)!=ptn.charAt(j)) {
                j=pi[j-1];
            }
            if(origin.charAt(i)==ptn.charAt(j)) {
                if(j==ptn.length()-1) {
                    answer=1;
                    break;
                }
                else
                    j++;
            }
        }
        return answer;
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        String sub = br.readLine();
//
//        int n = sub.length();
//
//        for(int i=0; i<str.length(); i++){
//
//            if(str.startsWith(sub, i)){
//                System.out.println(1);
//                return;
//            }
//        }
//        System.out.println(0);
//    }

}
