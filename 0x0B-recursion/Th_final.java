import java.util.*;

class Solution {
    static Map<Long, Long> hm = new HashMap<>(); // 현재방 : 다음 비어있는 방
    static long[] answer; // 정답 배열
    static int idx = 0;

    public long[] solution(long k, long[] room_number) {
        answer = new long[room_number.length];

        for(int i=0; i<room_number.length; i++)
            find(room_number[i]);

        return answer;
    }

    private long find(long room) {
    	//현재방이 비어있다면
        if(!hm.containsKey(room)) {
            hm.put(room, room+1); // 맵에 추가
            answer[idx++] = room;
            return room+1; // 다음 비어있는 방 return
        }

		// 현재방 : 다음 비어있는 방 갱신
        hm.put(room, find(hm.get(room)));
        return hm.get(room);
    }
}