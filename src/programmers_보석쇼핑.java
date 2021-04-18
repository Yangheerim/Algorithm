import java.util.*;
import java.util.Queue;

// 참고 : https://tosuccess.tistory.com/133
public class programmers_보석쇼핑 {

    public static void main(String[] args) {
        String[] ex = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        solution(ex);

    }

    // Two point 방식
    // HashSet : 보석들의 종류 구함
    // HashMap : point to point 까지 각 보석 종류가 몇개인지 구함
    // Queue : 구간을 본다. 맨 앞에꺼가 2개이면 빼준다.
    public static int[] solution(String[] gems) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> map = new HashMap<>();

        int start = 0;
        int length = Integer.MAX_VALUE;

        int startPoint = 0;
        for(int i=0; i<gems.length; i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            queue.add(gems[i]);

            while(true){
                String tmp = queue.peek();
                if(map.get(tmp)>1){
                    queue.poll();
                    start ++;
                    map.put(tmp, map.get(tmp) - 1);
                }else{
                    break;
                }
            }

            // 모두 포함되면
            if (map.size() == set.size() && length > queue.size()) {
                length = queue.size();
                startPoint = start;
            }

        }

        return new int[] {startPoint+1, startPoint+ length };
    }


    // O(n^3)으로 푸는 방법. 당연히 시간초과 남
//    public static int[] solution(String[] gems) {
//
//        int n = gems.length;
//
//        HashSet<String> gem_list = new HashSet<>(Arrays.asList(gems));
//        int gem_nums = gem_list.size();
//
//        int start = 0;
//        int end = 0;
//        int length = 100001;
//
//        int[][] dp = new int[n][n];
//
//        HashSet<String> set = new HashSet<>();
//
//        for(int i=0; i<n; i++){
//            for(int j=i; j<n; j++){
//                if(j-i+1 <gem_nums) continue;
//                for(int k=i; k<=j; k++){
//                    set.add(gems[k]);
//                }
//                if(set.size()==gem_nums){ // 다 포함됐으면
//                    if(j-i+1 < length) {
//                        start = i;
//                        end = j;
//                        length = j-i + 1;
//                    }else if(j-i+1 == length){ //length가 같을 때 start가 작은거로
//                        if(i<=start){
//                            start = i;
//                            end = j;
//                        }
//                    }
//                }
//                set.clear();
//            }
//        }
//        int[] answer = {start+1, end+1};
//        return answer;
//    }
}
