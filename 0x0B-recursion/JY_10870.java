import java.util.Scanner;

public class JY_10870 {
	
	public int[] table;
	
	public int fibonacci(int n) {
		if (table[n] > 0) {
			return table[n];
		}
		if (n <= 1) {
			return n;
		} 
		table[n] = fibonacci(n-1) + fibonacci(n-2);
		return table[n];
	}
	
	public void solution() {
		int n = new Scanner(System.in).nextInt();
		table = new int[n+1];
		System.out.println(fibonacci(n));
	}
	
	public static void main(String[] args) {
		new JY_10870().solution();
	}
}
