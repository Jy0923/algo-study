import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] arr;
	
	public static void fibonacci(int k) {
		arr = new int[k+1];
		
		if(k <= 2) {
            		for(int i=0; i<=k; i++){
                			arr[i] = i;
            		}
            
			System.out.println(arr[k]);
			return;
		}
		
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i=3; i<=k; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 15746;
		}
		
		System.out.println(arr[k]);
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		fibonacci(n);
	}

}
