package programmers;

// https://velog.io/@delay/programmers68645
public class programmers_삼각달팽이 {
    public int[] solution(int n) {


        int max = getMax(n);

        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                arr[i][j] = -1;
            }
        }

        int i=0, j=0, num=1;
        arr[0][0] = num;

        while(num<max){
            while(i+1<n && num<max && arr[i+1][j]<0){
                arr[++i][j] = ++num;
            }
            while(j+1<n && num<max && arr[i][j+1]<0){
                arr[i][++j] = ++num;
            }
            while(i-1>0 && j-1>0 && num<max && arr[i-1][j-1]<0){
                arr[--i][--j] = ++num;
            }
        }

        num = 0;
        int[] answer = new int[max];

        for(i=0; i<n; i++){
            for(j=0; j<=i; j++){
                answer[num++] = arr[i][j];
            }
        }


        return answer;
    }

    public static int getMax(int n){
        int res = 0;
        for(int i=1; i<=n; i++){
            res += i;
        }
        return res;
    }
}


/*

1
2 9
3 10 8
4 5  6 7

row는 +2씩
col은 +1씩

 */