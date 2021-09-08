package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class programmers_파일명정렬 {

    static class File{
        String file_name;
        String head;
        int number;

        public File(String file_name, String head, int number) {
            this.file_name = file_name;
            this.head = head;
            this.number = number;
        }
    }

    public static String[] solution(String[] files) {

        File[] file_info = new File[files.length];

        for (int i = 0; i < files.length; i++) {
            String[] split = splitFileName(files[i]);
            file_info[i] = new File(files[i], split[0], Integer.parseInt(split[1]));
        }

        // File[] 도 어쨋든 배열이니까 Arrays.sort를 써야한다.
        // Collections.sort는 List에 쓸 것!

        Arrays.sort(file_info, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if ((o1.head).equals(o2.head)) {
                    return o1.number-o2.number;
                }else{
                    return (o1.head).compareTo(o2.head);
                }
            }
        });

        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = file_info[i].file_name;
        }
        return answer;
    }

    public static String[] splitFileName(String file){
        String str[] = new String[3];
        str[0] = "";
        str[1] = "";
        str[2] = "";

        int idx = 0;
        for (int i = 0; i < file.length(); i++) {
            char c = file.charAt(i);

            if(idx==0 && !Character.isDigit(c)){
                str[idx] += c;
                continue;
            }

            if(idx==0 && Character.isDigit(c)){
                idx ++;
            }

            if(idx==1 && Character.isDigit(c)){
                str[idx] += c;
                continue;
            }

            if(idx==1 && !Character.isDigit(c)){
                idx ++;
            }
            str[idx] += c;
        }

        str[0] = str[0].toLowerCase();
        System.out.println(str[0]+"/"+str[1]+"/"+str[2]); // test
        return str;
    }
}
