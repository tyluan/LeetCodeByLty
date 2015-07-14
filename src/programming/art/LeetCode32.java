package programming.art;

public class LeetCode32 {
	/**
	 * dp[s.length - 1] = 0; i从n - 2 -> 0逆向求dp[]，并记录其最大值。若s[i] ==
	 * '('，则在s中从i开始到s.length - 1计算dp[i]的值。这个计算分为两步，通过dp[i + 1]进行的（注意dp[i +
	 * 1]已经在上一步求解）： 在s中寻找从i + 1开始的有效括号匹配子串长度，即dp[i +
	 * 1]，跳过这段有效的括号子串，查看下一个字符，其下标为j = i + 1 + dp[i + 1]。若j没有越界，并且s[j] ==
	 * ‘)’，则s[i ... j]为有效括号匹配，dp[i] =dp[i + 1] + 2。 在求得了s[i ... j]的有效匹配长度之后，若j +
	 * 1没有越界，则dp[i]的值还要加上从j + 1开始的最长有效匹配，即dp[j + 1]。
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		int length = 0;
		int j;
		int n = s.length();
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 0;
		}

		for (int i = n - 2; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				j = i + 1 + dp[i + 1];
				if (j < n && s.charAt(j) == ')') {
					dp[i] = dp[i + 1] + 2;
					if (j + 1 < n) {
						dp[i] += dp[j + 1];
					}
				}
			}
			if (length < dp[i]) {
				length = dp[i];
			}
		}
		return length;
	}

}
