import java.util.Scanner;

public class Th_11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] max = new int[N];
		int maxValue = 1;
	
		for(int i=0; i<N; i++){
			arr[i] = sc.nextInt();
			max[i] = 1;
		}
		
		max[0] = 1;
		
		for(int i=1; i<N; i++) {
			for(int j=i-1; j>=0; j--) {
				if(arr[i] > arr[j]) {
					max[i] = Math.max(max[i], max[j]+1);
					maxValue = Math.max(maxValue, max[i]);
				}
			}
		}
		
		System.out.println(maxValue);
	}
}
