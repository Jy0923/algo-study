import java.util.Scanner;

public class JY_10872 {
	
	public int factorial(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	public void solution() {
		int n = new Scanner(System.in).nextInt();
		System.out.println(factorial(n));
	}
	
	public static void main(String[] args) {
		new JY_10872().solution();
	}
}
