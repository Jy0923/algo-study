import java.util.ArrayList;
import java.util.Scanner;

public class Yy_1158 {
	
	public static void main(String[] args) {
		
		// 요세푸스 문제
		// linkedList 익숙하지 않아서 다른 방법으로 일단 해결했습니다 ㅠㅠ
		ArrayList<Integer> list = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	int k = sc.nextInt();
		
		// 1 ~ n 까지 ArrayList에 할당
		int num = 1;
		for(int i = 0; i < n; i++) {
			list.add(num++);
		}
		
		// 제거된 숫자들 모아둘 배열 생성(최종적으로 n개의 숫자가 제거되니까 크기는 n)
		int[] removeNumsArr = new int[n];
		int idx = 0; // 배열에 숫자 넣을 때 인덱스
		
		// k-1 인덱스부터 k-1씩 증가시킨다(숫자 1개 제거된 후 반복하기 때문에 -1 해줬음), list 크기가 0이 되기 전까지 반복
		for(int i = k - 1; list.size() > 0; i += k-1) {
			if(i < list.size()) { // 제거할 인덱스가 문제없을 때  숫자 반환 후 제거
				int removeNum = list.get(i);
				list.remove(i);
				 
				removeNumsArr[idx++] = removeNum;  // 반환된 숫자 배열에 삽입 및 idx++
			} else {
				i -= list.size() + k - 1; 	// 인덱스가 리스트 크기를 넘어갔을 때 
				continue;					// 인덱스를 재조정해준다.
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
