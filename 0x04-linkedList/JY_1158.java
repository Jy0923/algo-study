import java.util.Scanner;
import java.util.LinkedList;

public class JY_1158 {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int cur = 0;
		LinkedList<Integer> list1 = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			list1.add(i);
		}
		
		String result = "<";
		while (list1.size() != 0) {
			cur = (cur + k-1) % list1.size();
			if (list1.size() != 1) {
				result += (list1.remove(cur) + ", ");				
			}else {
				result += (list1.remove(cur) + ">");
			}
		}
		
		System.out.println(result);
		
	}
	
}
