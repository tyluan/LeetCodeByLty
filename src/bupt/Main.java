package bupt;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sin = new Scanner(new BufferedInputStream(System.in));
		int n;
		int count = 0;
		n = Integer.parseInt(sin.nextLine());
		//System.out.println(n);
		while (count < n) {
			int m = 0;
			m = Integer.parseInt(sin.nextLine());
			//System.out.println(m);
			int j = 0;
			int result = 0;
			while (j < m) {
				result = result + Integer.parseInt(sin.nextLine());
				j++;
			}
			if (result > 0) {
				System.out.println("You are smart!");
			} else {
				System.out.println("You are beautiful!");
			}

			count++;
		}
	}

}
