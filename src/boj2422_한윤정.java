package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 조합으로 3숫자를 뽑-> 시간초과,, 왜지,,,?
// https://naivep.tistory.com/81

public class boj2422_한윤정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        boolean[][] pairs = new boolean[n+1][n+1];
        for(int i=0; i<m; i++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            pairs[a][b] = true;
            pairs[b][a] = true;
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for(int j=i+1; j<=n; j++){
                if(pairs[i][j]) continue;
                for (int k = j + 1; k <= n; k++) {
                    if(!pairs[j][k] && !pairs[k][i]){
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
/*
    public static void perm(int cnt){ // idx 1부터 시작
        if(cnt==3){
            if(checkPossible()){
                result++;
            }
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                perm(cnt+1);
                visited[i] = false;
            }
        }

//        if(idx>n) return;
//
//        visited[idx] = true;
//        perm(idx+1, cnt+1);
//
//        visited[idx] = false;
//        perm(idx+1, cnt);

    }

    public static boolean checkPossible(){

        for(int i=0; i<m; i++){
            if(visited[pairs[i][0]] && visited[pairs[i][1]]){
                return false;
            }
        }
        return true;
    }
*/
}
