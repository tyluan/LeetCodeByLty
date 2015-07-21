package programming.art;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. [1,3,5,6], 5 ¡ú 2 [1,3,5,6], 2 ¡ú 1 [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 * 
 * @author softsec
 * 
 */
public class LeetCode35 {
	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums, 4));
	}

	public static int searchInsert(int[] nums, int target) {
		int result = -1;
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				result = mid;
				return result;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		result = left;
		return result;
	}

}
