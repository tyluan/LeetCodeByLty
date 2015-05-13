package programming.art;

public class AddTwoNumbers {
	/*
	 * You are given two linked lists representing two non-negative numbers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list.
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(2);
		ListNode ll1=new ListNode(4);
		l1.next=ll1;
		ListNode lll1=new ListNode(3);
		ll1.next=lll1;
		ListNode llll1=new ListNode(1);
		lll1.next=llll1;
		ListNode l2=new ListNode(5);
		ListNode ll2=new ListNode(6);
		l2.next=ll2;
		ListNode lll2=new ListNode(4);
		ll2.next=lll2;
		addTwoNumbers(l1,l2);

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode resultNode = new ListNode(0);
		ListNode p1 = resultNode;
		ListNode ll1 = l1;
		ListNode ll2 = l2;
		int value = 0;
		boolean flag = false;
		while (ll1 != null || ll2 != null) {
			if (ll1 != null && ll2 != null) {
				if (flag) {
					value = ll1.val + ll2.val + 1;
				} else {
					value = ll1.val + ll2.val;
				}
				if (value >= 10) {
					value = value - 10;
					flag = true;
				} else {
					flag = false;
				}
				resultNode.next = new ListNode(value);
				ll1 = ll1.next;
				ll2 = ll2.next;
			}
			else if(ll1 !=null){
				if(flag){
					value=ll1.val+1;
				}else{
					value=ll1.val;
				}
				if (value >= 10) {
					value = value - 10;
					flag = true;
				} else {
					flag = false;
				}
				resultNode.next = new ListNode(value);
				ll1=ll1.next;
			}
			else if(ll2 !=null){
				if(flag){
					value=ll2.val+1;
				}else{
					value=ll2.val;
				}
				if (value >= 10) {
					value = value - 10;
					flag = true;
				} else {
					flag = false;
				}
				resultNode.next = new ListNode(value);
				ll2=ll2.next;
			}
			resultNode=resultNode.next;
		}
		if (flag){
		    resultNode.next=new ListNode(1);
		}
		return p1.next;
	}

}
