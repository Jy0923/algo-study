import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer numbers = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(numbers.nextToken());
		int B = Integer.parseInt(numbers.nextToken());
		int C = Integer.parseInt(numbers.nextToken());
		
		long answer = divide(A,B,C);
		
		System.out.println(answer);
	}
	
	private static long divide(int A, int B, int C) {
		if(B == 1) return A % C;
		
		long tmp = divide(A, B/2, C);
		
		if(B % 2 == 1) return ((tmp % C * tmp % C) % C * A) % C;
		return (tmp % C * tmp % C) % C;
	}
}