import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JY_14888{
	
	int n;
	int[] numbers;
	int[] operators = new int[4];
	char[] pmmd = {'+', '-', '*', '/'};
	char[] operatorSeq;
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
	int curResult;
	
	public int calculator() {
		int cr = numbers[0];
		for (int i = 0; i < n-1; i++) {
			if (operatorSeq[i] == '+') {
				cr += numbers[i+1];
			} else if (operatorSeq[i] == '-') {
				cr -= numbers[i+1];
			} else if (operatorSeq[i] == '*') {
				cr *= numbers[i+1];
			} else if (operatorSeq[i] == '/') {
				cr /= numbers[i+1];
			}
		}
		return cr;
	}
	
	public void backtracking(int k) {
		if (k == n-1) {
			curResult = calculator();
			if (curResult > max) {
				max = curResult;
			}
			if (curResult < min) {
				min = curResult;
			}
		}
		for (int i = 0; i < 4; i++) { 
			if (operators[i] > 0) {
				operators[i] -= 1;
				operatorSeq[k] = pmmd[i];
				backtracking(k+1);
				operators[i] += 1;
			}
		}
		
	}
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		operatorSeq = new char[n-1];
		
		backtracking(0);
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public static void main(String[] args) throws IOException {
		new JY_14888().solution();
	}

}
