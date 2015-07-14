package programming.art;

import java.util.Arrays;

public class LeetCode31 {
	public static void main(String[] args){
		int[] nums={1,3,2};
		nextPermutation1(nums);
	}
	public static void nextPermutation1(int[] nums) {
		// ���а����������е�������С�����ս������е��������
		// �ҵ�����һ������λ��
		int pos = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				pos = i - 1;
				break;
			}
		}
		// ���������������Ҫȫ������
		if (pos < 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		// ���������ҵ�pos֮������һ���������λ��,���Q����λ��
		for (int i = nums.length - 1; i > pos; i--) {
			if (nums[i] > nums[pos]) {
				int temp = nums[i];
				nums[i] = nums[pos];
				nums[pos] = temp;
				break;
			}
		}
		Arrays.sort(nums,pos+1,nums.length);

	}

	public static void reverse(int[] num, int begin, int end) {
		int l = begin, r = end;
		while (l < r) {
			int temp = num[l];
			num[l] = num[r];
			num[r] = temp;
			l++;
			r--;
		}
	}
}
