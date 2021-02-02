import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
팀을 어떻게 나눌 것인가를 잘 생각해 봐야했던 문제.
dfs와 visited 배열을 만들어 count가 n/2이 되었을 경우 (= 팀이 두개로 나뉘었을 경우)
각 팀의 능력치의 차를 구한다. 제일 작은값을 계속 확인해서 갱신해주면 됨.
dfs는 현재 idx를 true로 변경한 뒤 (팀1에 포함시킨 뒤) 다음 index를 보면서 true의 count가 n/2이 될 때까지 반복한다.
 */
public class p14889 {
    static int[][] s;
    static boolean[] visited;
    static int n;
    static int min = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        s = new int[n + 1][n + 1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divTeam(1, 0);

        System.out.println(min);

    }

    public static void divTeam(int idx, int count){
        if(count == n/2){
            calAbility();
            return;
        }
        for(int i=idx; i<=n; i++){
            visited[i] = true;
            divTeam(i+1, count+1);
            visited[i] = false;
        }
    }

    public static void calAbility(){
        int a1 = 0;
        int a2 = 0;

        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){
                if(i==j) continue;
                if(visited[i]==visited[j]){
                    if(visited[i]){
                        a1 += s[i][j] + s[j][i];
                    }else{
                        a2 += s[i][j] + s[j][i];
                    }
                }
            }
        }
//        System.out.println("a1="+a1+", a2="+a2);
        int diff = Math.abs((a1-a2));
//        System.out.println("diff="+diff);
        if(min == -1 || diff<min){
            min = diff;
        }
    }

}
