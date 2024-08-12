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
    /* Brute Force Solution: Reverse Post-Order Traversal 
    TC: O(N)
    SC: O(N)

    // Initialize a global variable 'prev' to keep track of the previously processed node.
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        
        
        if(root == null){
            return;
        }

        // Recursive call to flatten the right subtree
        flatten(root.right);

        // Recursive call to flatten the left subtree
        flatten(root.left);


        // At this point, both left and right subtrees are flattened, and 'prev' is pointing 
        // to the rightmost node in the flattened right subtree.

        // Set the right child of the current node to 'prev'.
        root.right = prev;

        // Set the left child of the current node to null.
        root.left = null;

        // Update 'prev' to the current node for the next iteration.
        prev = root;

    } */

    public void flatten(TreeNode root){
        /* Morris Preorder Traversal */
        
        TreeNode cur = root;

        while(cur != null){
            if(cur.left != null){
                TreeNode prev = cur.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}