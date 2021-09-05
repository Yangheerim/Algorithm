package programmers;

import java.util.ArrayList;

public class programmers_뉴스클러스터링 {

    public static void main(String[] args) {
        solution("FRANCE", "french");
        solution("E=M*C^2", "e=m*c^2");
    }

    public static int solution(String str1, String str2) {

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = str1.substring(i, i + 2);
            if (isAllChar(tmp)) {
                arr1.add(tmp);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp = str2.substring(i, i + 2);
            if (isAllChar(tmp)) {
                arr2.add(tmp);
            }
        }

        if(arr1.size()==0 && arr2.size()==0){
            return 65536;
        }

        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        for (String s : arr1) {
            if(arr2.contains(s)){
                arr2.remove(s);
                intersection.add(s);
            }
            union.add(s);
        }

        union.addAll(arr2);

        return (int)(((double)intersection.size()/ (double) union.size()) * 65536);

        // 이렇게 하면 안됨. 이미 합집합으로 카운트된게 또 카운트 될 수 있음
//        int common_cnt = 0;
//        for (String s : arr1) {
//            if(arr2.contains(s)){
//                common_cnt ++;
//            }
//        }
//
//        int total_cnt = arr1.size() + arr2.size() - common_cnt;
//
//        return (int)(((double)common_cnt/ (double) total_cnt) * 65536);
    }

    public static boolean isAllChar(String str){
        return (str.charAt(0) >= 65 && str.charAt(0) <= 90) && (str.charAt(1) >= 65 && str.charAt(1) <= 90);
    }

}
