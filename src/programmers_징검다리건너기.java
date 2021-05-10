public class programmers_징검다리건너기 {
    public static void main(String[] args) {
    }
    // 참고 : https://velog.io/@jwkim/2019-kakao-winter-internship-stepping-stone
    public int solution(int[] stones, int k) {
        int answer = 0;
        int max = 0;
        int min = 200000000;

        for (int i = 0; i < stones.length; i++) {
            max = Math.max(stones[i], max);
            min = Math.min(stones[i], min);
        }

        int left = min;
        int right = max;

        while (left <= right) {
            int mid = (left+right)/2;

            if (available(mid, stones, k)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private boolean available(int count, int[] stones, int k) {
        int jump_count = 0;
        for (int i = 0; i < stones.length && jump_count < k; i++)
            if (stones[i] - count < 0) jump_count++;
            else jump_count = 0;
        return jump_count < k;
    }

    // 정답률 100%, But 효율성 제로 코드
    public int solution2(int[] stones, int k) {
        int answer = 0; // 건넌 학생 수

        int zero_cnt = 0;
        outerLoop:
        while(true){
            zero_cnt = 0;
            for(int i=0; i<stones.length; i++){
                if(stones[i]>0){
                    stones[i]--;
                    zero_cnt = 0;
                }else{
                    zero_cnt ++;
                }
                if(zero_cnt==k) break outerLoop;
            }
            answer++;

        }

        return answer;
    }
}
