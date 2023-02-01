package recursion;

import java.util.HashMap;

public class Bk_호텔방배정 {

	// 방 정보 저장
	static HashMap<Long, Long> map = new HashMap<Long, Long>();

	// 빈 방을 찾는 메소드
	static long findRoom(long roomNum) {

		if (map.get(roomNum) == null) {
			map.put(roomNum, roomNum + 1); // key: 원하는 방번호, value : 실제 배정될 다음 빈 방 번호
			return roomNum;
		}

		// map.get(roomNum) 다음 방 번호 -> 비어있지 않으면, 찾을 때까지 다시 findRoom 호출
		long emptyRoom = findRoom(map.get(roomNum));
		map.put(roomNum, emptyRoom); // 틀린 정보 업데이트
		return emptyRoom;
	}

	static public long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];

		for (int i = 0; i < room_number.length; i++) {
			answer[i] = findRoom(room_number[i]);
		}

		return answer;
	}

}
