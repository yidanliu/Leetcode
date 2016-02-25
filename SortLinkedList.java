public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        return sortHelper(head);
    }
    
    public ListNode sortHelper(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	if (head.next.next == null) {
    		if (head.val <= head.next.val) {
    			return head;
    		} else {
    			ListNode new_head = head.next;
    			head.next.next = head;
    			head.next = null;
    			return new_head;
    		}
    	}
    	ListNode first_part = head;
    	ListNode second_part = head.next;
    	while(second_part.next != null && second_part.next.next != null) {
    		first_part = first_part.next;
    		second_part = second_part.next.next;
    	}
    	// split
    	second_part = first_part.next;
    	first_part.next = null;
    	// split sort
    	ListNode left = sortHelper(head);
    	ListNode right = sortHelper(second_part);
    	// merge
    	ListNode dummy = new ListNode(0), cur = dummy;
    	while (left != null && right != null) {
    		if (left.val <= right.val) {
    			cur.next = left;
    			left = left.next;
    		} else {
    			cur.next = right;
    			right = right.next;
    		}
    		cur = cur.next;
    	}
    	// this step is important
    	if (left != null) {
    	    cur.next = left;
    	} else if (right != null) {
    	    cur.next = right;
    	}
    	return dummy.next;
    	
    }
}