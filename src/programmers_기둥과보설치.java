package programmers;

import java.util.ArrayList;

public class programmers_기둥과보설치 {
    static int[][][] map;
    static int n_g;

    public static void main(String[] args) {
        int[][] f = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        solution(5, f);
    }

    public static int[][] solution(int n, int[][] build_frame) {


        map = new int[n+1][n+1][2]; // 0은 기둥, 1은 보
        n_g = n;

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2]; // 0이면 기둥, 1이면 보
            int aOrd = build_frame[i][3]; // 0이면 삭제, 1이면 설치

            if(aOrd==1){
                if (isPossible(x, y, type)) {
                    System.out.println("x="+x+", y="+y+" =>가능!");
                    if(type==0) {
                        map[x][y][0] += 1;
                    }else{
                        map[x][y][1] += 1;
                        map[x + 1][y][1] += 1;
                    }
                }
            }else{
                if(type==0){ // 기둥이면
                    map[x][y][0] -= 1;
                }else{ // 보이면
                    map[x][y][1] -= 1;
                    map[x + 1][y][1] -= 1;
                }

                outerLoop:
                for(int j=0; j<n; j++){
                    for (int k = 0; k < n; k++) {
                        if(!isPossible(j,k,0) || !isPossible(j,k,1)){
                            // rollback
                            if(type==0){ // 기둥이면
                                map[x][y][0] += 1;
                            }else{ // 보이면
                                map[x][y][1] += 1;
                                map[x + 1][y][1] += 1;
                            }
                            break outerLoop;
                        }
                    }
                }
            }
        }

        ArrayList<int[]> result = new ArrayList<>();

        for(int x=0; x<n; x++) {
            for (int y = 0; y < n; y++) {
                if(map[x][y][0]>0){
                    result.add(new int[]{x, y, 0});
                }else if(map[x][y][1]>0){
                    result.add(new int[]{x, y, 1});
                }
            }
        }

        int[][] answer = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static boolean isPossible(int x, int y, int type){
        if(type==0){ // 기둥이면
            if(y==0) // 바닥에 닿아있으면
                return true;
            if(map[x][y][1]==1){ // x,y가 보의 한쪽 끝이면
                return true;
            }
            if((y-1>=0 && y-1<=n_g) && map[x][y-1][0]==1){ // x,y가 기둥 위이면
                return true;
            }
        }else{
            if((x+1>=0 && x+1<=n_g) && map[x][y][0]==1 || map[x+1][y][0]==1){ // 한쪽 끝이 기둥 위
                return true;
            }
            if((x+1>=0 && x+1<=n_g) && map[x][y][1]>=1 && map[x+1][y][1]>=1){ // 양쪽 끝이 다른 보 보
                return true;
            }
        }
        return false;
    }

//    public static boolean isDeletePossible(int x, int y, int type){
//        if(type==0){ // 기둥이면
//            if(map[x][y+1][0]==1){ // 기둥 위에 보가 있으면
//                return false;
//            }
//            if(map[x][y+1][1]==1 && map[x+1][y][0]==0){
//                return false;
//            }
//        }else{ // 보이면
//            if(){
//
//            }
//        }
//        return false;
//    }
}
