package programming.art;

import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * @author Administrator
 * 
 */

public class LeetCode25 {

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode cur = head;
		int count = 0;
		while (cur != null && count != k) {
			cur = cur.next;
			count++;
		}
		if (count == k) {
			cur = reverseKGroup(cur, k);
			while (--count >= 0) {
				ListNode temp = head.next;
				head.next = cur;
				cur = head;
				head = temp;
			}
			head = cur;
		}
		return head;
	}

	public static ListNode wrongreverseKGroup(ListNode head, int k) {
		if (null == head || k == 0 || k == 1) {
			return head;
		}
		ListNode result = new ListNode(0);
		ListNode start = head;
		ListNode cur, newstart;
		int count = 0;
		cur = head;
		while (count < k - 1 && cur.next != null) {
			cur = cur.next;
			count++;
		}
		// 从 cur 到start逆序一下
		newstart = cur.next;
		if (newstart == null && count < k - 1) {
			return head;
		}
		cur.next = null;
		ListNode newListNode = wrongreverse(start);
		result.next = newListNode;
		while (null != newListNode.next) {
			newListNode = newListNode.next;
		}
		newListNode.next = newstart;
		return result.next;
	}

	private static ListNode wrongreverse(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		ListNode next;
		while (null != cur) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		// 将原链表的头节点的下一个节点置为null，再将反转后的头节点赋给head
		head.next = null;
		head = pre;
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = null;
		// l2.next = null;
		System.out.println(reverseKGroup(l1, 2).next.next.val);
	}
}
