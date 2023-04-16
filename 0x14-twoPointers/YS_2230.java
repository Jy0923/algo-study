import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int ed = 0;
		int min = Integer.MAX_VALUE;
		for (int st = 0; st < n; st++) {
			while(ed < n && arr[ed] - arr[st] < m) ed++;
			if(ed == n) break;
			int diff = arr[ed] - arr[st];
			if(diff < min) {
				min = diff;
			}
			
		}
		System.out.println(min);
		
	}
}
