import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 모음 1개 자음 2개 조건은 괜히 준게 아니다
// 하드코딩 제발..

public class boj1759_암호만들기 {
    static char[] chars;
    static char[] selected;
    static boolean[] visited;
    static int L;
    static int C;
    static ArrayList<String> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        selected = new char[L];
        chars = new char[C];
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        visited = new boolean[C];
        arr = new ArrayList<>();
        dfs(0);

        Collections.sort(arr);
//        Collections.sort(arr, Collections.reverseOrder()); // 내림차순

        for (String code : arr) {
            System.out.println(code);
        }
    }

    static public void dfs(int count){
        if (count == L) {
            if(checkPossible()){
                arr.add(new String(selected));
            }
            return;
        }
        for (int i = 0; i < C; i++) {
            if (!visited[i]) {
                if(count==0 || selected[count-1]<chars[i]){
                    selected[count] = chars[i];
                    visited[i] = true;
                    dfs(count + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static public boolean checkPossible() {
        // 모음 1개, 자음 2개 이상 있는지 확인
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        int cnt_vowel = 0;
        for (char c : selected) {
            for (char v : vowel) {
                if(c==v) {
                    cnt_vowel++;
                }
            }
        }
        if(cnt_vowel==0) return false;

        return (L - cnt_vowel) >= 2;
    }
}
