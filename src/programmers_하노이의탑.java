package programmers2;

import java.util.ArrayList;

//https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%95%98%EB%85%B8%EC%9D%B4%EC%9D%98-%ED%83%91-Java
public class programmers_하노이의탑 {

    static ArrayList<int[]> arr;
    public int[][] solution(int n) {
        arr = new ArrayList<>();

        hanoi(n, 1, 3, 2);

        int[][] answer = new int[arr.size()][2];
        for(int i = 0 ; i < arr.size() ; ++i){
            int[] tmp = arr.get(i);
            answer[i][0] = tmp[0];
            answer[i][1] = tmp[1];
        }

       return answer;
    }
    /*
    n이 1일 때
        출발지의 원판을 도착지로 옮긴다.
    나머지의 경우
        출발지에 있는 n - 1개의 원판을 경유지로 옮긴다.
        출발지에 있는 한 개의 원판을 도착지로 옮긴다.
        경유지에 있는 n - 1개의 원판을 도착지로 옮긴다.
     */
    private void hanoi(int n, int from, int to, int via){

        if(n==1){
            arr.add(new int[]{from, to});
        }else{
            hanoi(n-1, from, via, to); // n-1개를 경유지로 옮김
            arr.add(new int[]{from, to});
            hanoi(n-1, via, to, from);
        }
    }
}
