package programming.art;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		int shortestLength = Integer.MAX_VALUE;
		String shortestString = "";
		if (strs.length == 0) {
			return shortestString;
		}
		for (String str : strs) {
			if (str.length() < shortestLength) {
				shortestLength = str.length();
				shortestString = str;
			}
		}
		// find the shortestString then compare with it
		for (String str : strs) {
			for (int i = 0; i < shortestLength; i++) {
				if (str.charAt(i) == shortestString.charAt(i)) {
				} else {
					shortestString = shortestString.substring(0, i);
					shortestLength = i;
					break;
				}
			}
		}
		return shortestString;

	}

	public String longestCommonPrefix1(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		String pre = strs[0];
		int i = 1;
		while (i < strs.length) {
			while (strs[i].indexOf(pre) != 0)

				pre = pre.substring(0, pre.length() - 1);

			i++;

		}

		return pre;

	}

}
