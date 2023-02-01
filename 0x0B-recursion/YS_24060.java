import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int right = sc.nextInt();
	static int num = sc.nextInt();

	static int cnt = 0;

	public static void sort(int[] array, int left, int right) {
		mergeSort(array, left, right);
	}

	public static void mergeSort(int[] array, int left, int right) {
		int mid = 0;
		if (left < right) {

			mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);

		}
	}

	private static void merge(int[] array, int left, int mid, int right) {
		int leftIdx = left;
		int rightIdx = mid + 1;
		int sortedIdx = left;

		int[] tmpSortedArray = new int[right + 1];

		while (leftIdx <= mid && rightIdx <= right) {
			if (array[leftIdx] <= array[rightIdx]) {
				tmpSortedArray[sortedIdx++] = array[leftIdx++];
			} else {
				tmpSortedArray[sortedIdx++] = array[rightIdx++];
			}
		}

		if (leftIdx > mid) {
			for (int i = rightIdx; i <= right; i++) {
				tmpSortedArray[sortedIdx++] = array[i];
			}
		} else {
			for (int i = leftIdx; i <= mid; i++) {
				tmpSortedArray[sortedIdx++] = array[i];
			}

		}

		for (int i = left; i <= right; i++) {

			array[i] = tmpSortedArray[i];
			cnt++;
			if (cnt == num) {
				System.out.println(array[i]);
				break;
			}
		}

	}

	public static void main(String[] args) {
		int[] array = new int[right];
		for (int i = 0; i < right; i++) {
			array[i] = sc.nextInt();
		}
		sort(array, 0, right - 1);
		if (cnt < num) {
			System.out.println(-1);
		}
	}
}

// 아직 시간 안에 돌아가도록 만드는 건 어려워서 구현만 겨우 했습니다.