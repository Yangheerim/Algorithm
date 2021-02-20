import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class programmers_K번째수 {
    public static void main(String[] args) {
        HashMap<String, Integer> hash = new HashMap<>();
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] comm = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

//        System.out.println(solution(arr, comm));
        solution(arr, comm);
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int c=0; c<commands.length; c++){
            int i = commands[c][0]-1;
            int j = commands[c][1]-1;
            int k = commands[c][2]-1;
            int[] selected_arr = new int[j - i + 1];
            for(int idx=0; idx<selected_arr.length; idx++){
                selected_arr[idx] = array[i++];
            }
            Arrays.sort(selected_arr);
            answer[c] = selected_arr[k];
        }

        return answer;
    }


}
