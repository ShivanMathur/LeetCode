/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        // Check where the nodes p and q lie
        
        // If root is greater than both the nodes, search in the left sub-tree
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        // Else if root is smaller than both the node, search in the right sub-tree
        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        // If the root is equal to any of the TreeNode p or q, return root
        // Also, if there is a split in path, i.e., 
            // one of node lies on left side and another on right side, return root
        
        return root;
        
    }
}