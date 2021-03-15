public class programmers_큰수만들기 {

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
    }
//    참고 : https://ukyonge.tistory.com/197
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int digits = number.length()-k; // 만들어야하는 자릿수
        int s_idx=0;
        for(int i=0; i<digits; i++){
            char max = '0';
            for(int j=s_idx; j<=i+k; j++){
                if (number.charAt(j) > max) {
                    max = number.charAt(j);
                    s_idx = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }

//    이렇게 하면 시간초과 ,,,
//    public static String solution(String number, int k) {
//        nums = number.toCharArray();
//        visited = new boolean[nums.length];
//        dfs(0, 0, nums.length, nums.length - k);
//        return max;
//    }
//
//    static void dfs(int idx, int count, int n, int r) {
//        if (count == r) {
//            String num = "";
//            for(int i=0; i<n; i++){
//                if(visited[i]) num += nums[i];
//            }
//            if(num.equals("")) return;
//            if (num.compareTo(max) > 0) {
//                max = num;
//            }
//            return;
//        }
//        if(idx>=n) return;
//
//        visited[idx] = true;
//        dfs(idx + 1, count + 1, n, r);
//        visited[idx] = false;
//        dfs(idx + 1, count, n, r);
//    }

}
