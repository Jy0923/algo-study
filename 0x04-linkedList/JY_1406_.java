import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class JY_1406_ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Character> list = new LinkedList<>();
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			list.add(input.charAt(i));
		}
		
		int m = Integer.parseInt(br.readLine());
		String cmds;
		char cmd;
		char inputChar;
		
		ListIterator<Character> iter = list.listIterator();
		
		while(iter.hasNext()) {
			iter.next();
		}
		
		for (int i = 0; i < m; i++) {
			cmds = br.readLine();
			if (cmds.charAt(0) == 'P') {
				inputChar = cmds.charAt(2);
				iter.add(inputChar);
			} else {
				cmd = cmds.charAt(0);
				
				if (cmd == 'L') {
					if (iter.hasPrevious()) {
						iter.previous();
					}
				} else if(cmd == 'D') {
					if (iter.hasNext()) {
						iter.next();
					}
				} else if (cmd == 'B') {
					if (iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				}
			}
		}
		
		for(Character chr : list) {
			bw.write(chr);
		}
		
		bw.flush();
	}
}

/*
 * 
 * 아래와 같은 방법으로 풀면, LinkedList 에서 현재의 cursor 위치를 지속적으로 찾아가야 한다.
 * 당연히, 최악의 경우 100,000 * 500,000 라서 시간초과다.
 * 구글링 결과 ListIterator Interface 를 사용하면 효과적으로 cursor를 원소와 원소 사이에 표현할 수 있다.
 * 
 * ListIterator Interface
 *     1. traverse the list in either direction
 *     2. modify the list during iteration
 *     3. obtain the iterator's current position in the list (by cursor)
 *         1. cursor position always lies 
 *            between the element that would be returned by a call to previous()
 *            and the element that would be returned by a call to next()
 *            
 * 용례
 *     1. previous() : 앞에 있는 원소를 반환하면서 커서를 앞으로 옮김
 *     2. next() : 뒤에 있는 원소를 반환하면서 커서를 뒤로 옮김
 *     3. remove() : previous() 나 remove() 로 가장 마지막에 반환된 원소를 제거
 *     
 * public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Character> list = new LinkedList<>();
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			list.add(input.charAt(i));
		}
		
		int m = Integer.parseInt(br.readLine());
		String cmds;
		char cmd;
		char inputChar;
		int cursor = input.length();
		
		for (int i = 0; i < m; i++) {
			cmds = br.readLine();
			if (cmds.charAt(0) == 'P') {
				inputChar = cmds.charAt(2);
				list.add(cursor, inputChar);
				cursor++;
			} else {
				cmd = cmds.charAt(0);
				if (cmd == 'L') {
					if (cursor != 0){
						cursor--;
					}
				} else if(cmd == 'D') {
					if (cursor != list.size()) {
						cursor++;
					}
				} else if (cmd == 'B') {
					if (cursor != 0) {
						list.remove(--cursor);
					}
				}
				
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
    }
}
*/