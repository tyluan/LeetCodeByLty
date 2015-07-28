package programming.art;

/**
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * @author softsec
 * 
 */

public class LeetCode43 {
	public static void main(String[] args) {
		System.out.println(multiply("1", "1"));

	}

	public static String multiply(String num1, String num2) {
		String resultString = "";
		if ("0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
		int n1 = num1.length();
		int n2 = num2.length();
		int[] add = new int[n1 + n2];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				add[n1 + n2 - 2 - i - j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}
		int flag = 0;
		int[] result = new int[n1 + n2];
		for (int i = 0; i < n1 + n2; i++) {
			int num = add[i] + flag;
			result[i] = num % 10;
			flag = num / 10;
		}
		for (int i = n1 + n2 - 1; i >= 0; i--) {
			if (result[i] == 0 && i == n1 + n2 - 1) {
			} else {
				resultString += result[i] + "";
			}
		}
		return resultString;
	}

}
