import java.util.Arrays;
/*
루트라는건 parent의 parent의 parent ...
 */
public class programmers_섬연결하기 {
    public static void main(String[] args) {
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        solution(4, costs);

    }
    static int[] parent;
    public static int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        int cnt = 0;
        int answer = 0;
        for(int i=0; i<costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){ // cycle 아니면
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
                cnt++;
            }
            if(cnt==n-1) break;
        }
        System.out.println(answer);
        return answer;
    }

    public static int find(int a){
        if(a==parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static void union(int a, int b){
        int root_a = find(a);
        parent[root_a] = b;
    }

}
