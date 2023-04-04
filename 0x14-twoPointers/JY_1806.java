import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	
	int n, s;
	int[] arr;
	String[] input;
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		s = Integer.parseInt(input[1]);
		arr = new int[n];
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int answer = Integer.MAX_VALUE;
		int st = 0, en= 0; // st, en 포함
		int curSum = arr[st];
		if (curSum >= s) {
			answer = 1;
		}
		while (true) {
			
			if (en == n-1) {
				curSum -= arr[st];
				st++;
			} else if (st == en) {
				en++;
				curSum += arr[en];
			} else if (curSum >= s) {
				curSum -= arr[st];
				st++;
			} else if (curSum < s) {
				en++;
				curSum += arr[en];
			}
						
			if (curSum >= s) {
				if (en - st + 1 < answer) {
					answer = en - st + 1;
				}
			}
			
			if (st == n-1) {
				break;
			}
		}
		System.out.println(answer==Integer.MAX_VALUE?0:answer);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
