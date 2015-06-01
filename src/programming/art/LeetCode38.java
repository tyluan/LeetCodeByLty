package programming.art;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * @author Administrator
 * 
 */
public class LeetCode38 {
	public static String countAndSay(int n) {
		String string = "1";
		for (int i = 1; i <n; i++) {
			string = count(string);
		}
		return string;

	}
	public static String count(String s) {
		if (s.length() == 0 || s == null) {
			return null;
		}
		String result = "";
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			int count = 0;
			int j = 0;
			for (j = i; j < s.length(); j++) {
				if (s.charAt(j) == ch)
					count++;
				else {
					i = j;
					result = result + count + ch;
					break;
				}
			}
			if (j == s.length()) {
				result = result + count + ch;
				return result;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
	}

}
