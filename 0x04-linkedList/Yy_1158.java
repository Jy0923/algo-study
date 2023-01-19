import java.util.ArrayList;
import java.util.Scanner;

public class Yy_1158 {
	
	public static void main(String[] args) {
		
		// 요세푸스 문제
		// linkedList 익숙하지 않아서 다른 방법으로 일단 해결했습니다 ㅠㅠ
		ArrayList<Integer> list = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	int k = sc.nextInt();
		
		int num = 1;
		for(int i = 0; i < n; i++) {
			list.add(num++);
		}

		int[] removeNumsArr = new int[n];
		int idx = 0;
		
		for(int i = k - 1; list.size() > 0; i += k-1) {
			if(i < list.size()) {
				int removeNum = list.get(i);
				list.remove(i);
				
				removeNumsArr[idx++] = removeNum;
			} else {
				i -= list.size() + k - 1;
				continue;
			}
		}
		
		String result = "<";
		for(int i=0; i<n-1; i++) {
			result += removeNumsArr[i] + ", ";
		}
		result += removeNumsArr[n-1] + ">";
		
		System.out.println(result);

	}
	
}
