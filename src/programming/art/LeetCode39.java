package programming.art;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39 {
	public static void main(String[] args){
		int[] candidates={2,3,7};
		System.out.println(combinationSum(candidates, 7));
		
	}
	// NP 问题
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates.length == 0 || target < 0) {
			return result;
		}
		Arrays.sort(candidates);
		helper(candidates,0,target,new ArrayList<Integer>(),result);
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
//			if (i > 0 && candidates[i] == candidates[i - 1])
//				continue;
			item.add(candidates[i]);
			helper(candidates, i, target - candidates[i], item, res);
			item.remove(item.size() - 1);
		}
	}

}
