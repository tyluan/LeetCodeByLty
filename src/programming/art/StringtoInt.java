package programming.art;

public class StringtoInt {
	static int MAX = Integer.MAX_VALUE;
	static int MIN = Integer.MIN_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringtoInt("-2147483647"));

	}

	public static int stringtoInt(String s) {
		int i = 0;
		int sign = 1;
		s.replace(" ", "");

		if (s.equals("") | s == null) {
			return 0;
		}
		int count = 0;
		if (s.charAt(0) == '-' || s.charAt(0) == '+') {
			count++;
			if (s.charAt(0) == '-') {
				sign = -1;
			}
		}
		while (count < s.length()) {
			int c = s.charAt(count) - '0';
			 if (sign > 0 && (i > MAX / 10 || (i == MAX / 10 && c > MAX % 10)))
		        {
		            i = MAX;
		            break;
		        }
		        else if (sign < 0 && (i >(-1)*(MIN / 10) || (i == (-1)*(MIN / 10) && c > (-1)*(MIN % 10))))
		        {
		            i = MIN;
		            break;
		        }
			i = i * 10 + c;
			count++;

		}

		return i*sign;
	}
}
