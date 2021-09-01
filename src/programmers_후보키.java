package programmers;

import java.util.HashSet;

public class programmers_후보키 {
    public static void main(String[] args) {
        String[][] relation =
            {{"100","ryan","music","2"},
            {"200","apeach","math","2"},
            {"300","tube","computer","3"},
            {"400","con","computer","4"},
            {"500","muzi","music","3"},
            {"600","apeach","music","2"}};
        solution(relation);
    }

    static String[][] g_relation;
    static HashSet<String> set;

    public static int solution(String[][] relation) {
        g_relation = relation;
        set = new HashSet<>();

        // 튜플을 1개 선택하는 방법, 2개 선택하는 방법, ...
        for (int i = 1; i <= relation[0].length; i++) {
            boolean[] selected = new boolean[relation[0].length];
            dfs(0, 0, i, selected);

        }
        System.out.println(set.size());
        return set.size();
    }

    public static void dfs(int idx, int cnt, int max, boolean[] selected){
        if(cnt==max){
            String cols = "";
            for (int i = 0; i < selected.length; i++) {
                if(selected[i]){
                    cols += i;
                }
            }
//            System.out.println(cols);
            if(findIsPossible(cols, selected)){
                set.add(cols);
//                System.out.println(cols+" 가능!");
            }
            return;
        }

        if(idx>=selected.length) return;

        selected[idx] = true;
        dfs(idx + 1, cnt + 1, max, selected);

        selected[idx] = false;
        dfs(idx + 1, cnt, max, selected);

    }

    public static boolean findIsPossible(String cols, boolean[] selected) {

        // 이미 구성되어있는 column이 후보키 셋으로 되어있는 경우 (최소성이 만족되지 않는 경우)
        // 234=cols / 24=s(이미 있음)
        for (String s : set) {
            boolean flag = true; // cols 안에 s 안의 컬럼 리스트가 모두 포함되어있는지 여부
            for (int i = 0; i < s.length(); i++) {
                if(!cols.contains(s.charAt(i)+"")){
                    flag = false;
                }
            }

            if(flag){ // 모두 포함되어있으면
                return false;
            }
        }

        HashSet<String> values = new HashSet<>();
        int[] col_name = new int[cols.length()];
        int idx = 0;
        for (int i = 0; i < selected.length; i++) {
            if(selected[i]){
                col_name[idx++] = i;
            }
        }

        String value = "";
        for (int i = 0; i < g_relation.length; i++) {
            value = "";
            for (int j = 0; j < col_name.length; j++) {
                value += g_relation[i][col_name[j]];
            }
//            System.out.println("value="+value);
            if(values.contains(value)){
                return false;
            }else{
                values.add(value);
            }
        }

        return true;
    }
}
