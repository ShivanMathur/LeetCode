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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[]{0};
        int[] kthSmallest = new int[]{Integer.MIN_VALUE};

        morrisInorderTraversal(root, k, count, kthSmallest);

        return kthSmallest[0];
    }

    private void morrisInorderTraversal(TreeNode root, int k, int[] count, int[] kthSmallest){
        if(root == null || count[0] >= k){
            return;
        }

        morrisInorderTraversal(root.left, k, count, kthSmallest);

        count[0]++;

        if(count[0] == k){
            kthSmallest[0] = root.val;
            return;
        }

        morrisInorderTraversal(root.right, k, count, kthSmallest);
    }
}