package programmers;
import java.util.Arrays;
import java.util.HashMap;

public class 호텔방배정4 {
    public static void main (String[] args) {
        long[] room_number = {1, 3, 4, 1, 3, 1};
        long k = 10;

        // roomNum에서 나온 숫자를 넣어줌
        for(int i=0; i<room_number.length; i++) {
            room_number[i] = roomNum(room_number[i]);
        }
        System.out.println(Arrays.toString(room_number));
    }
    
    // long 타입을 인덱스로 받으려고 맵을 썼음
    private static HashMap<Long, Long> map = new HashMap<>();
    
    private static long roomNum(long a) {
        
        // 해쉬맵에서 a를 키값으로 넣었을 때 value가 없으면 a를 키에 넣어주고 a+1을 밸류에 넣어줌
        // a를 리턴함
        if(map.get(a) == null) {
            map.put(a, a+1);
            return a;
            
        // map은 <key, value>로 짝지어져있는데, key를 넣으면 value가 나옴
        // value에 key+1을 넣어주면 map<key, key+1> 상태가 됨
            
        // 예를 들어, <1, 2>가 맵에 들어있다면, key에 1을 더해서 <2, ?>를 찾는 로직임
        // 근데 2에도 값이 있다면 <3, ?>를 찾아야하기 때문에 찾는 횟수가 1씩 계속 증가함.
        // 그렇기 때문에 1, 2, 3에 모두 방이 차있고 4가 빈 방이라면
        // 1을 입력받았을 때 <1, 4>가 나와서 4번 방으로 직행하면 찾는 횟수가 훨씬 줄어듦.
        
        // 그래서 재귀를 통해,
        // 1에 값이 있다면 map<1, 기존값>을 map<1, 빈 방>으로 바꾸려는거임!!
        // roomNum 함수의 경우, map에 키를 넣었을 때 빈 방이 나온다면, 그 key값을 리턴하고 
        // 아니면 key를 넣어 나오는 value(key+1)를 다시 넣어 다음 방을 검사하므로
        // 결국엔 빈 방을 찾고 그 빈 방의 값을 기존값과 바꾸는 것임
        } else {
            map.replace(a, roomNum(map.get(a)));
            return map.get(a);
        }
    }

}
/*
package programmers;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 호텔방배정 {
	
	static long[] answer;
	
	static Set<Long> rooms = new HashSet<>();
	
	public static long[] solution(long k, long[] room_number) {
		
		answer = new long[room_number.length];
		
		// answer의 인덱스용
		int idx = 0;
		
		// 1 ~ k까지 중복없이 Set에 저장 및 정렬
		for(long i=1; i<=k; i++) rooms.add(i);
		
		
		for(int i=0; i<room_number.length; i++) {
			
			if(rooms.contains(room_number[i])) {
				answer[idx++] = room_number[i];
				rooms.remove(room_number[i]);
				
			} else {
				room_number[i] += 1;
				solution(k, room_number);
			}
			
			// 종료조건
			if(answer[answer.length - 1] != 0) break;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		
		long[] arr = {1, 3, 4, 1, 3, 1};

		solution(10, arr);
		
		System.out.println(Arrays.toString(answer));
		
	}
}
*/