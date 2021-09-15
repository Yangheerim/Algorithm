package programmers;

public class programmers_예상대진표 {
    public static void main(String[] args) {
        solution(8, 4, 7);

    }

    public static int solution(int n, int a, int b)
    {

        // 1, 2 -> 1
        // 3, 4 -> 2
        // 5, 6 -> 3
        // +1 /2 하면 될듯?


        // 4 7
        // 2 4
        // 1 2

        // 1 2 3 4 중에 a가 2, b가 3이 되면 b-a가 1이지만 틀린 것!
        // 그러면..
        // 1 2 3 4 5 6 7 8
        // 3   7   11  15       4씩증가?

        int round = 1;
        while(true){

//            if(Math.abs(a-b)==1){  // 이 경우, 1 2 3 4 중에 a가 2, b가 3이 되면 b-a가 1이지만 틀린 것!
//                break;
//            }

//            if (isMatch(a, b, (int) (n / Math.pow(2,round-1)))) {
//                break;
//            }

            // 이겼을 때 올라가는 라운드가 같은 라운드면~
            if ((a + 1) / 2 == (b + 1) / 2) {
                break;
            }

            a = (a + 1) / 2;
            b = (b + 1) / 2;

            round ++;
        }

        System.out.println(round);
        return round;
    }

//    public static boolean isMatch(int a, int b, int n){
//
//        int sum = 3;
//        while(sum <= n+(n-1)){
//            if (Math.abs(a-b) == 1 && a + b == sum) {
//                return true;
//            }
//            sum += 4;
//        }
//        return false;
//    }


}
