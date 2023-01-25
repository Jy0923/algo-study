import java.util.Scanner;

public class JY_25501 {
	
	int n;
	int isPalindrome;
	
	public int recursion(String s, int l, int r) {
		n += 1;
		if (l >= r) {
			return 1;
		} else if (s.charAt(l) != s.charAt(r)) {
			return 0;
		} else {
			return recursion(s, l+1, r-1);
		}
	}
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			String s = sc.next();
			isPalindrome = recursion(s, 0, s.length()-1);
			System.out.println(isPalindrome + " " + n);
			n = 0;
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		new JY_25501().solution();
	}
}
