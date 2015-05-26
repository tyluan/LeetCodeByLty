package Hdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HavaMeal {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		List<Integer>list=new ArrayList<Integer>();
		while (sin.hasNext()) {
			int x = sin.nextInt();
			int y = sin.nextInt();
			if(x<1||y>100){
				return;
			}
			int z = y % x - 1;
			if (z >= 0) {
				list.add(z);
			} else {
				list.add(z+x);
			}
		}
		for(int i:list){
			System.out.println(i);
		}
	}

}
