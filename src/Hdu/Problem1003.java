package Hdu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Problem1003 {

	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		List<String> result = new ArrayList<String>();
		int number = Integer.parseInt(sin.nextLine());
		for (int count = 1; count <= number; count++) {
			List<String> ipList = new ArrayList<String>();
			List<String> subnetList = new ArrayList<String>();
			String string = sin.nextLine();
			int m = Integer.parseInt(string.split(" ")[0]);
			int n = Integer.parseInt(string.split(" ")[1]);
			for (int i = 0; i < m; i++) {
				ipList.add(sin.nextLine());
			}
			for (int j = 0; j < n; j++) {
				subnetList.add(sin.nextLine());
			}
			result.add("Case #" + count + ":");
			for(String subnet:subnetList){
				result.add(checkNetWork(ipList, subnet));
			}

		}
		for (String res : result) {
			System.out.println(res);
		}

	}
	static private String checkNetWork(List<String> ipList, String subnet1) {
		String result = "";
		Set<Integer> count = new HashSet<Integer>();
		String[] subnets = subnet1.split("\\.");
		int sub = (Integer.parseInt(subnets[0]) << 24) | (Integer.parseInt(subnets[1]) << 16) | (Integer.parseInt(subnets[2]) << 8)| Integer.parseInt(subnets[3]);
		for (String ip : ipList) {
			String[] ips = ip.split("\\.");
			int aip = (Integer.parseInt(ips[0]) << 24) | (Integer.parseInt(ips[1]) << 16) | (Integer.parseInt(ips[2]) << 8)| Integer.parseInt(ips[3]);
			count.add(aip & sub);
		}
		result = result + count.size();
		return result;

	}
	public static void main1(String[] args) {
		List<String> ipList = new ArrayList<String>();
		List<String> subnetList = new ArrayList<String>();
		ipList.add("192.168.1.0");
		ipList.add("192.168.1.101");
		ipList.add("192.168.2.5");
		ipList.add("192.168.2.7");
		ipList.add("202.14.27.235");
		subnetList.add("255.255.255.0");
		subnetList.add("255.255.0.0");
	//	System.out.println(checkNetWork(ipList, subnetList));

	}
}
