package programming.art;

import java.util.Arrays;

public class LeetCode31 {
	public static void main(String[] args){
		int[] nums={1,3,2};
		nextPermutation1(nums);
	}
	public static void nextPermutation1(int[] nums) {
		// 所有按照升序排列的序列最小，按照降序排列的序列最大
		// 找到最後一個升序位置
		int pos = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				pos = i - 1;
				break;
			}
		}
		// 如果不存在升序，需要全部逆序
		if (pos < 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		// 存在升序，找到pos之后最後一個比它大的位置,交換兩者位置
		for (int i = nums.length - 1; i > pos; i--) {
			if (nums[i] > nums[pos]) {
				int temp = nums[i];
				nums[i] = nums[pos];
				nums[pos] = temp;
				break;
			}
		}
		Arrays.sort(nums,pos+1,nums.length);

	}

	public static void reverse(int[] num, int begin, int end) {
		int l = begin, r = end;
		while (l < r) {
			int temp = num[l];
			num[l] = num[r];
			num[r] = temp;
			l++;
			r--;
		}
	}
}
