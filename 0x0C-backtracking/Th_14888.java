import java.util.ArrayList;
import java.util.Scanner;

//백준 실버1 연산자 끼워넣기
public class Th_14888 {
    
    static int N; //수의 개수
    static int[] nums; //수 배열
    // 0 == +
    // 1 == -
    // 2 == x
    // 3 == /
    static ArrayList<Integer> operators = new ArrayList<>();
    static boolean[] used;
    static int max = Integer.MIN_VALUE; // 연산의 최대값
    static int min = Integer.MAX_VALUE; // 연산의 최소값
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        used = new boolean[N-1];

        //연산해야 할 숫자들 배열에 넣기
        for(int i=0; i<N; i++) {
            nums[i] = sc.nextInt();
        }

        //연산자 리스트에 넣기
        for(int i=0; i<4; i++) {
            int cnt = sc.nextInt();

            for(int j=0; j<cnt; j++) {
                operators.add(i);
            }
        }

        tracking(0, nums[0]);

        System.out.println(max + "\n" + min);
    }

    private static void tracking(int cnt, int num) {
        //연산 끝났으면
        if(cnt == (N-1)) {
            //최대값과 비교
            max = Math.max(max, num);
            //최소값과 비교
            min = Math.min(min, num);
            return;
        }

        for(int i=0; i<operators.size(); i++) {
            if(used[i]) continue;

            int l = num; //좌측 피연산자
            int r = nums[cnt+1]; //우측 피연산자
            int operator = operators.get(i); // 연산자

            int result = operate(l, r, operator); // 연산 결과값

            used[i] = true;
            tracking(cnt+1, result);
            used[i] = false;
        }
    }

    private static int operate(int l, int r, int operator) {
        if(operator == 0)
            return add(l,r);

        if(operator == 1)
            return subtract(l,r);

        if(operator == 2)
            return multiply(l,r);

        return divide(l,r);
    }

    private static int add(int l, int r) {
        return l+r;
    }

    private static int subtract(int l, int r) {
        return l-r;
    }

    private static int multiply(int l, int r) {
        return l*r;
    }

    private static int divide(int l, int r) {
        //한쪽이 음수인 경우
        if((l < 0 && r > 0) || (l > 0 && r < 0)) {
            int absL = Math.abs(l);
            int absR = Math.abs(r);

            return -1*(absL/absR);
        }

        return l/r;
    }
}