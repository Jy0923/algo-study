package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11286_절댓값힙 {
	
	static long[] queue = new long[1000000]; 
	static int n;
	static int lastIdx = 0;
	static int parentIdx, leftChildIdx, rightChildIdx, tmpIdx;
	
	static void put(long item) {
		queue[++lastIdx] = item;
		
		if(lastIdx > 1) {
			tmpIdx = lastIdx;
			
			while(true) {
				parentIdx = tmpIdx / 2; 
				
				swap(parentIdx, tmpIdx);
				
				if(parentIdx == 1) 
					break;
				
				tmpIdx = parentIdx;
			}
		}
	}
	
	static long pop() {
		// 큐가 비었으면 0 반환
		if(lastIdx == 0)
			return 0;
		// 큐가 안비었으면
		else {
			// 1. 루트노드 임시 저장 후 
			long tmp = queue[1]; // 루트노드 뺴기
			
			// 2. 루트노드에 마지막값 삽입해주고
			queue[1] = queue[lastIdx];
			queue[lastIdx--] = 0;
			
			// 3. 자식 둘 중 작은애랑 비교해서 스왑
			parentIdx = 1;
			
			// 끝까지 내려갈 때까지 비교해서 스왑
			while(true) {
				leftChildIdx = parentIdx * 2;
				rightChildIdx = parentIdx * 2 + 1;
				
				// 종료조건
				if(queue[leftChildIdx] == 0) break;
				
				// 왼쪽자식이 마지막 인덱스라면
				if(leftChildIdx == lastIdx) {
					swap(parentIdx, leftChildIdx);
					
					break;
				}
				
				// 왼쪽 자식 절댓값이 더 작으면 왼쪽애랑 비교
				if(Math.abs(queue[leftChildIdx]) < Math.abs(queue[rightChildIdx])) {
					swap(parentIdx, leftChildIdx);
					parentIdx = leftChildIdx;
				}
				// 오른쪽 자식 절댓값이 더 작으면 오른쪽애랑 비교
				else if(queue[rightChildIdx] != 0 && Math.abs(queue[leftChildIdx]) > Math.abs(queue[rightChildIdx])){
					swap(parentIdx, rightChildIdx);
					parentIdx = rightChildIdx;
				}
				// 왼쪽 오른쪽 절댓값이 같으면
				else if(Math.abs(queue[leftChildIdx]) == Math.abs(queue[rightChildIdx])) {
					// 둘 중 실제로 더 작은애랑 비교
					if(queue[leftChildIdx] < queue[rightChildIdx]) {
						swap(parentIdx, leftChildIdx);
						parentIdx = leftChildIdx;
					}
					else {
						swap(parentIdx, rightChildIdx);
						parentIdx = rightChildIdx;
					}
				}
			}
			
			return tmp;
		}
	}
	
	
	static void swap(int parentIdx, int childIdx) {
		long parent = queue[parentIdx];
		long child = queue[childIdx];
		
		// 절댓값 차이가 있을때
		if(Math.abs(parent) > Math.abs(child)) {
			queue[parentIdx] = child;
			queue[childIdx] = parent;
		}
		// 절댓값이 같을 때
		else if(Math.abs(parent) == Math.abs(child)) {
			queue[parentIdx] = Math.min(parent, child);
			queue[childIdx] = Math.max(parent, child);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<n; tc++) {
			long tmp = Long.parseLong(br.readLine());
			
			if(tmp != 0)
				put(tmp);
			else 
				sb.append(pop()).append("\n");
		}
		
		System.out.println(sb);
	}
}