import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
주어진 단계에 맞게 진행하다가, 컨베이어벨트의 내구도가 0인 구간이 k만큼 생기면 종료.
오른쪽으로 밀어주기 때문에 오른쪽부터 진행하도록 for문을 내림차순으로 썼다.
구간의 index를 잘못 써서 삽질을 했음. 인덱스 조심!
 */
public class p20055 {
    static int n;
    static int k;
    static int[] belt;
    static boolean[] robot; // 로봇이 있으면 T, 없으면 F
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        belt = new int[n * 2 + 1]; // 내구도
        for(int i=1; i<=2*n; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        robot = new boolean[n * 2 + 1]; // 로봇의 위치

        int stage = 0;
        while(true) {
            // 1. 벨트가 한칸 회전 -> 벨트 + 그 위의 로봇도 회전
            stage ++;
            rotateBelt();
            // 2. 각각의 로봇이 한 칸 이동할 수 있으면 이동. (이동하려는 칸에 로봇이 없고+내구도가 1이상)
            moveRobots();
            // 3. 올라가는 위치에 로봇이 없으면(index 1에 없으면) 로봇을 하나 올린다.
            addRobot();
            // 4. 내구도가 0인 칸의 개수가 k개 이상이면 과정을 종료. 아니라면 다시 1번
            if(isEnd()) {
                System.out.println(stage);
                break;
            }
        }

    }

    public static void rotateBelt(){
        // 벨트
        int tmp_belt = belt[2*n];
        for(int i=2*n-1; i>=1; i--){
            belt[i+1] = belt[i];
        }
        belt[1] = tmp_belt;
        // 같이 움직이는 로봇
        // 다만 n자리에 가면 바로 내려온다.
        if(robot[n-1]){ // n-1 자리에 로봇이 있으면
            robot[n-1] = false;
            // n으로 가는 순간 내려가기 때문에 n은 계속 false
            // 벨트가 같이 움직이기 때문에 내구도는 변화 없음
        }
        for(int i=n-2; i>=1; i--){
            robot[i+1] = robot[i];
        }
        robot[1]=false;
        //test
//        System.out.println("---------------rotateBelt---------------");
//        for(int i=1; i<=2*n; i++){
//            System.out.println("i="+i+"\tbelt="+belt[i]+"\trobot="+robot[i]);
//        }
    }

    public static void moveRobots(){
        if(robot[n-1] && belt[n]>0){
            robot[n-1] = false;
            belt[n]--;
            // robot[n]에 가는 순간 내려가므로 robot[n]은 true로 바꿔주지 않음.
        }
        for(int i=n-2; i>=1; i--){
            // 현재 위치에 로봇이 있고 다음 위치에는 비어있고 벨트의 내구도가 1이상이면
            if(robot[i] && !robot[i + 1] && belt[i+1]>0){
                robot[i] = false;
                robot[i+1] = true;
                belt[i+1]--;
            }
        }
        //test
//        System.out.println("---------------moveRobots---------------");
//        for(int i=1; i<=2*n; i++){
//            System.out.println("i="+i+"\tbelt="+belt[i]+"\trobot="+robot[i]);
//        }
    }
    public static void addRobot(){
        if(!robot[1] && belt[1]>0){
            robot[1] = true;
            belt[1]--;
        }
        //test
//        System.out.println("---------------addRobot---------------");
//        for(int i=1; i<=2*n; i++){
//            System.out.println("i="+i+"\tbelt="+belt[i]+"\trobot="+robot[i]);
//        }
    }
    public static boolean isEnd(){
        int count = 0;
        for(int i=1; i<=2*n; i++){
            if(belt[i]==0) count++;
        }
//        System.out.println("count : "+count);
        if(count>=k){
            return true;
        }else{
            return false;
        }
    }
}
