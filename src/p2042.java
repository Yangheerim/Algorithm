import java.io.*;
import java.util.StringTokenizer;
/*
segment tree를 사용하여 구간의 합을 구하는 문제!
원래 배열의 s~e까지를 구하기 위해 하나씩 더하면 O(N)의 시간복잡도를 가지게 되는데,
이 문제에서는 최대 M번 구하기 때문에 N*M = 1,000,000 * 10,000이므로 10^10이 된다.
10^9이 1초이기 때문에 10*1초면 시간 초과!
그렇기 때문에 O(MlogN)의 시간복잡도를 가지는 segment tree를 사용해야함.
DFS를 사용하여 구현했으나 좀 더 공부가 필요해보임.
 */
public class p2042 {
    static long[] nums;
    static long[] tree;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //input
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        nums = new long[n+1];
        for(int i=1; i<=n; i++){
            nums[i] = Long.parseLong(br.readLine());
        }

        // init segment tree
        int h = (int) Math.ceil(Math.log(n) / Math.log(2)); // log2(N)
        tree = new long[(int)Math.pow(2, h + 1)];
        init(1, n, 1);

        for(int i=1; i<=m+k; i++){
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            long n2 = Long.parseLong(st.nextToken());
            if(option==1){
                long diff = n2 - nums[n1];
                nums[n1] = (int) n2;
                update(1, n, 1, n1, diff);
            }else{
                long result = sum(1, n, 1, n1, (int) n2);
                bw.write(result+"\n");
            }
        }
        bw.flush();
    }

    static long init(int start, int end, int node){
        if(start==end){ // 리프노드라면
            return tree[node] = nums[start];
        }
        int mid = (start+end)/2;
        return tree[node] = init(start, mid, node*2)+init(mid+1, end, node*2+1);
    }

    static long sum(int start, int end, int node, int left, int right){
        if(left>end || right<start) // 범위 밖에 있는 경우
            return 0;
        if(left<=start && end <=right) //범위 안에 있는 경우
            return tree[node];
        int mid = (start+end)/2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }

    // index : 수정할 인덱스, diff : 수정할 값
    static void update(int start, int end, int node, int idx, long diff){
        if(idx<start || idx>end) return;

        tree[node] += diff; // 범위 안에 있으면 내려가며 다른 원소도 갱신

        if(start==end) return;
        int mid = (start+end)/2;
        update(start, mid, node*2, idx, diff);
        update(mid+1, end, node*2+1, idx, diff);
    }
}
