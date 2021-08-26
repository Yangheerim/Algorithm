package programmers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// https://gwang920.github.io/algorithm/progreammers-1-72412/

public class programmers_순위검색2 {

    static Map<String, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answers = solution(info, query);
        for (int i = 0; i < answers.length; i++) {
            System.out.println(answers[i]);
        }
    }

    public static int[] solution(String[] info, String[] query) {

        int[] answer = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            String[] developer_info = info[i].replaceAll("and ", "").split(" ");

            dfs(0, developer_info, "");
        }

        // 여기서 소팅 해줘야 시간초과 안남
        for (ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
        }

        for (int i = 0; i < query.length; i++) {
            String[] query_tmp = query[i].replaceAll("and ", "").split(" ");
            int score = Integer.parseInt(query_tmp[4]);
            String group = "";
            for (int j = 0; j < 4; j++) {
                group += query_tmp[j];
            }
            answer[i]=countPass(group, score);
        }

        return answer;
    }

    // 이분탐색
    public static int countPass(String group, int score){
        if(!map.containsKey(group)) return 0;
        ArrayList<Integer> arr = map.get(group);

//        Collections.sort(arr); // 여기서 소팅하면 시간초과남. 아마 소팅이 중복될듯

        int start = 0;
        int end = arr.size()-1;
        int mid = (start+end)/2;

        while(start <= end){
            mid = (start+end)/2;

            if(score <= arr.get(mid)){
                end = mid - 1;
            }else if(score > arr.get(mid)){
                start = mid + 1;
            }
        }

        return arr.size()-start;
    }

    public static void dfs(int idx, String[] info, String group) {

        if(idx==4){
            if(!map.containsKey(group)){ // 그룹이 없으면 만든다
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(Integer.parseInt(info[4]));
                map.put(group, arr);
            }else{ // 이미 있으면 리스트에 추가
                map.get(group).add(Integer.parseInt(info[4]));
            }
            return;
        }

        dfs(idx + 1, info, group+info[idx]);
        if(info[idx].charAt(0)!='-'){
            dfs(idx + 1, info, group+"-");
        }
    }

}
