import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Stack;
/*
Convex Hull - Monotone chain algorithm
upper과 lower를 따로 구해서 각각 마지막꺼 빼고 합쳐주면 된다.
근데 왜 이렇게 되는건지 이해 못하겠음
 */
public class p4181 {
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
    static Point first;
//    static Point end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        points = new ArrayList<Point>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            String contain = st.nextToken();
            // convex hall에 포함 되어있을 때만
            if (contain.equals("Y"))
                points.add(new Point(x,y));
        }

        // 기준점 찾기1 - x좌표가 가장 작은 점, 같을 경우 y좌표가 작은 점
        first = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).x < first.x) {
                first = points.get(i);
            } else if (points.get(i).x == first.x) {// x좌표가 동일한 경우 y좌표 비교
                if (points.get(i).y < first.y) {
                    first = points.get(i);
                }
            }
        }

        // 기준점 찾기2 - x좌표가 가장 큰 점, 같을 경우 y좌표가 큰 점
//        end = points.get(0);
//        for (int i = 1; i < points.size(); i++) {
//            if (points.get(i).x > end.x) {
//                end = points.get(i);
//            } else if (points.get(i).x == end.x) {// x좌표가 동일한 경우 y좌표 비교
//                if (points.get(i).y > end.y) {
//                    end = points.get(i);
//                }
//            }
//        }

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

        monotoneChain();
    }
    static void monotoneChain(){

        Stack<Point> lower = new Stack<>();
        for (int i=0; i<points.size(); i++){
            while (lower.size()>=2 && ccw(lower.get(lower.size() - 2), lower.get(lower.size() - 1), points.get(i))<0){
                lower.pop();
            }
            lower.add(points.get(i));
        }


        Stack<Point> upper = new Stack<>();
//        Collections.reverse(points);
        for (int i=points.size()-1; i>=0; i--){
            while (upper.size()>=2 && ccw(upper.get(upper.size() - 2), upper.get(upper.size() - 1), points.get(i))<0){
                upper.pop();
            }
            upper.add(points.get(i));
        }
        System.out.println(points.size());
        for(int i=0; i<lower.size()-1; i++){
            System.out.println(lower.get(i).x+" "+lower.get(i).y);
        }
        for(int i=0; i<upper.size()-1; i++){
            System.out.println(upper.get(i).x+" "+upper.get(i).y);
        }

    }

    static long ccw(Point p1, Point p2, Point p3){
        return ((p1.x*p2.y) + (p2.x*p3.y) + (p3.x * p1.y)) - ((p1.y*p2.x) + (p2.y*p3.x) + (p3.y*p1.x));
        // 양수 - ccs / 음수 - cw / 0 - 직선
    }
    static long dist(Point a, Point b) {
        return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
    }
}
