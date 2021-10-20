package programmers2;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_네트워크 {

    public static void main(String[] args) {
        int[][] comp = {
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };
        solution(3, comp);
    }

    static int[] group;
    public static int solution(int n, int[][] computers) {

        group = new int[n];
        int group_num = 1;

        for(int i=0; i<n; i++){

            if(group[i] == 0){
                bfs(i, group_num, computers, n);
                group_num++;
            }
        }

        return group_num-1;
    }

    public static void bfs(int start, int group_num, int[][] computers, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        group[start] = group_num;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0; i<n; i++){
                if(now == i) continue;
                if(computers[now][i] == 1 && group[i] == 0){
                    group[i] = group_num;
                    q.add(i);
                }
            }
        }
    }

}
