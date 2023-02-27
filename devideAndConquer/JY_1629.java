import java.util.Scanner;

public class JY_1629 {
	
	public long dq(long a, long b, long c) {
		if (b == 1) {
			return a % c;
		}
		
		if ((b & 1) == 1) {
			return ((dq(a, b/2, c) % c) * (dq(a, b/2+1, c) % c)) % c;
		} else {
			long tmp = dq(a, b/2, c) % c;
			return (tmp * tmp) % c;
		}
	}

	public void solution() {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		System.out.println(dq(a, b, c));
	}

	public static void main(String[] args) {
		new JY_1629().solution();
	}
}
