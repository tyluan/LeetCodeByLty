package Hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 列变位法是古典密码算法中变位加密的一种方法，具体过程如下
 * 将明文字符分割成个数固定的分组（如5个一组，5即为密钥），按一组一行的次序整齐排列，最后不足一组不放置任何字符，完成后按列读取即成密文。
 * 
 * @author Administrator
 * 
 */
public class Problem1002 {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		List<String> result = new ArrayList<String>();
		int number = Integer.parseInt(sin.nextLine());
		for (int count = 1; count <= number; count++) {
			String string = sin.nextLine();
			int k = Integer.parseInt(sin.nextLine());
			result.add("Case #" + count + ":");
			result.add(encrypt(string, k));
		}
		for (String res : result) {
			System.out.println(res);
		}
	}

	public static void main1(String[] args) {
		// System.out.println(encrypt("Hw doeetrrlloellc adoomm!,my  e w", 7));
		// System.out.println(encrypt("159263748", 4));
		// System.out.println(encrypt("sokaisan", 1));
		System.out.println(encrypt("Toodming is best", 16));

	}

	private static String encrypt(String s, int k) {
		String result = "";
		if (k == 1 || s.length() == k) {
			return s;
		}
		int number = s.length() / k;
		int mod = s.length() % k;
		for (int i = 0; i < number + 1; i++) {
			for (int j = 0; j < k; j++) {
				if (i < number) {
					result += s.charAt(j * number + i + Math.min(j, mod));
				} else if (j < mod && i==number ) {
					result += s.charAt((j + 1) * number + j);
				} else {
					return result;
				}
			}
		}
		return result;
	}
}
