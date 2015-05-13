package programming.art;

/**
 * 
 * @author Administrator Given n non-negative integers a1, a2, ..., an, where
 *         each represents a point at coordinate (i, ai). n vertical lines are
 *         drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 *         Find two lines, which together with x-axis forms a container, such
 *         that the container contains the most water.
 * 
 *         Note: You may not slant the container
 * 
 */

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxArea(int[] height) {
		int max=0;
		if(height.length<2) return 0;
		int start=0;
		int end=height.length-1;
		while (start<end) {
		   int area=Math.min(height[start], height[end])*(end-start);
		   max=Math.max(area, max);
		   if(height[start]>height[end]){
			   end--;
		   }else{
			   start++;
		   }
			
		}
		return max;

	}

}
