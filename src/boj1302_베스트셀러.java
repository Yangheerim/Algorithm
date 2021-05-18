import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj1302_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            hash.put(str, hash.getOrDefault(str, 0) + 1);
        }

        int max = -1;
        String max_key = "";
        for (String key : hash.keySet()) {
            if(hash.get(key)>max){
                max = hash.get(key);
                max_key = key;
            }else if(hash.get(key)==max){
                if (max_key.compareTo(key)>0) { // 사전순 앞에꺼가 더 작음
                    max_key = key;
                }
            }
        }
        System.out.println(max_key);

    }
}
