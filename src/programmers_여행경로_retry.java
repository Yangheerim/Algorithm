package programmers2;

import java.util.ArrayList;
import java.util.Collections;

public class programmers_여행경로 {
    static int n;
    static boolean[] used;
    static ArrayList<String> arr;

    public String[] solution(String[][] tickets) {
        n = tickets.length;
        used = new boolean[n];
        arr = new ArrayList<>();

        dfs("ICN", 0, "ICN",  tickets);

        Collections.sort(arr);

        return arr.get(0).split("/");
    }

    public static void dfs(String now, int cnt, String result, String[][] tickets){
        if(cnt == n){
            arr.add(result);
            return;
        }

        for(int i=0; i<n; i++){
            if(!used[i] && tickets[i][0].equals(now)){
                used[i] = true;
                dfs(tickets[i][1], cnt + 1, result+"/"+tickets[i][1], tickets);
                used[i] = false;
            }
        }
    }
}
