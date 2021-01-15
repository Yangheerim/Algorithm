import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

/*
Convex Hull - Monotone chain algorithm
upper과 lower를 따로 구해서 각각 마지막꺼 빼고 합쳐주면 된다.
로직은 맞는 것 같은데 틀렸습니다가 뜸.
 */
public class p4181_error {
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

        // x축 기준으로 정렬
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                long v = p1.x - p2.x;
                if(v < 0)
                    return -1;
                else if(v > 0)
                    return 1;
                else
                    return 0;
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
        // test
//        System.out.println(lower.size());
//        for(int i=0; i<lower.size(); i++){
//            System.out.println(lower.get(i).x+" "+lower.get(i).y);
//        }
//        System.out.println(upper.size());
//        for(int i=0; i<upper.size(); i++){
//            System.out.println(upper.get(i).x+" "+upper.get(i).y);
//        }
    }

    static long ccw(Point p1, Point p2, Point p3){
        return ((p1.x*p2.y) + (p2.x*p3.y) + (p3.x * p1.y)) - ((p1.y*p2.x) + (p2.y*p3.x) + (p3.y*p1.x));
        // 양수 - ccs / 음수 - cw / 0 - 직선
    }
    static long dist(Point a, Point b) {
        return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
    }
}
