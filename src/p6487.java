import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;
/*
Line intersection - 직선의 교차 여부를 판단하는 문제.
기울기와 y절편을 사용해서
기울기가 같으면서+y절편이 같으면 같은 직선,
기울기가 같지만 y절편이 다른 경우 평행한 직선,
그 외에는 만나는 점을 프린트했으나,
x=3같은 직선은 기울기와 y절편을 구할 수 없어 예외처리하는 부분이 어려웠음.
x1-x2가 0일 경우, 변수 하나를 따로 지정하여 x=[?]에 해당하는 ?를 저장해두고, 최대 범위인 1001보다 작을 경우 예외처리 해줌.

1. if y축에 평행한건지 - 둘다 평행하면 둘이 같은 라인인지(Line) 다른 라인인지(None) / 하나만 y축 평행한 라인이면 교차점 찾아줌
2. 기울기 같은지 - 같다면 y절편 같은지(=Line) 아니면 None
3. 그외 교차점
 */
public class p6487 {
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int tk = 0 ; tk<n; tk++){
            Point[] p = new Point[4];
            st = new StringTokenizer(br.readLine());

            // input points
            for(int i=0; i<4; i++){
                p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            lineIntersection(p);
        }
        bw.flush();
    }
    static void lineIntersection(Point[] p) throws IOException {
        float line1_m = 0, line1_y=0, line2_m=0, line2_y=0;
        float line1_xis0 = 1001, line2_xis0 = 1001;

        // line1
        if(!(p[1].x == p[0].x)) {
            line1_m = (float) (p[1].y - p[0].y) / (float) (p[1].x - p[0].x);
            line1_y = p[0].y - line1_m * p[0].x;
        }else{
            line1_xis0 = p[0].x;
        }

        // line2
        if(!(p[3].x == p[2].x)) {
            line2_m = (float)(p[3].y - p[2].y) / (float)(p[3].x - p[2].x);
            line2_y = p[2].y - line2_m * p[2].x;
        }else{
            line2_xis0 = p[2].x;
        }

        if(line1_xis0 < 1001 && line2_xis0 < 1001){
            if(line1_xis0 == line2_xis0){
                bw.write("LINE\n");
            }else{
                bw.write("NONE\n");
            }
            return;
        }else if(line1_xis0 < 1001){
            float cross_point_y = line2_m* line1_xis0 + line2_y;
            bw.write("POINT "+String.format("%.2f", line1_xis0)+" "+String.format("%.2f", cross_point_y)+"\n");
            return;
        }else if(line2_xis0 < 1001){
            float cross_point_y = line1_m* line2_xis0 + line1_y;
            bw.write("POINT "+String.format("%.2f", line2_xis0)+" "+String.format("%.2f", cross_point_y)+"\n");
            return;
        }

        if(line1_m == line2_m){ // 두 직선의 기울기가 같으면
            if(line1_y == line2_y){ // 두 직선의 y절편도 같다면
                bw.write("LINE\n");
            }else{
                bw.write("NONE\n");
            }
        }else{
            float cross_point_x = (line2_y-line1_y) / (line1_m-line2_m);
            float cross_point_y = line1_m*cross_point_x + line1_y;
            bw.write("POINT "+String.format("%.2f", cross_point_x)+" "+String.format("%.2f", cross_point_y)+"\n");
        }

    }

}
