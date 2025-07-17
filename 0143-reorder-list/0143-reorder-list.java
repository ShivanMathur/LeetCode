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

        */

        /* Approach 2
            i. Instead of using recursion stack space, create a auxilary space stack.
            ii. Compute the size of stack, k and iterate till half of it (k/2) and pop nodes.
            iii. Start from start of the LL and connect with the top node in the stack
        
            TC: O(N)
            SC: O(N) {Aux space}
        */

        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        // Store all the LL nodes in the stack
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        // Find the size of stack and pop only half of the nodes from stack
        int itr = stack.size() / 2;

        ListNode curr = head;
        
        while(itr > 0){
            ListNode topNode = stack.pop();
            ListNode front = curr.next;
            curr.next = topNode;
            topNode.next = front;
            curr = front;
            itr--;
        }

        curr.next = null;
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