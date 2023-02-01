import java.util.Scanner;

public class Th_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.nextLine();
        int digit = num.length(); // 자릿수

        int N = Integer.parseInt(num);
        int ctor = 0; // 생성자, 없으면 0

        for(int i=N-(9*digit); i<=N; i++) {
            int sum = i;

            int tmp = i;
            int cnt = (int)Math.pow(10, digit-1);
            //한자리수일 경우 cnt = 10;
            if(cnt == 1) cnt = 10;
            //각 자리수 구하기
            while(tmp > 0) {
                int tmp2 = tmp/cnt;
                sum += tmp2;
                tmp -= tmp2*cnt;
                cnt /= 10;
            }

            //생성자이면 break
            if(sum == N) {
                ctor = i;
                break;
            }
        }

        System.out.println(ctor);
    }
}
