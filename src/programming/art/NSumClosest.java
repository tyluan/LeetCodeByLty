package programming.art;

import java.util.Arrays;

/**
 * 
 * @author softsec Given an array S of n integers, find three integers in S such
 *         that the sum is closest to a given number, target. Return the sum of
 *         the three integers. You may assume that each input would have exactly
 *         one solution. For example, given array S = {-1 2 1 -4}, and target =
 *         1.
 * 
 *         The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 * 
 */
public class NSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sums= {0,0,0};
		threeSumClosest(sums,1);

	}
//两个指针解决问题
	public static int threeSumClosest(int[] nums, int target) {
		int sum = 0;
		int min = Integer.MAX_VALUE;
		if (nums.length < 3 || nums == null) {
			return sum;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int k = i + 1;
			int j = nums.length - 1;
			while (k < j) {
				int ans = nums[i] + nums[j] + nums[k];
				int diff = Math.abs(target - ans);
				if (diff == 0) {
					return ans;
				} else if (diff < min) {
					min = diff;
					sum = ans;
				}
				if (ans <= target) {
					k++;
				} else {
					j--;
				}
			}

		}
		return sum;
	}

}
