import java.util.HashSet;

public class programmers_소수찾기 {
    static HashSet<Integer> set = new HashSet<>();
    static char[] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }
    public static int solution(String numbers) {

        nums = numbers.toCharArray();
        visited = new boolean[nums.length];
        char[] output = new char[nums.length];

        for(int r=1; r<=nums.length; r++) {
            perm(output, 0, nums.length, r);
        }
        for(int i : set){
            System.out.println(i);
        }
        return set.size();
    }

    // 참고 : https://bcp0109.tistory.com/entry/%EC%88%9C%EC%97%B4-Permutation-Java
    // permutation
    static void perm(char[] output, int depth, int n, int r) {
        if (depth == r) {
            String num = "";
            for(int i=0; i<r; i++){
                num += output[i];
            }
            int numi = Integer.parseInt(num);
            if(isPrime(numi))
                set.add(numi);
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = nums[i];
                perm(output,depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int num){
        if(num==0 || num==1) return false;
        for(int i=2; i<num; i++){
            if(num%i==0) return false;
        }
        return true;
    }

    // 이렇게 하면 순서가 고정이 된다,,
    //    public static void dfs(int idx, int n){
//        if(idx==n){
////            숫자 구해서 소수인지 판별
//            String num = "";
//            for(int i=0; i<n; i++){
//                if(visited[i]) {
//                    num += nums[i];
//                }
//            }
//            if(num.equals("")) return;
//            System.out.println("num="+num);
//            int numi = Integer.parseInt(num);
//            if(isPrime(numi))
//                set.add(numi);
//            return;
//        }
//        visited[idx] = true;
//        dfs(idx + 1, n);
//        visited[idx] = false;
//        dfs(idx + 1, n);
//    }
}
