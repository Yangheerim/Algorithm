package programmers;

public class programmers_비밀지도 {

    public static void main(String[] args) {
        int[] n1 = {9, 20, 28, 18, 11};
        int[] n2 = {30, 1, 21, 17, 28};

        solution(5, n1, n2);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]=' ';
            }
        }

        for (int i = 0; i < n; i++) {
            String bin1 = Integer.toBinaryString(arr1[i]);
            String bin2 = Integer.toBinaryString(arr2[i]);

            int idx = n-1;
            for (int j = bin1.length() - 1; j >= 0; j--) {
                if(bin1.charAt(j)=='1'){
                    map[i][idx] = '#';
                }
                idx--;
            }

            idx = n-1;
            for (int j = bin2.length() - 1; j >= 0; j--) {
                if(bin2.charAt(j)=='1'){
                    map[i][idx] = '#';
                }
                idx--;
            }

            String str = "";
            for (int j = 0; j < n; j++) {
                str += map[i][j];
            }

            answer[i] = str;
        }

        return answer;
    }


}
