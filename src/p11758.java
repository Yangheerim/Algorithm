import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Point[] points = new Point[3];
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(ccw(points));
    }
    static int ccw(Point[] p){
        int result = ((p[0].x*p[1].y) + (p[1].x*p[2].y) + (p[2].x * p[0].y)) - ((p[0].y*p[1].x) + (p[1].y*p[2].x) + (p[2].y*p[0].x));
        if(result < 0)
            return -1;
        else if(result > 0)
            return 1;
        else
            return 0;
    }
}
