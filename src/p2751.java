import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Array.sort() 하면 100% 시간초과남. -> 최악이 O(n^2)여서
Collections.sort() 하면 최대 nlogn이라서 안남 ㅇㅋ
+ List가 Arraylist 보다 빨라서 이거 써야 시간초과 안남 (되는데?)
+ BufferedWriter써야 시간초과 안남 ㅂㄷㅂㄷ (이거다)
 */
public class p2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0; i<num; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(nums);
//        for (int n : nums) {
//            System.out.println(n);
//        }
        for (int i = 0; i < nums.size(); i++){
            bw.write(nums.get(i) + "\n");
        }
        bw.flush();
    }
}

