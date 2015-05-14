package programming.art;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<=0){
            return head;
        }
        ListNode first=head;
        ListNode second=head;
        ListNode pre=null;
        for(int i=0;i<n-1;i++){
        	first=first.next;	
        }
        while(first.next!=null){
        	pre=second;
        	second=second.next;
        	first=first.next;
        }
        //delete second
        if(pre==null){
        	head=head.next;
        } else{
        	pre.next=second.next;
        	
        }
        return head;
    }

}
