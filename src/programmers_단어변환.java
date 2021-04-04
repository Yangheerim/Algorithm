import java.util.ArrayList;
import java.util.Arrays;

public class programmers_단어변환 {

    static String begin_;
    static String target_;
    static ArrayList<String> arr;
    static boolean[] visited;

    static int min = 100;

    public static void main(String[] args) {
//        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};
        solution("hit", "cog", words2);
    }

    public static int solution(String begin, String target, String[] words) {
        arr = new ArrayList<>();
        arr.addAll(Arrays.asList(words));
        visited = new boolean[arr.size()];

        begin_ = begin;
        target_ = target;

        dfs( 0, begin);

        if(min==100) min = 0;
        return min;
    }

    public static void dfs(int count, String cur){
        if (cur.equals(target_)) {
            min = Math.min(min, count);
            return;
        }

        for(int i=0; i<arr.size(); i++){
            String tmp = arr.get(i);
            if(isSimilar(cur, tmp) && !visited[i]){
                visited[i] = true;
                dfs( count + 1, tmp);
                visited[i] = false;
            }
        }

    }

    // 한글자만 다른 비슷한 word인지 확인하는 메소드
    public static boolean isSimilar(String s1, String s2){
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        int cnt = 0;
        for(int i=0; i<a.length; i++){
            if(a[i]==b[i]) cnt++;
        }

        if(cnt == a.length-1) return true;

        return false;
    }


}
