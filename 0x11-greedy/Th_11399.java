import java.util.Arrays;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		int[] saram = new int[N];
		int[] prefixSum = new int[N+1];
		String[] read = sc.nextLine().split(" ");

		for(int i=0; i<N; i++) {
			saram[i] = Integer.parseInt(read[i]);
		}
		
		Arrays.sort(saram);
		
		int minTime = 0;
		
		for(int i=1; i<=N; i++) {
			prefixSum[i] = saram[i-1] + prefixSum[i-1];
		}
		
		for(int time : prefixSum) {
			minTime += time;
		}
		
		System.out.println(minTime);
	}
}