package B;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		while (sin.hasNext()) {
			long x = 0;
			long y = 0;
			int count = 0;
			try {
				count = Integer.parseInt(sin.nextLine());
				int i = 0;
				while (i < count) {
					try {
						String string = sin.nextLine();
						String direction = string.split(" ")[0];
						long distance = Long.parseLong(string.split(" ")[1]);
						if (distance > 0 && direction.toUpperCase().equals("S") || direction.toUpperCase().equals("SOUTH")) {
							y = y - distance;
						} else if (distance > 0 && direction.toUpperCase().equals("N") || direction.toUpperCase().equals("NORTH")) {
							y = y + distance;
						} else if (distance > 0 && direction.toUpperCase().equals("W") || direction.toUpperCase().equals("WEST")) {
							x = x - distance;
						} else if (distance > 0 && direction.toUpperCase().equals("E") || direction.toUpperCase().equals("EAST")) {
							x = x + distance;
						}
					} catch (Exception e) {
						System.out.println(x + " " + y);
					}
					i++;
				}
				System.out.println(x + " " + y);
			} catch (Exception e) {
				System.out.println(x + " " + y);
			}
		}
	}
}
