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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /* APPROACH 1 
        ListNode head = new ListNode(0), curr = head;
        int carry = 0, temp = 0;
        
        while(l1 != null && l2 != null){
            temp = l1.val + l2.val + carry;
            curr.next = new ListNode(temp%10);
            carry = temp/10;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            temp = l1.val + carry;
            curr.next = new ListNode(temp%10);
            carry = temp/10;
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2 != null){
            temp = l2.val + carry;
            curr.next = new ListNode(temp%10);
            carry = temp/10;
            curr = curr.next;
            l2 = l2.next;
        }
        if (carry != 0){
            curr.next = new ListNode(carry);
        }
        return head.next;
        */

        /* APPROACH 2: Leetcode Editorial Solution */
        ListNode head = new ListNode(0), curr = head;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return head.next;
    }
}