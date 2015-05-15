package programming.art;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode result = new ListNode(0);
		ListNode cur=result;
		ListNode temp;
		Queue<ListNode> heap = new PriorityQueue<ListNode>(5000,new Comparator<ListNode>() {
			@Override
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});
		//把所有的链表的第一个元素加进来
		for(ListNode l0:lists){
			if(l0!=null){
				heap.offer(l0);
			}
		}
		//取最小的一个，然后把剩下的加进来
		while(!heap.isEmpty()){
			temp=heap.poll();
			cur.next=temp;
			cur=cur.next;
			if(temp.next!=null){
				heap.add(temp.next);
			}
		}
		return result.next;
	}

}
