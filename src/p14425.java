import java.nio.file.FileSystemNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class p14425 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap map = new HashMap<String, String>();

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String nString="";

        for(int i=0; i<n; i++){
            nString = sc.nextLine();
            map.put(nString, "1");
        }

        String mString="";
        int count = 0;
        for(int i=0; i<m; i++){
            mString = sc.nextLine();
            if (map.get(mString) != null) {
                count++;
            }
        }
        System.out.println(count);
    }
}
