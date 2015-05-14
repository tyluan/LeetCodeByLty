package programming.art;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode current = null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1 == null && l2 == null)
			return null;
		if (temp1.val < temp2.val) {
			result.next = temp1;
			temp1 = temp1.next;
		} else {
			result.next = temp2;
			temp2 = temp2.next;
		}
		current = result.next;
		while (temp1 != null && temp2 != null) {
			if(temp1.val<=temp2.val){
				current.next=temp1;
				current=temp1;
				temp1=temp1.next;
			}else{
				current.next=temp2;
				current=temp2;
				temp2=temp2.next;	
			}
		}
		while(temp2!=null){
			current.next=temp2;
			current=temp2;
			temp2=temp2.next;
		}
		while(temp1!=null){
			current.next=temp1;
			current=temp1;
			temp1=temp1.next;
		}

		return result.next;

	}

}
