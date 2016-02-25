public class PartitionList {
	public ListNode partition(ListNode head, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		// create a dummy head
		ListNode dummy = new ListNode(n-1);
		dummy.next = head;
		// find the "last" one that smaller than n
		ListNode small = dummy;
		while(small.next != null && small.next.val < n) {
			small = small.next;
		}
		ListNode large = small.next;		
		if (large == null) {
			return head;
		}
		// traverse the second part
		ListNode tmp = small;
		while (tmp.next != null) {
			if (tmp.next.val >= n) {
				tmp = tmp.next;
			} else {
				small.next = tmp.next;
				small = small.next;
				
				tmp.next = tmp.next.next;
				small.next = large;
			}
		}
		
		return dummy.next;
	}
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }