import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class JY_9012 {
	
	int t;
	char[] charArr;
	Stack<Character> stack;
	
	public boolean isVPS() {
		stack = new Stack<>();
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == '(') {
				stack.push(charArr[i]);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			charArr = br.readLine().toCharArray();
			if (isVPS()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		new JY_9012().solution();
	}
}
