import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
98%쯤에 '틀렸습니다'가 떴었는데, static int MAX = 100001로 초기화한 게 문제.
하나의 거리에 최대 10만의 값이 나올 수 있기 때문에,
두 도시가 여태까지 한 번도 연결되지 않았음을 표현하기 위해서는
10만 x N(최대 100)인 1000만 초과로 해주는 게 좋다.
 */
public class p11404 {
    static int INF = 10000001;
    static int V;
    static int E;
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        D = new int[V+1][V+1];
        // initialize
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++) {
                if(i==j){
                    D[i][j] =0;
                    continue;
                }
                D[i][j] = INF;
            }
        }

        int start, end, weight; // edge info

        for(int i=0; i<E; i++){
            StringTokenizer edgeinfo = new StringTokenizer(br.readLine());
            start = Integer.parseInt(edgeinfo.nextToken());
            end = Integer.parseInt(edgeinfo.nextToken());
            weight = Integer.parseInt(edgeinfo.nextToken());
            D[start][end] = Math.min(D[start][end], weight);
        }
//        PrintResult();
//        System.out.println("-------------------");
        Floyd_Warshall();
        PrintResult();
    }
    static void Floyd_Warshall(){
        for(int k=1; k<=V; k++){
            for(int i=1; i<=V; i++){
                for(int j=1; j<=V; j++){
                    if(D[i][j]>D[i][k]+D[k][j]){
                        D[i][j]=D[i][k]+D[k][j];
                    }
                }
            }
        }
    }
    static void PrintResult() {
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                System.out.print((D[i][j] != INF ? D[i][j] : 0 )+ " ");
            }
            System.out.println();
        }
    }

}
