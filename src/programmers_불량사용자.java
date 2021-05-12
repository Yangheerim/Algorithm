import java.util.ArrayList;
import java.util.HashSet;

public class programmers_불량사용자 {
    static ArrayList<ArrayList<String>> list;
    static HashSet<HashSet<String>> set;

    public static void main(String[] args) {
//        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] user_id = {"12345", "12453", "aaaaa", "baaaa"};
//        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id = {"*rodo", "*rodo", "******"};
        String[] banned_id = {"*****", "*****"};
//        String[] banned_id = {"fr*d*", "abc1**"};
        solution(user_id, banned_id);
    }

    public static int solution(String[] user_id, String[] banned_id) {
        list = new ArrayList<>();

        for(int i=0; i<banned_id.length; i++){
            list.add(isPossibleMatching(user_id, banned_id[i]));
        }

        set = new HashSet<>();
        HashSet<String> picked = new HashSet<>();
        dfs(0, banned_id.length, picked);
        System.out.println(set.size());
        return set.size();
    }

    // 경우의 수 찾는 dfs
    public static void dfs(int idx, int n, HashSet<String> picked){
        if(picked.size()==n){
            System.out.println();
            set.add(new HashSet<>(picked));
            return;
        }

        for (String s : list.get(idx)) {
            if(!picked.contains(s)){
                picked.add(s);
                dfs(idx + 1, n, picked);
                picked.remove(s);
            }
        }
    }

    public static ArrayList<String> isPossibleMatching(String[] user_id, String banned_id){
        ArrayList<String> arr = new ArrayList<>();
        for (String id : user_id) {
            if(id.length() != banned_id.length()) continue;
            boolean possible = true;
            for(int i=0; i<banned_id.length(); i++){
                if(id.charAt(i)=='*' || banned_id.charAt(i)=='*') continue;
                if(id.charAt(i)!=banned_id.charAt(i)) {
                    possible = false;
                    break;
                }
            }
            if(possible) {
                arr.add(id);
                System.out.print(id+" ");
            }

        }
        System.out.println();
        return arr;
    }
}
