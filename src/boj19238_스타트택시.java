import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

// 각 승객마다 BFS를 수행하는게 아닌, 그냥 한번만하면 distance를 다 구할 수 있다!

public class boj19238_스타트택시 {

    static class Loc{
        int i;
        int j;
        public Loc(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static class Guest{
        Loc now;
        Loc destination;
        boolean completed;

        public Guest(Loc now, Loc destination) {
            this.now = now;
            this.destination = destination;
            completed = false;
        }
    }

    static ArrayList<Guest> guests;
    static int[][] map;
    static Loc car;
    static int n;

    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        car = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        guests = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            Loc now = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Loc dest = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            guests.add(new Guest(now, dest));
        }

        for(int i=0; i<m; i++){
            System.out.println(i+"-------------------------");
            System.out.println("f="+fuel);
            findDistance(car);
            printDis();
            Guest g = getNextGuest();
            if(g == null){
                System.out.println(-1);
                return;
            }
            if(distance[g.now.i][g.now.j] == -10){
                distance[g.now.i][g.now.j] = 0;
            }
            fuel -= distance[g.now.i][g.now.j];
            System.out.println("태우러감 : "+distance[g.now.i][g.now.j]+", f="+fuel);
            if(fuel<0){
                System.out.println(-1);
                return;
            }
            findDistance(g.now);
            printDis();
            int driving = distance[g.destination.i][g.destination.j];
            if(driving==0){
                System.out.println(-1);
                return;
            }
            fuel -= driving;
            System.out.println("태워다줌 : "+distance[g.destination.i][g.destination.j]+", f="+fuel);
            if(fuel<0){
                System.out.println(-1);
                return;
            }

            fuel += driving*2;
            car = g.destination;
        }

        System.out.println(fuel);
    }
    public static void printDis(){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("==================");
    }

    public static Guest getNextGuest(){ // 가장 최단거리에 있는 손님 리턴

        Guest min_guest = null;

        for(Guest g: guests){
            if(!g.completed){
                int dis = distance[g.now.i][g.now.j];
                if(dis==0) continue;
                if(min_guest == null || distance[min_guest.now.i][min_guest.now.j]>dis){
                    min_guest = g;
                }else if(distance[min_guest.now.i][min_guest.now.j] == dis){
                    if(min_guest.now.i > g.now.i){
                        min_guest = g;
                    }else if(min_guest.now.i == g.now.i){
                        if(min_guest.now.j > g.now.j){
                            min_guest = g;
                        }
                    }
                }
            }
        }
        if(min_guest != null){
            min_guest.completed = true;
        }
        return min_guest;
    }

    public static void findDistance(Loc start){

        //bfs
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(start.i, start.j));

        int[] mi = {0, 0, 1, -1};
        int[] mj = {1, -1, 0, 0};

        boolean[][] visited = new boolean[n + 1][n + 1];
        distance = new int[n + 1][n + 1];


        while(!queue.isEmpty()){
            Loc tmp = queue.poll();

            for(int d=0; d<4; d++){
                int ni = tmp.i + mi[d];
                int nj = tmp.j + mj[d];

                if(ni<1 || nj<1 || ni>n || nj>n) continue;

                if(map[ni][nj]==1){
                    distance[ni][nj] = -1; //벽
                    continue;
                }
                if(!visited[ni][nj]){
                    visited[ni][nj] = true;
                    distance[ni][nj] = distance[tmp.i][tmp.j] + 1;
                    queue.add(new Loc(ni, nj));
                }
            }
        }

        distance[start.i][start.j] = -10; //start
    }

}
