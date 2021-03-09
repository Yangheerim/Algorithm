public class programmers_타켓넘버 {
    static int n;
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        n = numbers.length;

        answer = dfs(0, target, 0, numbers);

        return answer;
    }

    public static int dfs(int idx, int target, int sum, int[] numbers){
        if(idx==n){
            if(sum==target) return 1;
            return 0;
        }
        int now = numbers[idx];
        int result = 0;
        result += dfs(idx + 1, target, sum + now, numbers);
        result += dfs(idx + 1, target, sum - now, numbers);

        return result;
    }
}
