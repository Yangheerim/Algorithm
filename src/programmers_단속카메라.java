import java.util.Arrays;

public class programmers_단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0; // 카메라의 개수
        int camera = -30001; // 카메라의 위치

        //량이 나간 지점을 기준으로 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        for(int[] route : routes){
            if(camera<route[0]){
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }
}
