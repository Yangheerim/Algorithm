import java.util.ArrayList;
import java.util.Collections;
// 참고 : https://youjourney.tistory.com/111

public class programmers_여행경로 {
    static boolean[] used;
    static String route = "";
    static ArrayList<String> route_list;


    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };
        solution(tickets);
    }

    public static String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        route_list = new ArrayList<>();

        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                used[i] = true;
                route = tickets[i][0]+",";
                dfs(tickets[i][1], 1, tickets);
                used[i] = false;
            }

        }
        Collections.sort(route_list);
        String[] answer = route_list.get(0).split(",");
        return answer;
    }

    public static void dfs(String end, int cnt, String[][] tickets) {
        route += end + ",";
        if(cnt == tickets.length){
            route_list.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(end.equals(tickets[i][0]) && !used[i]){
                used[i] = true;
                dfs(tickets[i][1], cnt+1, tickets);
                used[i] = false;
                route = route.substring(0, route.length()-4);
            }
        }
    }
}
