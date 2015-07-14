package programming.art;

public class LeetCode32 {
	/**
	 * dp[s.length - 1] = 0; i��n - 2 -> 0������dp[]������¼�����ֵ����s[i] ==
	 * '('������s�д�i��ʼ��s.length - 1����dp[i]��ֵ����������Ϊ������ͨ��dp[i + 1]���еģ�ע��dp[i +
	 * 1]�Ѿ�����һ����⣩�� ��s��Ѱ�Ҵ�i + 1��ʼ����Ч����ƥ���Ӵ����ȣ���dp[i +
	 * 1]�����������Ч�������Ӵ����鿴��һ���ַ������±�Ϊj = i + 1 + dp[i + 1]����jû��Խ�磬����s[j] ==
	 * ��)������s[i ... j]Ϊ��Ч����ƥ�䣬dp[i] =dp[i + 1] + 2�� �������s[i ... j]����Чƥ�䳤��֮����j +
	 * 1û��Խ�磬��dp[i]��ֵ��Ҫ���ϴ�j + 1��ʼ�����Чƥ�䣬��dp[j + 1]��
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
