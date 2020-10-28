import java.util.ArrayList;
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();

        int testcase_num = sc.nextInt(); // 테스트 케이스 개수
        for(int i=0; i<testcase_num; i++) {
            int word_num = sc.nextInt(); // 단어의 개수
            sc.nextLine(); // 엔터 버퍼
            for(int j =0; j<word_num; j++){
                words.add(sc.nextLine());
            }
            ArrayList<String> results = new ArrayList<>();
            for (int word1 = 0; word1 < words.size(); word1++) {
                for (int word2 = 0; word2 < words.size(); word2++) {
                    if(word1 == word2) continue;
                    String tmp = words.get(word1).concat(words.get(word2));
//                    System.out.println("test--> "+tmp);
                    if(isPalindrome(tmp)){
                        results.add(tmp);
                    }
                }
            }
            if(results.size()==0){
                System.out.println(0);
            }else{
                System.out.println(results.get(0));
            }
            results.clear();
            words.clear();
        }
    }

    static boolean isPalindrome(String str){
        int length = str.length();
        // index의 끝은 length-1

        for (int i = 0; i < length / 2 + 1; i++) {
            if(str.charAt(i) != str.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }


}
