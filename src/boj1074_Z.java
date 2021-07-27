package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1074_Z {
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        r = Integer.parseInt(inputs[1]);
        c = Integer.parseInt(inputs[2]);

        int pow_n = (int) Math.pow(2, N);


        recursive(0,0, pow_n, 0);

//        System.out.println(map[r][c]);
    }

    public static void recursive(int si, int sj, int length, int cnt){ // i, j는 시작점
        if(length==2){
            //System.out.println("ei="+ei+", ej="+ej);
            for (int i = si; i <= si+1; i++) {
                for (int j = sj; j <= sj+1; j++) {
                    //System.out.println("i="+i+", j="+j+", cnt="+cnt);
                    if(i==r && j==c){
                        System.out.println(cnt);
                        return;
                    }
                    cnt++;
                }
            }
            return;
        }

        int half = length/2;

        // si, sj, half, cnt
        // si, sj+half, half, half*half*2
        // si+half, sj, half, half*half
        // si+half, sj+half, half, half*half*3

        if(si<=r && r<si+half && sj<=c && c<sj+half){
            recursive(si, sj, half, cnt);
        }else if(si<=r && r<si+half && sj+half<=c && c<sj+length){
            recursive(si, sj+half, half, cnt+half*half);
        }else if(si+half<=r && r<si+length && sj<=c && c<sj+half){
            recursive(si+half, sj, half, cnt+half*half*2);
        }else{
            recursive(si+half, sj+half, half, cnt+half*half*3);
        }
    }
}
