import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class BAEKJOON_S2_에디터_1406{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine(); // 초기 문자열
		int c = Integer.parseInt(br.readLine()); // 명령어 갯수
		
		LinkedList<Character> list = new LinkedList<>(); // 문자열 담을 리스트
		
		// 문자열 잘라서 LinkedList로
		for(int i=0; i<str.length(); i++)
			list.add(str.charAt(i));
		
		ListIterator<Character> iter = list.listIterator(); // 리스트로 iterator 만들기

		//커서 맨뒤로 보내기
		while(iter.hasNext()) {
			iter.next();
		}
		
		// 명령어 실행
		for(int i=0; i<c; i++) {
			String command = br.readLine();
			
			switch(command.charAt(0)) {
				case 'L':
					if(iter.hasPrevious())
						iter.previous();
					break;
				case 'D':
					if(iter.hasNext()) 
						iter.next();
					break;
				case 'B':
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				case 'P':
					char t = command.charAt(2); //추가할 문자
					iter.add(t);
					break;
			}
		} // 명령어 끝
		
		///출력
		for(Character chr : list)
			bw.write(chr);
		
		bw.flush();
		bw.close();
		br.close();
	}
}

//LinkedList로만 구현할 경우
//시간 초과...
//iterator 쓰니까 되네요
//참고한 블로그 : https://minhamina.tistory.com/17


//원래 작성했던 코드
/*
public class Main{
	
	static int idx;
	static LinkedList<Character> list = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		// 문자열 잘라서 LinkedList로
		for(int i=0; i<str.length(); i++)
			list.add(str.charAt(i));
		
		
		list.addFirst(' ');
		
		int c = Integer.parseInt(br.readLine()); // 명령어 갯수
		idx = list.size() - 1; // 커서 시작 위치
		

		// 명령어 실행
		for(int i=0; i<c; i++) {
			String command = br.readLine();
			
			switch(command.charAt(0)) {
				case('L'):
					if(idx <= 0) 
						break;
					idx--;
					break;
					
				case('D'):
					if(idx >= list.size() - 1) 
						break;
					idx++;
					break;
					
				case('b'):
					if(idx <= 0) 
						break;
					list.remove(idx--);
					break;
					
				case('P'):
					if(idx == list.size()-1) {
						list.add(command.charAt(2));
						idx++;
						break;
					}
					
					list.add(++idx, command.charAt(2));
					break;
			}
		
		StringBuilder sb = new StringBuilder();
		
		//출력
		for(int j=1; j<list.size(); j++)
			sb.append(list.get(j));
		
		System.out.println(sb);
		}

	}
}
*/