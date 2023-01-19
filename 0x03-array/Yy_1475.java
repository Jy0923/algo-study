
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yy_1475 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputNum = Integer.parseInt(br.readLine());
		
		int [] arr = new int[10]; 
		
		while(inputNum != 0) {
			int num = 0;
			
			num = inputNum % 10;
			
			arr[num] += 1;
			
			inputNum = (inputNum - num) / 10;
		}
		
		int maxCnt = 0;
		
		// 6 or 9 : 각각 개수를 더한 후 n/2 반올림해준 개수
		arr[6] += arr[9];
		arr[9] = 0;
		arr[6] = (int) Math.round(arr[6]/2.0);
		
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > maxCnt) maxCnt = arr[i];
		}
		System.out.println(maxCnt);
	}
}
