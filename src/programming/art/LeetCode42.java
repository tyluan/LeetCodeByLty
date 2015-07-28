package programming.art;

public class LeetCode42 {
	public int trap(int[] height) {
		if (height.length <= 2)
			return 0;
		int max = -1;
		int maxInd = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
				maxInd = i;
			}
		}
		int area = 0, root = height[0];
		for (int i = 0; i < maxInd; i++) {
			if (root < height[i])
				root = height[i];
			else
				area += root - height[i];
		}
		root = height[height.length - 1];
		for (int i = height.length - 1; i > maxInd; i--) {
			if (root < height[i])
				root = height[i];
			else
				area += root - height[i];
		}
		return area;
	}

}
