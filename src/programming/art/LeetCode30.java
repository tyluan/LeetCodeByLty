package programming.art;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters. For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author Administrator
 * 
 */
public class LeetCode30 {
	private static List<String> combinationList = new ArrayList<String>();

	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < words.length - 1; i++) {
			if(!s.contains(s)){
				return result;
			}
		}
		concatenation(words, 0, words.length - 1);
		for (String string : combinationList) {
			int number = s.indexOf(string);
			if (number != -1) {
				result.add(number);
			}
		}
		return result;
	}

	private static void concatenation(String[] buf, int start, int end) {
		String rawResult = "";
		if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
			for (int i = 0; i <= end; i++) {
				rawResult += buf[i];
			}
			combinationList.add(rawResult);
		} else {// 多个字母全排列
			for (int i = start; i <= end; i++) {
				String temp = buf[start];// 交换数组第一个元素与后续的元素
				buf[start] = buf[i];
				buf[i] = temp;
				concatenation(buf, start + 1, end);// 后续元素递归全排列
				temp = buf[start];// 将交换后的数组还原
				buf[start] = buf[i];
				buf[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		String[] mmStrings = { "ab", "bc", "cd" };
		concatenation(mmStrings, 0, 2);
		System.out.println(combinationList);
	}

}
