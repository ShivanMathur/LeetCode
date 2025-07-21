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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /*
            TC: O(N)
            SC: O(N)
        */
        String rootPreOrderTraversal = preOrderTraversal(root);
        String subRootPreOrderTraversal = preOrderTraversal(subRoot);

        return rootPreOrderTraversal.contains(subRootPreOrderTraversal);
    }

    private String preOrderTraversal(TreeNode node){
        if(node == null){
            return "null";
        }

        StringBuilder sb = new StringBuilder("$");
        sb.append(preOrderTraversal(node.left));
        sb.append(preOrderTraversal(node.right));

        return sb.toString();
    }
}