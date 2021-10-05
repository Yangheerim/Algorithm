package programmers;

import java.util.HashSet;

public class programmers_영어끝말잇기 {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String s1 = "tank";
        set.add(s1);
        String s2 = "tank";
        System.out.println(set.contains(s2));
    }

    public int[] solution(int n, String[] words) {

        int turn = 1; // -> turn % n + 1

        HashSet<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String now = words[i];

            System.out.println("i="+i+" ------");


            if(set.contains(now) || words[i-1].charAt(words[i-1].length()-1) != now.charAt(0)){
                return new int[]{turn % n + 1, i/n+1};
            }

            set.add(now);
            turn ++;

        }

        return new int[]{0,0};
    }
}

/*
순서     turn    차례
0        0       1
1        1       1
2        2       1
3        0       2
4        1       2
5        2       2

 */