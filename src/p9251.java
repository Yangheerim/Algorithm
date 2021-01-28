import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
matrix를 만든 뒤에,
같은 문자이면 대각선 왼쪽위 +1값 저장
다른 문자이면 위/왼쪽 중 큰값 저장
맨 아래오른쪽에 저장된 수가 가장 큰 값! = 가장 긴 공통문자열의 길이
 */
public class p9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        int[][] matrix = new int[s1.length+1][s2.length+1]; // 0으로 초기화 되어있음
        for(int i=1; i<=s1.length; i++){
            for(int j=1; j<=s2.length; j++){
                if(s1[i-1] == s2[j-1]){
                    matrix[i][j] = matrix[i-1][j-1]+1;
                }else{
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        System.out.println(matrix[s1.length][s2.length]);

        // matrix test
//        for(int i=0; i<=s1.length; i++){
//            for(int j=0; j<=s2.length; j++){
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
    }


}
