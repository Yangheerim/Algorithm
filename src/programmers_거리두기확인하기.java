package programmers;

public class programmers_거리두기확인하기 {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int t=0; t<places.length; t++) {
            String[] map = places[t];
            boolean flag = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i].charAt(j)=='P') {
                        if (isAroundExistPerson(i, j, map)) {
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag){
                    answer[t] = 0;
                    break;
                }
            }
            if(!flag){
                answer[t] = 1;
            }
        }

        return answer;
    }

    public static boolean isAroundExistPerson(int i, int j, String[] map){

        // 상하좌우 확인
        int[] mi = {0, 0, 1, -1};
        int[] mj = {1, -1, 0, 0};
        for (int d = 0; d < 4; d++) {
            int ni = i + mi[d];
            int nj = j + mj[d];
            if(ni<0 || ni>=5 || nj<0 || nj>=5) continue;
            if(map[ni].charAt(nj)=='P') return true;
        }

        // 상하좌우 맨하탄 거리 2 확인
        int[] mi2 = {0, 0, 2, -2};
        int[] mj2 = {2, -2, 0, 0};
        for (int d = 0; d < 4; d++) {
            int ni = i + mi2[d];
            int nj = j + mj2[d];
            if(ni<0 || ni>=5 || nj<0 || nj>=5) continue;
            if(map[ni].charAt(nj)=='P') {
                if(map[(i+ni)/2].charAt((j+nj)/2)!='X'){
                    return true;
                }
            }
        }

        // 대각선 확인
        int[] mi3 = {1, 1, -1, -1};
        int[] mj3 = {1, -1, 1, -1};

        for (int d = 0; d < 4; d++) {
            int ni = i + mi3[d];
            int nj = j + mj3[d];
            if(ni<0 || ni>=5 || nj<0 || nj>=5) continue;
            if(map[ni].charAt(nj)=='P') {
                if(!(map[i].charAt(nj)=='X' && map[ni].charAt(j)=='X')){
                    return true;
                }
            }
        }

        return false;
    }
}
