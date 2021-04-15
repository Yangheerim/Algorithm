public class programmers_키패드누르기 {
    static int[][] keypad;

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        solution(nums, "right");
    }


    public static String solution(int[] numbers, String hand) {
        String answer = "";

        // 4by3 키패드 설정
        keypad = new int[4][3];
        int num = 1;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                keypad[i][j] = num++;
            }
        }
        keypad[3][0] = -1; //*
        keypad[3][1] = 0;
        keypad[3][2] = -2; //#


        // 현재 왼손 위치
        // 현재 오른손 위치
        int lh = -1;
        int rh = -2;

        // 왼손잡이/오른손잡이 여부 : hand

        for (int n : numbers) {
            if(n==1 || n==4 || n==7) {
                answer += "L";
                lh = n;
            }else if(n==3 || n==6 || n==9) {
                answer += "R";
                rh = n;
            }else{
                int diff = distance(lh, n)-distance(rh, n);
                if(diff<0 || (diff==0 && hand.equals("left"))){
                    answer += "L";
                    lh = n;
                }else if(diff>0 || (diff==0 && hand.equals("right"))){
                    answer += "R";
                    rh = n;
                }
            }

        }
        System.out.println(answer);
        return answer;
    }

    public static int distance(int hand, int n){
        int hand_i = 0, hand_j=0, ni=0, nj=0;

        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                if(keypad[i][j]==hand){
                    hand_i = i;
                    hand_j = j;
                }
                if(keypad[i][j]==n){
                    ni = i;
                    nj = j;
                }
            }
        }

        return Math.abs(hand_i - ni) + Math.abs(hand_j - nj);

    }

}
