import java.sql.DriverManager;
import java.util.Scanner;

/*
baekjoon-1978

N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.

INPUT : 첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
OUTPUT : 첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.

if N=3
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1

if N=4
1 2 3 4
1 2 4 3
1 3 2 4
1 3 4 2
1 4 2 3
1 4 3 2
...

Fail... 사전순대로 안나옴 이해 필요
*/

class permutation {

    public static void main(String[] args) {

        int N;
        Scanner sc = new Scanner(System.in);

//        System.out.print("N: ");
        N = sc.nextInt();

        if (N<1 || N>8){
            return ;
        }

//        System.out.print(N);
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=i+1;
        }
        perm(arr, 0, N-1);
    }

    static void perm(int[] arr, int start, int end) {
        System.out.println("perm(["+arr[0]+", "+arr[1]+", "+arr[2]+"], "+start+", "+end+")");
        if (start == end) {
            print(arr);
        }else {
            for (int i = start; i <= end; ++i) {
                int tmp = arr[start];
                arr[start] = arr[i];
                arr[i] = tmp;

                perm(arr, start + 1, end);

                tmp = arr[start];
                arr[start] = arr[i];
                arr[i] = tmp;
            }
        }
    }


    public static void print(int[] arr){
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

}
