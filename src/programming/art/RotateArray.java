package programming.art;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2 };
		rotate1(array, 1);

	}

	public static void rotate(int[] array, int k) {
		int p = k % array.length;
		rotateSolution(arrayJoin(rotateSolution(array, 0, array.length - 1 - p), rotateSolution(array, array.length - p, array.length - 1)), 0,
				array.length - 1);
	}

	private static int[] rotateSolution(int[] array, int from, int to) {
		int[] result = new int[to - from + 1];
		int i = 0;
		while (from <= to) {
			result[i] = array[to];
			to--;
			i++;
		}
		return result;
	}

	private static int[] arrayJoin(int[] arrayA, int[] arrayB) {
		int[] result = new int[arrayA.length + arrayB.length];
		int i = 0;
		while (i < arrayA.length) {
			result[i] = arrayA[i];
			i++;
		}
		while (i < arrayB.length + arrayA.length) {
			result[i] = arrayB[i - arrayA.length];
			i++;
		}
		return result;
	}

	public static void rotate1(int[] nums, int k) {
		int len = nums.length;
		k %= len;
		reverse(nums, 0, len - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, len - 1);
	}

	public static void reverse(int[] nums, int l, int r) {
		while (l <= r) {
			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
			l++;
			r--;
		}
	}
}
