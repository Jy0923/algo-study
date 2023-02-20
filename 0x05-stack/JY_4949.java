import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class JY_4949 {
	
	char[] charArr;
	String input;
	HashMap<Character, Character> map = new HashMap<>();
	Stack<Character> stack;
	
	public boolean isBalanced() {
		stack = new Stack<>();
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == '(' || charArr[i] == '[') {
				stack.push(charArr[i]);
			} else if (charArr[i] == ')' || charArr[i] == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != map.get(charArr[i])) {
					return false;
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
		map.put(']', '[');
		map.put(')', '(');
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		while (!input.equals(".")) {
			charArr = input.toCharArray();
			
			if (isBalanced()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
			input = br.readLine();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new JY_4949().solution();
	}
}
