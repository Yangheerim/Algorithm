import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
/*
Line sweeping.
처음에는 가능한 경우의 수를 전부 if-else문으로 나누어 해봤는데,
현재 직선과는 얼마든지 가능하나, 다음 직선과 비교하지 못하는 상황이 생겨 오류가 있었다.

line sweeping의 정석대로, x를 기준으로 정렬 후(x가 같을 시 y가 작은 순)
1. 이전 선분과 완전히 겹치는 경우 - 이미 포함되어있으므로 무시
2. 이전 선분과 일부 겹치는 경우 - 겹치는 부분만큼을 뺀 뒤, 현재 선분 길이만큼 sum에 더해줌
3. 이전 선분과 아예 겹치지 않는 경우 - 현재 선분의 길이를 sum에 더해줌
위와 같은 3가지로 나누어 조건문을 걸어줬다.

 */
public class p2170 {
    static class Line{
        long x, y;
        public Line(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Line> lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        lines = new ArrayList<>();
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            lines.add(new Line(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken())));
        }

        // x에 대한 오름차순으로 정렬, x가 같을 경우 y가 작은게 우선
        lines.sort(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                if (o1.x > o2.x) {
                    return 1;
                } else if (o1.x == o2.x) {
                    if (o1.y > o2.y) {
                        return 1;
                    }
                }
                return -1;
            }
        });
        lineSweeping();
    }

    static void lineSweeping(){
        Line line0 = lines.get(0);
        long s = line0.x;
        long e = line0.y;
        long sum = e-s;
        for(int i=1; i<lines.size(); i++){
            Line line = lines.get(i);

            if(s<=line.x && e>=line.y){ //1. 이전 선분에 완전히 포함되는 경우
                continue; // 더 작은 선분(=포함되는 선분) 무시!
            }else if(line.x<e){ //2. 이전 선분과 일부 겹치는 경우
                sum += -(e - line.x) + (line.y - line.x); // 겹치는 부분 빼고, 현재 선분 더하기
            }else if(e<line.x){//3. 이전 선분과 아예 겹치지 않는 경우
                sum += (line.y - line.x);
            }

            s = line.x;
            e = line.y;
        }
        System.out.println(sum);
    }

//    // 겹치는 선분이 이미 있는지 확인 -- 이렇게하면 두 선분이 둘다 겹치는 경우를 계산할 수 없음,,, (삽질완료)
//    static boolean isOverlapping(long a, long b){
//        for(int i=0; i<lines.size(); i++){
//            Line line = lines.get(i);
//            if(a<line.x && (line.x<=b && b<=line.y)){
//                line.x=a;
//                lines.set(i, line);
//                return true;
//            }else if((line.x<=a && a<=line.y) && line.y<b) {
//                line.y = b;
//                lines.set(i, line);
//                return true;
//            }else if(a<line.x && b>line.y){
//                line.x=a;
//                line.y=b;
//                lines.set(i, line);
//                return true;
//            }else if(a>=line.x && b<=line.y){
//                return true;
//            }
//        }
//        return false;
//    }

//    static void printResult(){
//        long result = 0;
//        for(int i=0; i<lines.size(); i++) {
//            Line line = lines.get(i);
//            result += line.y - line.x;
//        }
//        System.out.println(result);
//    }

//    static void printLineInfo(){ // 테스트용
//        for(int i=0; i<lines.size(); i++) {
//            Line line = lines.get(i);
//            System.out.println("test/("+i+") "+line.x+" "+line.y);
//        }
//    }

}
