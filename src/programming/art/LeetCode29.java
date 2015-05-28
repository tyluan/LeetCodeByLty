package programming.art;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 * @author Administrator
 * 
 */
public class LeetCode29 {
	public static int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		} else if (divisor == 1) {
			return dividend;
		} else if (divisor == -1) {
			return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;
		} else {
			boolean sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
			long ldividend = Math.abs((long) dividend);
			long ldivisor = Math.abs((long) divisor);
			int result = 0;
			for (int bit = Integer.SIZE - 1; bit >= 0 && ldividend >= ldivisor; --bit) {
				if (ldividend >= (ldivisor << bit)) {
					ldividend -= ldivisor << bit;
					result |= 1 << bit;
				}
			}
			return sign ? -result : result;
		}
	}

	public static void main(String[] args) {
		System.out.println(divide(38, 3));
	}
}
