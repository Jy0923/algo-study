import java.util.Scanner;

public class Yy_10870 {
	// 피보나치 수 5
	
	public static int fibonacci(int num) {
		
		if(num == 0) return 0;
		
		if(num == 1) return 1;

		num = fibonacci(num - 1) + fibonacci(num - 2);
		
		return num;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fibonacci(n));
		
		
	}
	
}
