import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long[] heap = new long[100005];
	static int size = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int j = Integer.parseInt(br.readLine());
			if (j == 0) {
				System.out.println(pop());
			} else {
				push(j);
			}
		}

	}

	static void push(long x) {
		heap[++size] = x;
		int index = size;
		while (index != 1) {
			int parent = size >> 1;
			if (Math.abs(heap[parent]) > Math.abs(heap[index])) {
				long temp = heap[parent];
				heap[parent] = heap[index];
				heap[index] = temp;
				index = parent;
			} else if (Math.abs(heap[parent]) == Math.abs(heap[index])) {
				if (heap[parent] > heap[index]) {
					long temp = heap[parent];
					heap[parent] = heap[index];
					heap[index] = temp;
					index = parent;
				} else {
					break;
				}

			} else if (Math.abs(heap[parent]) < Math.abs(heap[index])) {
				break;
			}

		}
	}

	static long pop() {
		if (size == 0) {
			return 0;
		}

		long result = heap[1];
		heap[1] = heap[size--];

		int index = 1;
		while (index * 2 <= size) {
			int leftChild = index * 2;
			int rightChild = (index * 2) + 1;
			int minChild = leftChild;
			if (rightChild <= size && Math.abs(heap[rightChild]) < Math.abs(heap[leftChild])) {
				minChild = rightChild;
			} else if (rightChild <= size && Math.abs(heap[rightChild]) == Math.abs(heap[leftChild])) {
				if (heap[rightChild] < heap[leftChild]) {
					minChild = rightChild;
				}

			}
			if (Math.abs(heap[index]) < Math.abs(heap[minChild]))
				break;
			if (Math.abs(heap[index]) == Math.abs(heap[minChild])) {
				if (heap[index] <= heap[minChild])
					break;
			}
			long tmp = heap[minChild];
			heap[minChild] = heap[index];
			heap[index] = tmp;
			index = minChild;
		}
		return result;
	}
}
// 틀림
