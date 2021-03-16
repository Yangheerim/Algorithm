import java.util.HashSet;
import java.util.Set;
public class programmers_N으로표현 {

    public int solution(int N, int number) {
        int answer = -1;
        Set<Integer>[] setArr = new Set[9];
        int t = N;
        for(int i = 1; i < 9; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(t);
            t = t * 10 + N;
        }
        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                for(Integer a : setArr[j]) {
                    for(Integer b : setArr[i - j]) {
                        setArr[i].add(a + b);
                        setArr[i].add(a - b);
                        setArr[i].add(b - a);
                        setArr[i].add(a * b);
                        if(b != 0) {
                            setArr[i].add(a / b);
                        }
                        if(a != 0) {
                            setArr[i].add(b / a);
                        }
                    }
                }
            }
        }
        for(int i = 1; i < 9; i++) {
            if(setArr[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

//    통과되었지만 잘못된 코드
//    반례 : 26 = 5*5 + 5/5

//    private static int n;
//    private static int target;
//    private static int answer = Integer.MAX_VALUE;


//    public static int solution(int N, int number) {
//        n = N;
//        target = number;
//        dfs(0, 0);
//        return answer == Integer.MAX_VALUE ? -1 : answer;
//    }
//
//    private static void dfs(int count, int prev) {
//        if (count > 8) {
//            answer = -1;
//            return;
//        }
//
//        if (prev == target) {
//            answer = Math.min(answer, count);
//            return;
//        }
//
//        int tempN = n;
//        for (int i = 0; i < 8 - count; i++) {
//            int newCount = count + i + 1;
//            dfs(newCount, prev + tempN);
//            dfs(newCount, prev - tempN);
//            dfs(newCount, prev / tempN);
//            dfs(newCount, prev * tempN);
//            tempN = tempN * 10 + n;
//        }
//    }

}
