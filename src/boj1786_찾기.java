import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj1786_찾기 {

    static ArrayList<Integer> idx = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String pattern = br.readLine();

        KMP(str, pattern);

        System.out.println(idx.size());
        for (int i : idx) {
            System.out.print(i+" ");
        }

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

    public static void KMP(String origin, String ptn) {
        int[] pi = getPi(ptn);
        int j=0;
        for(int i=0;i<origin.length();i++) {
            while(j>0 && origin.charAt(i)!=ptn.charAt(j)) {
                j=pi[j-1];
            }
            if(origin.charAt(i)==ptn.charAt(j)) {
                if(j==ptn.length()-1) {
                    idx.add(i-ptn.length()+2);
                    j = pi[j]; // 초기화 해줘야함!
                }
                else
                    j++;
            }
        }
    }

}
