import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int x;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(arr);
		x = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int st = 0; st < n-1; st++) {
			for (int ed = st + 1; ed < n; ed++) {
				if(arr[st] + arr[ed] > x) break;
				if(arr[st] + arr[ed] == x) count++;
				
			}
		}
		
		System.out.println(count);
	}
}
