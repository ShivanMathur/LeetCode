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
    public void reorderList(ListNode head) {
        /* Approach 1:
            i. Find the middle node using Slow and Fast Pointers.
            ii. Reverse the list from middle node.
            iii. Now, iterate from the first half of the linked list and connect the links.
            iv. Stop when reversed list last element points to null.

            TC: O(N)
            SC: Auxilary Space: O(1)
                Recursion Stack: O(N) {O(N/2)}
        */

        // Find Middle Node
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }

        ListNode middle = slow; 

        // Reverse the list from the middle node.
        ListNode reverseHead = reverse(middle);

        ListNode curr = head;

        while(reverseHead.next != null){
            ListNode curr_front = curr.next;
            curr.next = reverseHead;

            ListNode rev_front = reverseHead.next;
            reverseHead.next = curr_front;

            curr = curr_front;
            reverseHead = rev_front;
        }


    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead; 
    }
}