/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        ListNode head = lists[0];

        for(int i=1; i<lists.length; i++){
            head = mergeTwoLists(head, lists[i]);
        }

        return head;
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2){
        ListNode t1 = head1;
        ListNode t2 = head2;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(t1 != null && t2 != null){
            if(t1.val <= t2.val){
                curr.next = t1;
                curr = t1;
                t1 = t1.next;
            }
            else{
                curr.next = t2;
                curr = t2;
                t2 = t2.next;
            }
        }

        if(t1 != null){
            curr.next = t1;
        }
        if(t2 != null){
            curr.next = t2;
        }

        return dummy.next;
    }
}