import java.util.Scanner;

public class p2447 {

    static char arr[][];
    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr= new char[n][n];

//        for(int i =0; i<n; i++){
//            for (int j=0; j<n; j++){
//                arr[i][j] = '*';
//            }
//        }
        star(0, 0, n, false);
        printArr();
    }

    static void star(int x, int y, int n, boolean blank){
        // 공백칸일 경우
        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // 더이상 쪼갤 수 없는 블록일 때
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = n/3;
        int count = 0;
        for (int i=x; i<x+n; i+=size){
            for (int j=y; j<y+n; j+=size){
                count ++;
                if(count==5){
                    star(i, j, size, true);
                }else{
                    star(i, j, size, false);
                }
            }
        }


    }

    static void printArr(){
//        for(int i =0; i<n; i++){
//            for (int j=0; j<n; j++){
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
