package programming.art;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 * 
 * @author Administrator
 * 
 */
public class LeetCode26 {
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int count = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
				} else if (nums[j] > nums[i]) {
					nums[i + 1] = nums[j];
					break;
				}
			}
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] > nums[i]) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
	public static int removeDuplicates1(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int tmp = nums[0];
        int length = 1;
        for(int i = 1; i < nums.length; i++){
            if(tmp != nums[i]){
                tmp = nums[i];
                nums[length] = nums[i];
                length++;
            }
        }
        return length;
    }

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3 };
		System.out.println(removeDuplicates1(nums));

	}
}
