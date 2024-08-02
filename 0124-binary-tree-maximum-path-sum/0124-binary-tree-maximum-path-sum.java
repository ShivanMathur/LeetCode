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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        maxPathSum(root, maxSum);
        return maxSum[0]; 
    }

    private int maxPathSum(TreeNode node, int[] maxSum){
        if(node == null){
            return 0;
        }

        int leftSum = Math.max(0, maxPathSum(node.left, maxSum));
        int rightSum = Math.max(0, maxPathSum(node.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + node.val);

        return node.val + Math.max(leftSum, rightSum);
    }
}