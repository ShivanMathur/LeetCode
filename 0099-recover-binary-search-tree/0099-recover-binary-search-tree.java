/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        first = middle = last = null;

        inorder(root);

        // Swap the violated nodes if they are non-adjacent in the inorder traversal
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        // Swap the violated nodes if they are adjacent in the inorder traversal
        else if(first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorder(TreeNode node){
        if(node == null){
            return;
        }
        
        inorder(node.left);

        if(prev != null && prev.val > node.val){
            // Found Violation

            // Check if it's first violation.
            // Mark the prev node as first and the current node as middle
            if(first == null){
                first = prev;
                middle = node;
            }

            // If this is 2nd violation, mark this node as last
            else{
                last = node;
            }
        }

        // Mark the current node as prev
        prev = node;
        inorder(node.right);
    }
}