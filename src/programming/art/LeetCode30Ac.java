package programming.art;

import java.util.ArrayList;
import java.util.HashMap;
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
public class LeetCode30Ac {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ret = new ArrayList<Integer>();
		int slen = s.length();
		int wlen = words.length;
		if (slen <= 0 || wlen <= 0) {
			return ret;
		}
		int len = words[0].length();
		// new map
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		for (String word : words) {
			if (wordMap.containsKey(word)) {
				wordMap.put(word, wordMap.get(word) + 1);
			} else {
				wordMap.put(word, 1);
			}
		}

		for (int i = 0; i < len; i++) {
			int left = i;
			int count = 0;
			HashMap<String, Integer> tMap = new HashMap<String, Integer>();
			for (int j = i; j <= slen - len; j += len) {
				String string = s.substring(j, j + len);
				if (wordMap.containsKey(string)) {
					if (tMap.containsKey(string)) {
						tMap.put(string, tMap.get(string) + 1);
					} else {
						tMap.put(string, 1);
					}
					if (tMap.get(string) <= wordMap.get(string)) {
						count++;
					} else {
						while (tMap.get(string) > wordMap.get(string)) {
							String tmpString = s.substring(left, left + len);
							if (tMap.containsKey(tmpString)) {
								tMap.put(tmpString, tMap.get(tmpString) - 1);
								if (tMap.get(tmpString) < wordMap.get(tmpString)) {
									count--;
								}
							}
							left += len;
						}
					}
					if (count == wlen) {
						ret.add(left);
						// it's better to push forward once
						String tmps = s.substring(left, left + len);
						if (tMap.containsKey(tmps))
							tMap.put(tmps, tMap.get(tmps) - 1);
						count--;
						left += len;
					}
				} else {
					// not any match word
					tMap.clear();
					count = 0;
					left = j + len;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		String[] words = { "a" };
		System.out.println(findSubstring("a", words));

	}
}
