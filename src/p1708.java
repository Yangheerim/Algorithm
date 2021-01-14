import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
/*
ConvexHall - Graham scan
1. 기준점 찾기 (y좌표가 제일 작은 값, y가 같을 경우 x좌표가 더 작은 값)
2. 기준점을 기준으로 반시계 방향으로 정렬 (Comparator 정의하여 소팅, 1이면 바꿔라, -1이면 안바꿔라)
3. stack을 사용해 graham scan, ccw이면 그냥 두고 cw이면 pop한다
 */
public class p1708 {
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
    static Point first = new Point(40001, 40001);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        points = new ArrayList<Point>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
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
                long v = ccw(first, p1, p2);
                if(v > 0)
                    return -1;
                else if(v < 0)
                    return 1;
                else if (dist(first, p1) > dist(first, p2))
                    return 1;
                return -1;
            }
        });
        convexHall();
    }

    static void convexHall(){
        // Graham scan
        Stack<Point> stack = new Stack<Point>();
        stack.add(first);
//        System.out.println("stack size = "+stack.size());
        for(int i=1; i<n; i++){
            while (stack.size() > 1 && ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), points.get(i))<=0) {
                stack.pop();
            }
            stack.add(points.get(i));
//            System.out.println("stack size = "+stack.size());
        }
        //print result
        System.out.println(stack.size());
    }

    static long ccw(Point p1, Point p2, Point p3){
        return ((p1.x*p2.y) + (p2.x*p3.y) + (p3.x * p1.y)) - ((p1.y*p2.x) + (p2.y*p3.x) + (p3.y*p1.x));
        // 양수 - ccs / 음수 - cw / 0 - 직선
    }
    static long dist(Point a, Point b) {
        return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
    }
}
