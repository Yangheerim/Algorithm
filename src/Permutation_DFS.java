/*
baekjoon-10974 (sil3)

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

Success!
*/


import java.util.Scanner;

public class Permutation_DFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int N = sc.nextInt();

        int[] arr = new int[N + 1];
        int[] out = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i=0; i<=N; i++){
            arr[i]=i;
        }

        perm(arr, out, visited, 1, N);
    }

    public static void perm(int[] arr, int[] out, boolean[] visited, int depth, int n) {
        if (depth == n + 1) {
            for(int i =1; i<=n; i++){
                System.out.print(out[i]+" ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                perm(arr, out, visited, depth+1, n);
                visited[i]=false;
            }
        }
    }
}
