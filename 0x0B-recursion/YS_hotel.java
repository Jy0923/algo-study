import java.util.HashMap;

class Solution {
    // 해쉬맵 선언
    HashMap<Long, Long> map = new HashMap<>();
        public long[] solution(long k, long[] room_number) {
            long[] answer = new long[room_number.length];

            // 순회하면서 findEmptyRoom 메소드 호출
            for(int i = 0; i < room_number.length; i++){
                answer[i] = findEmptyRoom(room_number[i]);
            }
            return answer;
        }

        // containskey 메소드로 해당 키값이 이미 배정되어 있는지 확인
        // 만약 배정되어있지 않다면 request 값을 key로, request+1을 value로
        // request+1을 value로 지정하는 이유는 그 다음방을 찾아가게 만들기 위함
        long findEmptyRoom(long request){
            if(!map.containsKey(request)){
                map.put(request, request+1);
                return request;
            }

            // 이미 키값이 배정된 경우 next_room을 request의 value 값으로 저장
            // next_room부터 다시 검색 시작
            // request 값을 key로, 찾은 빈 방을 value로 저장하고 empty_room을 리턴
            long next_room = map.get(request);
            long empty_room = findEmptyRood(next_room);
            map.put(request, empty_room); // ???
            return empty_room;
        }
}
// 코드는 블로그에서 그대로 가져왔습니다. 
// map.put(request, empty_room) 이 부분 이해가 잘 안되는게 4번 손님이 1번방을 선택한 경우(중복이 발생한 경우) key = 1, value = 2로 키값이 중복되지 않는지,,,