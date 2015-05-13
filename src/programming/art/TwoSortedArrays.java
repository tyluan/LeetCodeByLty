package programming.art;

public class TwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums1 = {};
		int[] nums2 = { 1 };
		System.out.println(findMedianSortedArrays(nums1, nums2));

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result = 0;
		int[] nums = new int[nums1.length + nums2.length];
		int count = 0;
		int i = 0;
		int j = 0;
		while (j < nums2.length && i < nums1.length) {
			if (nums1[i] > nums2[j]) {
				nums[count] = nums2[j];
				count++;
				j++;
			} else {
				nums[count] = nums1[i];
				count++;
				i++;
			}
		}
		if(j<nums2.length){
			while(j<nums2.length){
				nums[count]=nums2[j];
				count++;
				j++;
			}
		}
		if(i<nums1.length){
			while(i<nums1.length){
				nums[count]=nums1[i];
				count++;
				i++;
			}
		}
		if ((nums1.length + nums2.length) % 2 == 1) {
			result = nums[(nums1.length + nums2.length - 1) / 2];
		} else {
			result = (double) (nums[(nums1.length + nums2.length) / 2] + nums[(nums1.length + nums2.length) / 2 - 1]) / 2;
		}
		return result;
	}

}
