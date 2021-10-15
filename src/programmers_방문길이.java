package programmers;

import java.util.HashSet;

// https://gre-eny.tistory.com/174
public class programmers_방문길이 {

    public static void main(String[] args) {
        solution("ULURRDLLU");
        System.out.println("----------------");
        solution("LULLLLLLU");
    }

    public static int solution(String dirs) {

        HashSet<String> set = new HashSet<>();
        int now_i = 0, now_j = 0;


        for(int i=0; i<dirs.length(); i++){
            char move = dirs.charAt(i);

            int prev_i = now_i;
            int prev_j = now_j;

            switch (move){
                case 'L':
                    if (now_j - 1 < -5) {
                        break;
                    }
                    now_j --;
                    break;
                case 'R':
                    if (now_j + 1 > 5) {
                        break;
                    }
                    now_j ++;
                    break;
                case 'U':
                    if (now_i + 1 >5) {
                        break;
                    }
                    now_i ++;
                    break;
                case 'D':
                    if (now_i - 1 < -5) {
                        break;
                    }
                    now_i --;
                    break;
            }

            // 이거 안해주면 실패
            if(now_i == prev_i && now_j == prev_j) continue;

            set.add(now_i + "" + now_j + "" + prev_i + "" + prev_j);
            set.add(prev_i + "" + prev_j + "" + now_i + "" + now_j);
        }

        return set.size()/2;
    }

//    public static int solution(String dirs) {
//
//        boolean[][] map = new boolean[10][10];
//
//        int now_i = 0;
//        int now_j = 0;
//
//        for(int i=0; i<dirs.length(); i++){
//            char move = dirs.charAt(i);
//
//            System.out.println((now_i)+","+(now_j));
//            map[now_i+4][now_j+4] = true;
//
//            switch (move){
//                case 'L':
//                    if (now_j - 1 < -5 || now_j - 1 > 5) {
//                        break;
//                    }
//                    now_j --;
//                    break;
//                case 'R':
//                    if (now_j + 1 < -5 || now_j + 1 > 5) {
//                        break;
//                    }
//                    now_j ++;
//                    break;
//                case 'U':
//                    if (now_i - 1 < -5 || now_i - 1 > 5) {
//                        break;
//                    }
//                    now_i --;
//                    break;
//                case 'D':
//                    if (now_i + 1 < -5 || now_i + 1 > 5) {
//                        break;
//                    }
//                    now_i ++;
//                    break;
//            }
//
//        }
//
//        int cnt=0;
//        for(int i=0; i<11; i++){
//            for(int j=0; j<11; j++){
//                if(map[i][j]) cnt++;
//            }
//        }
//
//        System.out.println("cnt="+cnt);
//        return cnt;
//    }
}
