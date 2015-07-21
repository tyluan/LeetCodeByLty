package programming.art;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {
	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		System.out.println(combinationSum2(candidates, 8));
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates.length == 0 || target < 0) {
			return result;
		}
		Arrays.sort(candidates);
		helper(candidates, 0, target, new ArrayList<Integer>(), result);
		return result;
	}

	private static void helper(int[] candidates, int start, int target, ArrayList<Integer> item, List<List<Integer>> res) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				item.add(candidates[i]);
				helper(candidates, i + 1, target - candidates[i], item, res);
				item.remove(item.size() - 1);
				while (i < (candidates.length - 1) && candidates[i] == candidates[i + 1]) {
					i++;
				}

			}
		}
	}

}
