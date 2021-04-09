import java.util.Arrays;

public class programmers_입국심사 {

// 코드 : https://iamheesoo.github.io/blog/algo-prog43238
// 참고 : https://velog.io/@ollabu3/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9E%85%EA%B5%AD%EC%8B%AC%EC%82%AC

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long min=1;//최적의 경우 1초로 초기화
        long max=(long)times[times.length-1]*n;//최악의 경우로 초기화
        long mid=0;
        long sum;
        long answer = max;

        while(min<=max){
            sum=0;
            mid=(min+max)/2;
            for(int time:times){
                sum+=mid/time;//심사관 당 맡을 수 있는 입국자 수
            }
            if(sum>=n){//더 맡을 수 있으므로 시간 줄임
                if(mid<answer){
                    answer=mid;
                }
                max=mid-1;
            }
            else{//불가하므로 시간 늘림
                min=mid+1;
            }
        }

        return answer;
    }


}
