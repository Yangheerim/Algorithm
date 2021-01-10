import java.io.*;
import java.util.*;
import java.util.Deque;
/*
소팅 게임,
시간 초과로 인해 불필요한 소팅의 횟수를 줄인다 -> Deque 사용
또한 각각 소팅하는 것이 아니라, 맨 처음에 오름차순으로 max index만큼 소팅 후
각각에 맞게 오름차순-내림차순-오름차순 ... 이런식으로 복사?하는 방식으로 진행한다.
참고한 링크 : https://mygumi.tistory.com/354
 */
public class p13415 {
    static class Item{
        String order;
        int index;

        Item(String order, int index) {
            this.order = order;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Item> dq = new ArrayDeque<Item>();

        //input
        int num = Integer.parseInt(br.readLine());
        int[] nums = new int[num+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= num; i++) {
            nums[i]= Integer.parseInt(st.nextToken());
        }
        //input-set
        int set_num = Integer.parseInt(br.readLine());
        // 입력받으면서 불필요한 정렬의 횟수를 줄임 -> Deque 사용!
        for (int i = 1; i <= set_num; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int asc = Integer.parseInt(st2.nextToken());
            int desc = Integer.parseInt(st2.nextToken());
            while(!dq.isEmpty() && dq.getLast().index<=asc){
                dq.removeLast();
            }
            dq.addLast(new Item("asc", asc));
            while(!dq.isEmpty() && dq.getLast().index<=desc){
                dq.removeLast();
            }
            dq.addLast(new Item("desc", desc));
        }
        // 여기까지 하면 deque에 내림차순(?) 처럼 불필요한거 제거되어 있는 상태!

        dq.addLast(new Item("asc", 0)); // order은 딱히 상관없음. 큐가 비어서 마지막꺼가 복사하는게 안되는걸 막기 위함

        Item item = dq.removeFirst(); //max index
        int[] result = new int[num+1];
        int start = 1;
        int max_index = item.index;
        int end = max_index;

        String order = item.order;
        int asc_index = end;
        int desc_index = 1;

//        System.out.println("test : asc_index = "+asc_index+", desc_index = "+desc_index);

        Arrays.sort(nums, 1, max_index+1);
        while(!dq.isEmpty()){
            item = dq.removeFirst();
            start = item.index;
            if(order.equals("asc")){
//                System.out.println("test2 : start = "+start+", end = "+end);
                for (int i = end; i > start; i--) {
                    result[i] = nums[asc_index--];
                }
            }else{
//                System.out.println("test3 : start = "+start+", end = "+end);
                for (int i = end; i > start; i--) {
                    result[i] = nums[desc_index++];
                }
            }
            order = item.order;
            end = item.index;
//            System.out.println("test1 : asc_index = "+asc_index+", desc_index = "+desc_index);
        }

        // print result
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= max_index; i++) {
            bw.write(result[i] + " ");
        }

        for (int i = max_index+1; i<=num; i++) {
            bw.write(nums[i] + " ");
        }
        bw.flush();
    }
}
