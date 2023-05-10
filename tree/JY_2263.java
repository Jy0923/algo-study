import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	int n;
	int[] inorder;
	int[] postorder;
	ArrayList<Integer> preorder;
	String[] input;
	
	public void getPreorder(int inStart, int inEnd, int postStart, int postEnd) {
		
		int mid = postorder[postEnd];
		preorder.add(mid);
		
		int idx = 0;
		for (idx = inStart; idx <= inEnd; idx++) {
			if (inorder[idx] == mid) {
				break;
			}
		}
		
		int newInEnd, newInStart, newPostEnd, newPostStart, num1, num2;
		// inStart ~ newInEnd, postStart ~ newPostEnd
		newInEnd = idx - 1;
		newInStart = idx + 1;
		
		num1 = newInEnd - inStart + 1;
		num2 = inEnd - newInStart + 1;
		
		newPostEnd = postStart + num1 - 1;
		newPostStart = newPostEnd + 1;
		postEnd -= 1;
		
		if (num1 >= 1) {
			getPreorder(inStart, newInEnd, postStart, newPostEnd);
		}
		if (num2 >= 1) {
			getPreorder(newInStart, inEnd, newPostStart, postEnd);
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		
		inorder = new int[n];
		postorder = new int[n];
		preorder = new ArrayList<>();
		
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			inorder[i] = Integer.parseInt(input[i]);
		}
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			postorder[i] = Integer.parseInt(input[i]);
		}
		
		getPreorder(0, n-1, 0, n-1);
		for (int e : preorder) {
			bw.write(e + " ");
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
