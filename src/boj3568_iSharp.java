import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3568_iSharp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine().replace(",","").replace(";","");
        String[] str = origin.split(" ");

        for (int i = 1; i < str.length; i++) {
            String[] variable = reverseType(str[i]).split("#");
            System.out.println(str[0]+variable[0]+" "+variable[1]+";");
        }
    }

    public static String reverseType(String str){
        char[] origin = str.toCharArray();
        String result = "";

        for (int i = str.length()-1; i >= 0; i--) {
            if(origin[i]!=']'){
                if(origin[i]=='*' || origin[i]=='&'){
                    result += origin[i];
                }else{
                    result += "#";
                    for(int j=0; j <= i; j++){
                        result += origin[j];
                    }
                    break;
                }
            }else{
                result += "[]";
                i--;
            }
        }
        return result;
    }

}
