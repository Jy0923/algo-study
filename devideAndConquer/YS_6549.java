import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int MaxHeight = 10000;
	
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if( n == 0) {
				break;
			}
			
			arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			

			System.out.println(find(0, n-1));
			
			
			
		}
	}
    
    public static int find(int left, int right) {
    	if(left == right) return arr[left];
    	int mid = left + (right - left) / 2;
    	int ans = Math.max(find(left, mid), find(mid+1, right));
    	
    	int leftPosition = mid;
    	int rightPosition = mid + 1;
    	int minHeight = MaxHeight + 1;
    	while(left >= leftPosition && rightPosition <= right) {
    		minHeight = Math.min(minHeight, arr[leftPosition]);
    		minHeight = Math.min(minHeight, arr[rightPosition]);
    		ans = Math.max(ans, (rightPosition - leftPosition + 1) * minHeight);
    		if(left == leftPosition) ++rightPosition;
    		else if (right == rightPosition) --leftPosition;
    		else if (arr[leftPosition - 1] <= arr[rightPosition + 1]) ++rightPosition;
    		else --leftPosition;
    	}
    	return ans;
    	
    	
    }
}
// 블로그 참고
