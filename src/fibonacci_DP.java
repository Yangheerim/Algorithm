public class fibonacci_DP {

    static int[] arr = new int[100];

    public static void main(String[] args) {
        System.out.println(Fibonacci(11));

        for(int i=0; i<arr.length; i++){
            arr[i]=0;
        }
    }

    public static int Fibonacci(int x) {

        if (x == 1) return 1;
        if (x == 2) return 1;

        if (arr[x] != 0) return arr[x];

        return arr[x] = Fibonacci(x - 1) + Fibonacci(x - 2);

    }
}
