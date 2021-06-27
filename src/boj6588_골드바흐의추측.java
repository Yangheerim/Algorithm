import java.io.*;

// 참고 : https://brenden.tistory.com/52
public class boj6588_골드바흐의추측 {

    static boolean[] prime_nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        primeNumberEratosthenesSieve();

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;

            int result = isPossible(n);

            if(result>0){
                bw.write(n+" = "+result+" + "+(n-result)+"\n");
            }else{
                bw.write("Goldbach's conjecture is wrong.");
            }
        }
        bw.flush();
    }

    public static int isPossible(int n){
        for(int i=1; i<=n/2; i++){
            int a = i;
            int b = n - i;
            if(prime_nums[a] && prime_nums[b]) return a;
        }
        return -1;
    }

    // 참고 : https://velog.io/@max9106/Algorithm-%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98-%EC%B2%B4
    // gif : https://st-lab.tistory.com/81?category=830901
    public static void primeNumberEratosthenesSieve() {
        prime_nums = new boolean[1000001];

        // initialize
        for(int i=2;i<=1000000;i++) {
            prime_nums[i] = true;
        }

        for(int i=2;i<=1000000;i++) {
            if(!prime_nums[i]) continue; // 이미 지워진 수라면 pass

            // 이미 지워진 숫자가 아니라면, 그 배수부터 출발하여 가능한 모든 숫자 지우기
            for(int j=2*i;j<=1000000; j+=i) {
                prime_nums[j] = false;
            }
        }
    }

    // 소수의 정의 : 1보다 큰 자연수 중 1과 그 수 자기 자신만을 약수로 갖는 자연수
    public static boolean isPrimeNum(int n){
        if(n<=1) return false;
        if(n==2) return true;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

}
