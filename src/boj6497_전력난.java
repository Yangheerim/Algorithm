package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 가로등 중 일부를 소등하기로 함
// 하루에 길의 미터 수만큼 돈이 들어감
// 근데 불 안켜진 길은 위험해서 불 켜진길로만 왕래할 수 있음
// 절약할 수 있는 최대 액수?

// x y z : x--y 사이에 양방향 도로가 있으며, 거리는 z
// 도시는 항상 연결 그래프

// MST?
// 전체 길이 수 - MST 연결하는 edge의 길이 = 절약할 수 있는 최대 비용
// 크루스칼!
// 1. 간선 오름차순
// 2. 사이클인지 확인 후 union! (union-find)

public class boj6497_전력난 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            String[] inputs = br.readLine().split(" ");

            int m = Integer.parseInt(inputs[0]); // 집의 수
            int n = Integer.parseInt(inputs[1]); // 길의 수

            if(m==0 && n==0) {
                return;
            }

            int[][] edges = new int[n][3];

            int total_cost = 0;
            for (int i = 0; i < n; i++) {
                inputs = br.readLine().split(" ");

                int x = Integer.parseInt(inputs[0]);
                int y = Integer.parseInt(inputs[1]);
                int z = Integer.parseInt(inputs[2]);

                edges[i][0] = x;
                edges[i][1] = y;
                edges[i][2] = z;

                total_cost += edges[i][2];

            }

            Arrays.sort(edges, (a, b) -> a[2] - b[2]); // 간선을 기준으로 오름차순으로 정렬

            parent = new int[m + 1];
            for (int i = 1; i <= m; i++) {
                parent[i] = i;
            }

            int min_cost = 0;
            int selected_cnt = 0;
            int i = 0;
            while (true) {
                if (find(edges[i][0]) != find(edges[i][1])) { // cycle이 아니면
                    union(edges[i][0], edges[i][1]);
                    min_cost += edges[i][2];
                    selected_cnt++;
                }
                if (selected_cnt == m - 1) {
                    break;
                }
                i++;
            }
            System.out.println(total_cost - min_cost);
        }

    }

    public static int find(int idx) {
        if(parent[idx]==idx){
            return idx;
        }
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    public static void union(int a, int b) {
        int parent_of_a = find(a);
        parent[parent_of_a] = b; // 주의,,, a의 parent를 b로 바꿔야 a가 b랑 합쳐지는 것!
    }
}

