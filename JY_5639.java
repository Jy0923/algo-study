import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main{
	
	int n;
	ArrayList<Integer> preorder = new ArrayList<>();
	int[] postorder;
	
	public void getPostorder(int preStartIdx, int preEndIdx, int postStartIdx, int postEndIdx) {
		int mid = preorder.get(preStartIdx);
		postorder[postEndIdx] = mid;
		
		int curSize = preEndIdx - preStartIdx + 1;
		int leftSize = 0;
		for (int i = preStartIdx + 1; i < n; i++) {
			if (preorder.get(i) < mid) {
				leftSize++;
			} else {
				break;
			}
		}
		int rightSize = curSize - leftSize - 1;
		
		// left subtree
		if (leftSize > 0) {			
			getPostorder(preStartIdx + 1, preStartIdx + leftSize, postStartIdx, postStartIdx + leftSize - 1);
		}
		// right subtree
		if (rightSize > 0) {
			getPostorder(preEndIdx - rightSize + 1, preEndIdx, postEndIdx - rightSize, postEndIdx - 1);
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			try {
				preorder.add(Integer.parseInt(br.readLine()));
			}catch (Exception e) {
				break;
			}
		}
		n = preorder.size();
		postorder = new int[n];
		getPostorder(0, n-1, 0, n-1);
		for (int e : postorder) {
			bw.write(e + "\n");
		}
		bw.flush();
		
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
