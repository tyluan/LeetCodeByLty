package programming.art;

public class IntegerToRoman {

	public static void main(String[] args) {

	}

	public String intToRoman(int num) {
		String romanString = "";
		String[] thousand = { "", "M", "MM", "MMM" };
		String[] hundred = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] ten = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] one = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		romanString = thousand[num / 1000] + hundred[num / 100 % 10] + ten[num / 10 % 10] + one[num % 10];
		return romanString;
	}

}
