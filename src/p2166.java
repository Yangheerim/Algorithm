import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Point를 int로 했더니 에러났음,, long으로 바꾸니까 잘 됌! 왜지?
면적은 최대 100000*100000 이 int 최댓값 넘어가서 그런거니까 long ㅇㅋ
int로 곱하고 빼는 연산이 long로 안바뀌나..? 음,,
 */

public class p2166 {
    static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        long result = 0L;
        for(int i=1; i<n-1; i++){
            result += ccw(points[0], points[i], points[i + 1]);
        }

        // 8/2 = 4, 17/2=8.5, 14/2=7 이런식이니까~ 뒷자리는 0 아니면 5!
        result = Math.abs(result);
        if(result%2==0) {
            System.out.println((result/2)+".0");
        }else {
            System.out.println((result/2)+".5");
        }

    }
    static long ccw(Point p1, Point p2, Point p3){
        return ((p1.x*p2.y) + (p2.x*p3.y) + (p3.x * p1.y)) - ((p1.y*p2.x) + (p2.y*p3.x) + (p3.y*p1.x));
        // 양수 - ccs / 음수 - cw / 0 - 직선
    }
}
