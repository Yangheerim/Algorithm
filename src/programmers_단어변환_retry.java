package programmers2;

public class programmers_단어변환 {

    static boolean[] visited;
    static int min = 100;
    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];

        dfs(begin, 0, target, words);

        return min == 100 ? 0 : min;
    }

    public static void dfs(String now, int cnt, String target, String[] words){
        if(now.equals(target)){
            min = Math.min(min, cnt);
            return;
        }

        for(int i=0; i< words.length; i++){
            if (!visited[i] && isSimilar(now, words[i])) {
                visited[i] = true;
                dfs(words[i], cnt + 1, target, words);
                visited[i] = false;
            }
        }
    }

    public static boolean isSimilar(String s1, String s2){
        int cnt = 0;

        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)) cnt++;
        }

        return cnt == 1;
    }
}
