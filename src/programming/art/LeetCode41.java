package programming.art;
/**
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 类似于桶排序？
 * @author softsec
 *
 */
public class LeetCode41 {
	public static void main(String[]args){
		int[] nums={3,4,-1,1};
		firstMissingPositive(nums);
	}
	/**
	 * @param nums
	 * @return
	 */
	public static int firstMissingPositive(int[] nums) {
		int result=1;
		if(nums==null ||nums.length==0){
			return 1;
		}
		for(int i=0;i<nums.length;i++){
			while(nums[i] != i+1){
                // 是否需要交换
                if(nums[i] <= 0 || nums[i] > nums.length || nums[i] == i+1 || nums[i] ==nums[nums[i]-1]){
                    break;
                }//if
                // 交换
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }//while
        }//for
		// First Missing Positive
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }//if
        }//for
		return nums.length+1;
	}
	

}
