package programming.art;

import com.sun.accessibility.internal.resources.accessibility;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author Administrator
 * 
 */
public class LeetCode27 {
	public static int removeElement(int[] nums, int val) {
		int count = nums.length;
		if (nums.length == 0) {
			return 0;
		}
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] == val && i < count) {
				nums[i] = nums[--count];
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 2, 3 };
		System.out.println(removeElement(nums, 1));

	}

}
