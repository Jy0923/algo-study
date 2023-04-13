import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] inOrder;
	static int[] postOrder;
	static int[] index;
	static int rootIdx;
	static int nextIdx;
	static int[] result;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		inOrder = new int[n+1];
		postOrder = new int[n+1];
		result = new int[n+1];
		nextIdx = n-1;
		index = new int[n+1];


		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
			index[inOrder[i]] = i ;
		}
//		for (int i = 1; i <= n; i++) {
//			index[inOrder[i]] = i;
//		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(1, n, 1, n);

	}
	
	static void solve(int inStart, int inEnd, int postStart, int postEnd){
		if(inStart > inEnd || postStart > postEnd) return;
		
		int rootIdx = index[postOrder[postEnd]];
		int left = rootIdx - inStart;
		int right = inEnd - rootIdx;
		System.out.print(inOrder[rootIdx] + " ");
		
		solve(inStart, rootIdx - 1, postStart, postStart + left - 1);
		solve(rootIdx + 1, inEnd, postStart + left, postEnd - 1);

		
		
		
		
	}
	
}
