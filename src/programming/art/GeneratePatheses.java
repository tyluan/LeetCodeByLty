package programming.art;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses. For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author Administrator
 * 
 */
public class GeneratePatheses {
	public static List<String> generateParenthesis1(int n) {
		List<String> result = new ArrayList<String>();
		if (n == 0) {
			return result;
		}
		int left = 0;
		int right = 0;
		String ans = "";
		while (left < n || right < n) {
			if (ans.equals("")) {
				ans = ans + "(";
				left++;
			} else if (ans.endsWith("(") && left + 1 < n) {
				// 两个分支
				// 还可以加左括号
				ans = ans + "(";
				left++;
				// 或者直接加右括号
				ans = ans + ")";
				right++;
			} else if (ans.endsWith("(") && left + 1 >= n) {
				ans = ans + ")";
				right++;
			} else if (ans.endsWith(")") && right + 1 < n) {
				// 加右括号
				ans = ans + ")";
				right++;
				// 加左括号
				ans = ans + "(";
				left++;
			} else if (ans.endsWith(")") && right + 1 >= n) {
				ans = ans + "(";
				left++;
			}
			if (ans.length() == 2 * n) {
				result.add(ans);
				ans = "";
			}
		}
		return result;
	}

	//(insert)tail；insert+tail=n-1
	public static  List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		if (n == 0) {
			result.add("");
			return result;
		}
		if (n == 1) {
			result.add("()");
			return result;
		}
		 for (int i = n - 1; i >= 0; i--) {
	            List<String> insertSub = generateParenthesis(i);
	            List<String> tailSub = generateParenthesis(n - 1 - i);
	            for (String insert : insertSub) {
	                for (String tail : tailSub) {
	                    result.add("(" + insert + ")" + tail);
	                }
	            }

	        }
		return result;
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

}
