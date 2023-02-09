import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp;
    
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
		dp = new int[100][100][100];		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	int c = Integer.parseInt(st.nextToken());
	    	if(a == -1 && b == -1 && c == -1) {
	    		break;
	    	}
	    	sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
	    	
		}
		System.out.println(sb);


	}
    
    public static int w(int a, int b, int c) {
    	if(a <= 0 || b <= 0 || c <= 0) {
    		return 1;
    	}
    	
    	if(a > 20 || b > 20 || c > 20) {
    		return 1048576;
    	}
    	
    	if ((a < b) && (b < c)) {
    		return w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
    	}
    	
    	return w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    	
    }

}
// 시간초과..... 입력값을 한번에 받아서 처리해야할까요....
