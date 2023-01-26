import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Yy_1406_ {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Character> list = new LinkedList<>();

		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			list.add(str.charAt(i));
		}
				
		int m = Integer.parseInt(br.readLine());
		
		
		// Iterator 만들기 
		ListIterator<Character> iterator = list.listIterator();
		
		// 커서 제일 오른쪽 끝으로 옮겨주기
		while(iterator.hasNext()) {
			iterator.next();
		}
		
		String inputs = "";
		char input = 0;
		
		for(int i=0; i<m; i++) {
			inputs = br.readLine();
			input = inputs.charAt(0);
			
			if(input == 'L' && iterator.hasPrevious()){
				iterator.previous();
			}
			else if(input == 'D' && iterator.hasNext()) {
				iterator.next();
			}
			else if(input == 'B' && iterator.hasPrevious()) {
				iterator.previous();
				iterator.remove();
			}
			else if(input == 'P') {
				iterator.add(inputs.charAt(2));
			}
			
		}
		
		//출력시간 줄이려고 StringBuilder 로 변경
		StringBuilder sb = new StringBuilder();
		for(char c : list) {
			sb.append(c);
		}
		
		System.out.println(sb);
		
		
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Character> list = new ArrayList<>();

		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		// 커서 위치 인덱스( 0 ~ size )
		int cur = list.size(); 
		
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String token = st.nextToken();
			
			if(token.charAt(0) == 'L' && cur > 0) {
				cur -= 1;
			}
			else if(token.charAt(0) == 'D' && cur < list.size()) {
				cur += 1;
			}
			else if(token.charAt(0) == 'B' && cur > 0) {
				list.remove(cur - 1);
				cur -= 1;
			}
			else if(token.charAt(0) == 'P') {
				list.add(cur, st.nextToken().charAt(0));
				cur += 1;
			}
		}
		
		// 첨에 스위치문 써봤던거
		for(int tc=0; tc<m; tc++) {
			String input = br.readLine();
			
			switch(input.split(" ")[0]) {
			case "L":
				if(cur > 0) cur -= 1;
				break;
			case "D":
				if(cur < list.size()) cur += 1;
				break;
			case "B":
				if(cur > 0) {
					list.remove(cur - 1);
					cur -= 1;
				}
				break;
			case "P":
				list.add(cur, input.split(" ")[1].charAt(0));
				cur += 1;
				break;
			}
		}
		
		for(char c : list) {
			System.out.print(c);
		}
		*/
	}
}
