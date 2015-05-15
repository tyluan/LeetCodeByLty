package programming.art;

/**
 * 
 * @author luantingyuan Given a linked list, swap every two adjacent nodes and
 *         return its head.
 * 
 *         For example, Given 1->2->3->4, you should return the list as
 *         2->1->4->3.
 * 
 *         Your algorithm should use only constant space. You may not modify the
 *         values in the list, only nodes itself can be changed.
 */

public class SwapPairs {

	public static ListNode swapPairs(ListNode head) {
		ListNode result=new ListNode(0);
		result.next=head;
		ListNode cur=result;
		while(cur.next!=null&&cur.next.next!=null){
			ListNode first=cur.next;
			ListNode second=cur.next.next;
			first.next=second.next;
			cur.next=second;
			cur.next.next=first;
			cur=cur.next.next;
		}
		return result.next;
		
	}
	public static void main(String[] args){
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=null;
		swapPairs(l1);
	}
}
