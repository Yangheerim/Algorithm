import java.util.ArrayList;
import java.util.Scanner;

public class Panda {
    public static int max =1, n, map[][], dp[][];
    public static int dx[] = {0,0,-1,1}, dy[] = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 테스트 케이스 개수
        String line[];

        //map 생성 (input)
        for(int i=0;i<n;i++){
            line = sc.nextLine().split(" ");
            for(int j=0;j<n;j++)
                map[i][j] = Integer.parseInt(line[j]);
        }

        /* 2중 for문을 이용한 모든 좌표에서의 최대 생존일수 탐색 */
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                /* 단, d[i][j]==0일때(=한번도 안들렀을때)만
                 * 해당 지점에서의 최초 탐색 진행 */
                if(dp[i][j]==0){
                    dp[i][j]=1;
                    mov(i, j);
                }
            }
        }
    }

    private static void mov(int x, int y){
        int i, ax, ay;
        for(i=0;i<4;i++){
            ax = x + dx[i]; ay = y + dy[i];
            if(isInRange(ax, ay) && shouldMov(x, y, ax, ay)){
                dp[ax][ay] = dp[x][y] + 1;
                if(dp[ax][ay]>max)
                    max = dp[ax][ay];
                mov(ax, ay);
            }
        }
    }

    //이동할 조건을 판별할 메서드(핵심!)
    private static boolean shouldMov(int x, int y, int ax, int ay){
        return (map[x][y]<map[ax][ay]) && (dp[x][y]+1>dp[ax][ay]);
    }

    //배열 index를 벗어나지 않기 위해 체크하는 메서드
    private static boolean isInRange(int x, int y){
        return (0<=x&&x<n)&&(0<=y&&y<n);
    }

}


