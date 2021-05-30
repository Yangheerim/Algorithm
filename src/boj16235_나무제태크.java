import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj16235_나무제태크 {
    static class Land{
        int nutrient;
        ArrayList<Tree> trees;

        public Land() {
            this.nutrient = 5;
            this.trees = new ArrayList<>();
        }
    }
    static class Tree{
        int age;

        public Tree(int age) {
            this.age = age;
        }
    }
    static class DeadTree{
        int i;
        int j;
        Tree tree;

        public DeadTree(int i, int j, Tree tree) {
            this.i = i;
            this.j = j;
            this.tree = tree;
        }
    }

    static Land[][] map;
    static int[][] A;
    static int n;
    static int m;
    static int k;
    static ArrayList<DeadTree> dead_tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new Land[n+1][n+1]; // NxN 땅
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j] = new Land();
            }
        }

        A = new int[n+1][n+1]; // 겨울마다 뿌려주는 양분
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            map[r][c].trees.add(new Tree(age));
        }

        for(int year=1; year<=k; year++){
            Spring();
            Summer();
            Fall();
            Winter();
        }
        System.out.println(countTreeNum());
    }

    public static int countTreeNum(){
        int cnt = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                cnt += map[i][j].trees.size();
            }
        }
        return cnt;
    }

    public static void Spring(){
        dead_tree = new ArrayList<>();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j].trees.size()==0) continue;
                // 여러개면 어린나무가 먹도록 나이가 어린순으로 소팅
                Collections.sort(map[i][j].trees, (t1,t2)->Integer.compare(t1.age, t2.age));
                for (Tree t : map[i][j].trees) {
                    if(map[i][j].nutrient >= t.age) {
                        map[i][j].nutrient -= t.age;
                        t.age ++;
                    }else{
                        // 죽어서 양분이 됨
                        dead_tree.add(new DeadTree(i, j, t));
                    }
                }
            }
        }
    }

    public static void Summer(){
        for (DeadTree t : dead_tree) {
            map[t.i][t.j].nutrient += t.tree.age / 2;
            map[t.i][t.j].trees.remove(t.tree);
        }
    }

    public static void Fall(){
        int[] mi = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] mj = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for (Tree t : map[i][j].trees) {
                    if (t.age % 5 ==0){
                        for(int d=0; d<8; d++){
                            int ni = i + mi[d];
                            int nj = j + mj[d];
                            if(ni<1 || nj<1 || ni>n || nj>n) continue;
                            map[ni][nj].trees.add(new Tree(1));
                        }
                    }
                }
            }
        }
    }

    public static void Winter(){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j].nutrient += A[i][j];
            }
        }
    }
}
