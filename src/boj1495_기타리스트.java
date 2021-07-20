package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// https://lotuslee.tistory.com/131
public class boj1495_기타리스트 {
    public static void main(String[] args) throws IOException {
        // N개의 곡 연주

        // 볼륨리스트 V -> V[i]는 i번째 곡을 연주하기 전에 바꿀 수 있는 볼륨
        // 항상 리스트에 적힌 차이로만 볼륨을 바꿀 수 있음
        // 즉, 현재 볼륨이 P이고 i번째 곡을 연주하기 전이라면, i번 곡은 P+V[i] 이거나 P-V[i]
        // 하지만 볼륨의 범위는 0<=P<=M
        // --> 마지막 곡을 연주할 수 있는 볼륨 중 '최댓값'은?
        //     조절이 불가하면 (범위가 안되면) -1

        // N, S, M

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        int M = Integer.parseInt(inputs[2]);

        int[] diff = new int[N+1];
        inputs = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            diff[i] = Integer.parseInt(inputs[i-1]);
        }

        // 맨 마지막의 최댓값을 구해야함 == 각각의 노래가 최댓값이 되어야함,,,? X

        // S=5
        // V : 5 3 7

        // 각 볼륨의 가짓수는 2개 아니그러면 dfs아냐.,,? --> 2^100승 이니까,,, 안될듯,,,

        // volume[v] = i : i번째 연주에서 볼륨 v으로 연주할 수 있다! = 볼륨 v로 연주할 수 있는 곡 번호
        // 최종적으로 volume[x] = n 인 x중에서 가장 큰 값이 결과값이 된다!

        int[] volume = new int[M + 1];
        for(int i=0; i<=M; i++){ // initialize : 0은 S의 초기값이기 때문에 -1로 초기화 시킨 후 진행
            volume[i] = -1;
        }
        volume[S] = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++){ // 연주 idx
            list.clear();
            for(int j=0; j<=M; j++) { // 볼륨 idx
                if(volume[j] == i-1) { // 이전 연주(i-1)가 j 볼륨으로 연주가 가능했으면
                    if (0 <= j - diff[i] && j - diff[i] <= M) { // 0~M 범위에 속한다면
                        list.add(j - diff[i]);
                    }
                    if (0 <= j + diff[i] && j + diff[i] <= M) {
                        list.add(j + diff[i]);
                    }
                }
            }
            for (int v : list) {
                volume[v] = i;
            }
        }

        for(int i=M; i>=0; i--){
            if(volume[i] == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);

        // 이중배열로 푸는 방법도 해보기

    }
}
