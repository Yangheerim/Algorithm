import java.util.Scanner;
/*
최소 묶음 수를 어떻게 구해야할지를 잘 생각해야 하는 문제.
우선은 5kg짜리 묶음이 많아야 묶음 수를 줄일 수 있다.
그래서 5kg로 나누어 떨어지는지를 확인하는데,
나누어 떨어지지 않으면 총 무게에서 3kg씩 빼며 (=3kg짜리 묶음을 추가하며)
5kg으로 구성할 수 있는지를 확인한다.
만약 5로 나누어떨어진다면, 그 값과 3kg묶음의 수(=count)를 더해 추가해서 출력.
5kg묶음이 0개인데도 나누어떨어지지 않으면 -1을 출력
 */
public class p2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int remain = n;
        int count = 0;
        while (true) {
            if (remain % 5 == 0) {
                System.out.println(remain/5+count);
                break;
            }else if (remain<=0){
                System.out.println(-1);
                break;
            }
            remain -= 3;
            count++; // 3kg짜리의 개수
        }
    }
}
