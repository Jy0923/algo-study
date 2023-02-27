package devideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/237
public class Yy_1629_ {
	
	static long a, b, c;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		
		System.out.println(recur(a, b));
	}

	// a를 b번 곱한 수를 c로 나눈 나머지
	static long recur(long a, long b) {
		if(b == 1)
			return a % c;
		
		long tmp = recur(a, b/2);
		
		if(b % 2 == 1)
				// == a - 1
			return (tmp * tmp % c) * a % c;
		
		return tmp * tmp % c;
	}
}
