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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode newNode = new TreeNode(val);
        TreeNode node = root;

        while(true){
            if(node.val > val){
                if(node.left != null){
                    node = node.left;
                }
                else{
                    node.left = newNode;
                    break;
                }
            }
            else{
                if(node.right != null){
                    node = node.right;
                }
                else{
                    node.right = newNode;
                    break;
                }
            }
        }

        return root;
    }
}