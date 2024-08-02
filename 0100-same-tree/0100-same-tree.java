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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return (p == q);
        }

        // Perform Pre-Order Traversal (or any Traversal: In-Order, Pre-Order, Post-Order) to check if the trees are identical
        return (p.val == q.val) && (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right));
    }
}