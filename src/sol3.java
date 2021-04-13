import java.util.ArrayList;

public class sol3 {

    static Station[] stations;
    static int total = 0;

    static class Station{
        int idx;
        int passenger;
        ArrayList<Station> adj;
        boolean visited;

        public Station(int idx, int passenger) {
            this.idx = idx;
            this.passenger = passenger;
            this.adj = new ArrayList<>();
            this.visited = false;
        }
    }

    public static void main(String[] args) {
        int[] passenger = {1,1,1,1,1,1};
        int[][] train = {{1,2},{1,3},{1,4},{3,5},{3,6}};
        solution(6, passenger, train);
    }

    public static int[] solution(int n, int[] passenger, int[][] train) {

        //init
        stations = new Station[n + 1]; //index 1부터
        for(int i=1; i<=n; i++){
            stations[i] = new Station(i, passenger[i - 1]);
        }

        for(int i=0; i< train.length; i++){
            int n1 = train[i][0];
            int n2 = train[i][1];
            stations[n1].adj.add(stations[n2]);
            stations[n2].adj.add(stations[n1]);
        }

        int max_sum = 0;
        int max_station = 0;

        for(int i=1; i<=n; i++){
            int sum = sumOfPassenger(i);
            if(sum>=max_sum){
                max_sum = sum;
                max_station = i;
            }
        }

//        System.out.println("max_station="+max_station+", max_sum="+max_sum);
        int[] answer = {max_station, max_sum};
        return answer;
    }

    public static int sumOfPassenger(int end){
        total = 0;
        stations[1].visited = true;
        dfs(1, 0, end);
        return total;
    }

    public static void dfs(int cur_idx, int sum, int end){

        if(cur_idx==end){
            total = Math.max(total, sum + stations[cur_idx].passenger);
        }

        for(Station s: stations[cur_idx].adj){
            if(!s.visited) { // 방문하지 않은 노드일때만
                s.visited = true;
                dfs(s.idx, sum + stations[cur_idx].passenger, end);
                s.visited = false;
            }
        }
    }

}
