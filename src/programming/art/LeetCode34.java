package programming.art;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author softsec
 * 
 */
public class LeetCode34 {
	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 9 };
		System.out.println(searchRange(nums, 8));
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				// евевзѓгв
				int min = mid - 1, max = mid + 1;
				while (min >= 0 && nums[min] == target) {
					min--;
				}
				while (max <= nums.length - 1 && nums[max] == target) {
					max++;
				}
				result[0] = min + 1;
				result[1] = max - 1;
				return result;

			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return result;
	}

}
