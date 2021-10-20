package programmers2;

public class programmers_타켓넘버 {
    static int count = 0;
    public static int solution(int[] numbers, int target) {

        dfs(numbers, 0, 0, target);


        return count;
    }

    public static void dfs(int[] numbers, int idx, int sum, int target) {
        if(idx == numbers.length){
            if(sum == target){
                count ++;
            }
            return;
        }

        dfs(numbers, idx + 1, sum + numbers[idx], target);
        dfs(numbers, idx + 1, sum - numbers[idx], target);
    }
}

/*

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

 */