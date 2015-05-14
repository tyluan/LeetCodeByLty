package programming.art;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length < 4) {
			return result;
		}
		HashMap<Integer, List<Integer[]>> hashMap = new HashMap<Integer, List<Integer[]>>();
		Arrays.sort(nums);
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int sum = nums[i] + nums[j];
				Integer[] element = { nums[i], i, nums[j], j };
				if (hashMap.containsKey(sum)) {
					hashMap.get(sum).add(element);
				} else {
					hashMap.put(sum, new ArrayList<Integer[]>());
					hashMap.get(sum).add(element);
				}
			}
		}
		Integer[] keySet = hashMap.keySet().toArray(new Integer[hashMap.size()]);
		for (int num : keySet) {
			if (hashMap.containsKey(target - num)) {
				// same then combination
				List<Integer[]> num1 = hashMap.get(num);
				List<Integer[]> num2 = hashMap.get(target - num);
				for (Integer[] temp1 : num1) {
					for (Integer[] temp2 : num2) {
						if (temp1[1] != temp2[1] && temp1[1] != temp2[3] && temp1[3] != temp2[1] && temp1[3] != temp2[3]) {
							List<Integer> ans = Arrays.asList(temp1[0], temp1[2], temp2[0], temp2[2]);
							Collections.sort(ans);
							if (!result.contains(ans)) {
								result.add(ans);
							}
						}
					}
				}
			}
			hashMap.remove(num);
			hashMap.remove(target - num);
		}

		return result;

	}

	public static void main(String[] args) {
		int[] nums = { 2, -1, 0, 1 };
		fourSum(nums, 2);

	}

}
