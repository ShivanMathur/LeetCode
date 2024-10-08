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
    public boolean isValidBST(TreeNode root) {

        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validateBST(TreeNode root, long minRange, long maxRange){
        if(root == null){
            return true;
        }

        if(minRange < root.val && root.val < maxRange){
            
            return validateBST(root.left, minRange, root.val) && validateBST(root.right, root.val, maxRange);
        }

        return false;
    }
}