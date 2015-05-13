package programming.art;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BPTest {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BP bp=new BP(2,2,1);
		double[] trainData={1,1};
		double[] target ={1};
		bp.train(trainData, target);
		double[] trainData1={0,1};
		double[] target1 ={0};
		bp.train(trainData1, target1);
		double[] trainData2={1,0};
		double[] target2 ={0};
		bp.train(trainData2, target2);
		double[] trainData3={0,0};
		double[] target3 ={0};
		bp.train(trainData3, target3);
		bp.train(trainData, target);
		bp.train(trainData1, target1);
		bp.train(trainData2, target2);
		bp.train(trainData3, target3);
		double[] trainData4={0,0};
		System.out.println(bp.test(trainData4)[0]);
	}
	/*	BP bp = new BP(32, 15, 4);

		Random random = new Random();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i != 1000; i++) {
			int value = random.nextInt();
			list.add(value);
		}

		for (int i = 0; i != 200; i++) {
			for (int value : list) {
				double[] real = new double[4];
				if (value >= 0)
					if ((value & 1) == 1)
						real[0] = 1;
					else
						real[1] = 1;
				else if ((value & 1) == 1)
					real[2] = 1;
				else
					real[3] = 1;
				double[] binary = new double[32];
				int index = 31;
				do {
					binary[index--] = (value & 1);
					value >>>= 1;
				} while (value != 0);

				bp.train(binary, real);
			}
		}

		System.out.println("训练完毕，下面请输入一个任意数字，神经网络将自动判断它是正数还是复数，奇数还是偶数。");

		while (true) {
			byte[] input = new byte[10];
			System.in.read(input);
			Integer value = Integer.parseInt(new String(input).trim());
			int rawVal = value;
			double[] binary = new double[32];
			int index = 31;
			do {
				binary[index--] = (value & 1);
				value >>>= 1;
			} while (value != 0);

			double[] result = bp.test(binary);

			double max = -Integer.MIN_VALUE;
			int idx = -1;

			for (int i = 0; i != result.length; i++) {
				if (result[i] > max) {
					max = result[i];
					idx = i;
				}
			}

			switch (idx) {
			case 0:
				System.out.format("%d是一个正奇数\n", rawVal);
				break;
			case 1:
				System.out.format("%d是一个正偶数\n", rawVal);
				break;
			case 2:
				System.out.format("%d是一个负奇数\n", rawVal);
				break;
			case 3:
				System.out.format("%d是一个负偶数\n", rawVal);
				break;
			}
		}
	}*/
}
