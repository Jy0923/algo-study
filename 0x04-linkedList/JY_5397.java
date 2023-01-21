import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class JY_5397 {
	
	public String getPassword(String input) {
		
		
		LinkedList<Character> list = new LinkedList<>();
		ListIterator<Character> iter = list.listIterator();
		
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			if (cur == '<') {
				if (iter.hasPrevious()) {
					iter.previous();
				}
			} else if (cur == '>') {
				if (iter.hasNext()) {
					iter.next();
				}
			} else if (cur == '-') {
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			} else {
				iter.add(cur);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (Character c : list) {
			 sb.append(c);
		}
		
		return sb.toString();
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < t; testCase++) {
			String input = br.readLine();
			String answer = getPassword(input);
			System.out.println(answer);
		}
	}
	
	public static void main(String[] args) throws Exception{
		new Main().solution();
	}
}