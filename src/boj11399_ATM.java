import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11399_ATM {
    static class Person{
        int idx;
        int time;

        public Person(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Person[] people = new Person[n];
        for(int i=0; i<n; i++){
            people[i] = new Person(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(people, (a, b) -> Integer.compare(a.time, b.time)); // 오름차순

        int sum = 0;

        for(int i=0; i<n; i++){
            sum += people[i].time*(n-i);
        }
        System.out.println(sum);
    }
}
