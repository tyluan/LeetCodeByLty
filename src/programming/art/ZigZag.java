package programming.art;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class ZigZag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String convert(String s, int nRows) {
		String result = "";
		if (s == null || s.length() <= nRows || nRows <= 1) {
			return s;
		}

		// first
		for (int i = 0; i < s.length(); i += (2 * nRows - 2)) {
			result += s.charAt(i);
		}
		//
		for (int j = 1; j < nRows - 1; j++) {
			for (int c = j; c < s.length(); c += 2*(nRows - j - 1)) {
				result += s.charAt(j);
				if (c + (nRows - 1) * 2 < s.length()) {
					result += (s.charAt(c + (nRows - 1) * 2));
				}
			}
		}
		// last
		for (int i = nRows - 1; i < s.length(); i += (2 * nRows - 2)) {
			result += s.charAt(i);
		}
		return result;
	}
}
