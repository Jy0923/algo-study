import java.util.*;

public class Th_10872 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 입력 받은 정수
        
        System.out.println(recursion(N));
    }
    
    static int recursion(int n) {
        if(n == 0) 
        	return 1;
        
        return n * recursion(n-1);
    }
}

