import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
/*
dfs할 때 현재 index +1 한 값을 넘겨줘야 한다...

 */
public class p15686 {
    static int[][] map;
    static int n;
    static int m;
    static ArrayList<Point> homes;
    static ArrayList<Point> chickens;
    static Stack<Point> selected_chicken;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        chickens = new ArrayList<>();
        homes = new ArrayList<>();
        selected_chicken = new Stack<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new Point(i, j));
                }else if (map[i][j] == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        select(0, 0);

        System.out.println(min);
    }

    // count가 m개가 되면 치킨거리 구해서 sum구한담에 min값 구함
    static void select(int idx, int count) {
        if (count == m) {
            calcDist();
            return;
        }
        for (int i = idx; i < chickens.size(); i++) {
            selected_chicken.push(chickens.get(i));
            select(i + 1, count + 1);
            selected_chicken.pop();
        }
    }


    public static void calcDist() {
        int sum = 0;
        for (Point home : homes) {
            int min_ = Integer.MAX_VALUE;
            for (Point chicken : selected_chicken) {
                int d = Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
                min_ = Math.min(d, min_);
            }
            sum += min_;
            if(sum>min) return;
        }
        min = Math.min(sum, min);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
