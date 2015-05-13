package programming.art;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstring {

	public static void main(String args[]) {
		String s = "abcdeeefgh";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {
		int count = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			if (!map.containsKey(now)) {
				map.put(now, i);
			} else {
				count = Math.max(count, map.size());
				i = map.get(now);
				System.out.println(i);
				map.clear();
			}
		}

		return Math.max(count, map.size());

	}

	public static int lengthOfLongestSubString1(String s) {
		if (s == null && s.length() == 0) {
			return 0;
		}
		int max = 0;
		int begin = 0;
		int runner = 0;
		HashSet<Character> set = new HashSet<Character>();
		while (runner < s.length()) {
			char now = s.charAt(runner);
			if(!set.contains(now)){
				set.add(now);
			}else{
				if(max<runner-begin){
				   max=runner-begin;
				}
				while(s.charAt(begin)!=s.charAt(runner)){
					set.remove(s.charAt(begin));
					begin++;
				}
				begin++;
				
			}
			runner++;
		}
		max=Math.max(max, runner-begin);
		return max;
	}
}
