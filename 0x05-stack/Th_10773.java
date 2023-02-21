import java.util.Scanner;
import java.util.Stack;

public class BOJ_제로_10773 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<>();
		
		int T = sc.nextInt();
		int sum = 0;
		
		for(int i=0; i<T; i++) {
			int num = sc.nextInt();
			
			if(num == 0) {
				if(!stack.empty()) stack.pop();
				continue;
			}
			
			stack.add(num);
		}
		
		int size = stack.size();

		for(int i=0; i<size; i++)
			sum += stack.pop();
		
		System.out.println(sum);
	}
}