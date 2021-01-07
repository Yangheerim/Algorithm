
/*
* Bellman-Ford Algorithm
출력초과라 떠서 오류가 남.
해결 : int가 아닌 long을 써야함
이유 : 간선중에
a -> b 로 가는게 -10000 비용이 있고
b -> a 로 가는게 -10000 비용이 있다면
계속 음의 사이클이 발생하다가 int의 범위를 넘어서게 되서 음의 사이클이라고 판단을 못하게 된다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p11657 {
    static int INF = Integer.MAX_VALUE;
    static int V;
    static int E;
    static long[] d;
    static Bus[] buses;

    static class Bus{
        int start;
        int end;
        int distance;

        Bus(int start, int end, int distance){
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        d = new long[V+1];
        for(int i=1; i<=V; i++){
            d[i]=INF;
        }
        buses = new Bus[E];

        int start, end, weight; // edge info

        for(int i=0; i<E; i++){
            StringTokenizer edgeinfo = new StringTokenizer(br.readLine());
            start = Integer.parseInt(edgeinfo.nextToken());
            end = Integer.parseInt(edgeinfo.nextToken());
            weight = Integer.parseInt(edgeinfo.nextToken());
            buses[i] = new Bus(start, end, weight);
        }

        // 시작점 지정
        d[1] = 0;

        // Bellman-Ford
        boolean result = Bellman_Ford(); // is contain negative cycle
        if(result){
            for(int i=2; i<=V; i++){
                System.out.println(d[i] != INF ? d[i]:-1);
            }
        }else{
            System.out.println(-1);
        }
    }

    static boolean Bellman_Ford(){
        for(int i=1; i<=V-1; i++){
            for(int j=0; j<E; j++){
                Bus bus = buses[j];
                if(d[bus.start] != INF && d[bus.end]>d[bus.start]+bus.distance){
                    d[bus.end] = d[bus.start] + bus.distance;
                }
            }
        }
        for(int j=0; j<E; j++){
            Bus bus = buses[j];
            if(d[bus.start] != INF && d[bus.end]>d[bus.start]+bus.distance){
                return false;
            }
        }
        return true;
    }
}
