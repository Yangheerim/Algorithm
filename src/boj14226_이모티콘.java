import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://daily-life-of-bsh.tistory.com/68
// https://iamheesoo.github.io/blog/algo-boj14226

// 3가지 경우가 되는지 확인, 되는거만 큐에 넣음
// visit 처리는 중복해서 하지 않기 위해
// 이미 visited 되었다면 더 적은 시간에 왔던 것이기 때문에 깔끔하게 패스
// 배열 범위를 2000까지 한거는 원래꺼(최대 1000)+붙혀넣기한거(최대 1000) 해서 최대 2000개까지 가능하니까
public class boj14226_이모티콘 {

    static class Step{
        int emoticon_num;
        int clipboard_num;
        int time;

        public Step(int emoticon_num, int clipboard_num, int time) {
            this.emoticon_num = emoticon_num;
            this.clipboard_num = clipboard_num;
            this.time = time;
        }
    }

    static boolean[][] visited;
    static int S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        visited = new boolean[2001][2001]; // 행: 이모티콘의 개수, 열:클립보드 이모티콘 개수
        // s의 최댓값이 1000이고 이를 복사에서 클립보드에 저장할 때 최대가 되므로 visit[2002][2002]로 초기화

        bfs();
    }

    public static void bfs() {
        Queue<Step> queue = new LinkedList<>();
        queue.add(new Step(1, 0, 0));

        while (!queue.isEmpty()) {
            Step now = queue.poll();

            int emoticon_num = now.emoticon_num;
            int clipboard_num = now.clipboard_num;
            int time = now.time;

            if(emoticon_num == S){
                System.out.println(time);
                return;
            }

            if(emoticon_num > 0 && emoticon_num < 2000){
                // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
                if(!visited[emoticon_num][emoticon_num]){
                    visited[emoticon_num][emoticon_num] = true;

                    // test
//                    for(int i=0; i<10; i++){
//                        for(int j=0; j<10; j++){
//                            System.out.print(visited[i][j]?"T ":"F ");
//                        }
//                        System.out.println();
//                    }

                    queue.offer(new Step(emoticon_num, emoticon_num, time + 1));
                    System.out.println("1>복사 ("+emoticon_num+","+emoticon_num+","+(time+1)+")");
                }

                // 3. 화면에 있는 이모티콘중 하나를 삭제
                if (!visited[emoticon_num - 1][clipboard_num]) {
                    visited[emoticon_num - 1][clipboard_num] = true;

                    // test
//                    for(int i=0; i<10; i++){
//                        for(int j=0; j<10; j++){
//                            System.out.print(visited[i][j]?"T ":"F ");
//                        }
//                        System.out.println();
//                    }

                    queue.offer(new Step(emoticon_num - 1, clipboard_num, time + 1));
                    System.out.println("3>삭제 ("+(emoticon_num-1)+","+clipboard_num+","+(time+1)+")");
                }
            }

            // 2. 클립보드에 있는 모든 이모티콘 붙여넣기
            if (clipboard_num > 0 && emoticon_num + clipboard_num < 2000) {
                if (!visited[emoticon_num+clipboard_num][clipboard_num]) {
                    visited[emoticon_num+clipboard_num][clipboard_num] = true;

                    // test
//                    for(int i=0; i<10; i++){
//                        for(int j=0; j<10; j++){
//                            System.out.print(visited[i][j]?"T ":"F ");
//                        }
//                        System.out.println();
//                    }

                    queue.offer(new Step(emoticon_num + clipboard_num, clipboard_num, time + 1));
                    System.out.println("2>붙 ("+(emoticon_num + clipboard_num)+","+clipboard_num+","+(time+1)+")");
                }
            }

        }


    }

}
