package programming.art;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfNumber {
	static List<List<Integer>> result = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0 };
		System.out.println(threeSum(nums));

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3 || nums == null)
			return result;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			find(nums, i + 1, nums.length - 1, nums[i]);
		}
		return result;
	}

	public static void find(int[] num, int begin, int end, int target) {
		int l = begin;
		int r = end;
		while (l < r) {
			if (num[l] + num[r] + target == 0) {
				List<Integer> ans = new ArrayList<Integer>();
				ans.add(num[l]);
				ans.add(num[r]);
				ans.add(target);
				result.add(ans);
				l++;
				r--;
			} else if (num[l] + num[r] + target < 0) {
				l++;
			} else {
				r--;
			}
		}
	}

	public static List<List<Integer>> threeSum1(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;
	}
}
