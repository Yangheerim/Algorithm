import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
/*
문제의 취지 자체는 rotating calipers 알고리즘을 사용하여 가장 먼 거리를 구하는 것이나,
convexhull을 구한 후 convexhull을 이루는 점을 각각 비교하여 O(n^2)의 시간복잡도라도 풀 수 있는 문제
Comparator를 이전과 동일하게 작성했음에도 불구하고 런타임에러(IlligalArgument)가 발생해서
삽질을 해본 결과, comparator의 return이 1, 0, -1 세가지를 다 정의해주지 않았을 때 나는 에러인 것 같다.
 */
public class p9240 {
    static class Point{
        long x;
        long y;
        Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static ArrayList<Point> points;
    static Point first = new Point(1001, 1001);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        points = new ArrayList<Point>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }
        // 기준점 찾기 - points[min_idx]
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).y < first.y) {
                first = points.get(i);
            } else if (points.get(i).y == first.y) {// y좌표가 동일한 경우 x좌표 비교
                if (points.get(i).x < first.x) {
                    first = points.get(i);
                }
            }
        }

        // 기준점 기준으로 반시계방향으로 정렬, 세 점이 일직선상에 있다면 거리가 증가하도록 정렬
        // 1: 바꿔라, -1 : 안바꿔도된다
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                long c = ccw(first, p1, p2);

                if (c > 0) {
                    return -1;
                }else if (c < 0) {
                    return 1;
                }else if (c == 0) {
                    long a = dist(first, p1);
                    long b = dist(first, p2);

                    if (a < b) return -1;
                    else if (a > b) return 1;
                    else if (a == b) return 0;
                }

                return 0;
            }
        });
        convexHall();
    }

    static void convexHall(){
        // Graham scan
        Stack<Point> stack = new Stack<Point>();
        stack.add(first);
        for(int i=1; i<n; i++){
            while (stack.size() > 1 && ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), points.get(i))<=0) {
                stack.pop();
            }
            stack.add(points.get(i));
        }
        //print result
//        System.out.println(stack.size());
        printFarthest(stack);
    }
    static void printFarthest(Stack<Point> stack){
        long max_dist = -1;
        for(int i=0; i<stack.size(); i++){
            for(int j=0; j<stack.size(); j++) {
                if(i==j) continue;
                long dist = dist(stack.get(i), stack.get(j));
                if(dist>max_dist){
                    max_dist = dist;
                }
            }
        }
        System.out.println(Math.sqrt(max_dist));
    }

    static long ccw(Point p1, Point p2, Point p3){
        return ((p1.x*p2.y) + (p2.x*p3.y) + (p3.x * p1.y)) - ((p1.y*p2.x) + (p2.y*p3.x) + (p3.y*p1.x));
        // 양수 - ccs / 음수 - cw / 0 - 직선
    }
    static long dist(Point a, Point b) {
        return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
    }
}
