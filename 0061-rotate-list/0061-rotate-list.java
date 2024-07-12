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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k <=0){
            return head;
        }

        ListNode ptr = head;
        int len = 1;
        for(; ptr.next!=null; ptr=ptr.next){
            len++;
        }

        k = k%len;
        if(k == 0){
            return head;
        }

        int rotationCount = 0;
        
        ptr.next = head;
        while(rotationCount != (len - k)){
            ptr = ptr.next;
            rotationCount++;
        }
        
        head = ptr.next;
        ptr.next = null;

        return head;
    }
}