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
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){

            // Check if the target value is less than the current node's value.
            // If so, move to the left subtree (values smaller than the current node).
            // Otherwise, move to the right subtree (values larger than the current node).
            root = val < root.val ? root.left : root.right;
        }

        // Return the node containing the target value,
        // if found; otherwise, return null.
        return root;
    }
}