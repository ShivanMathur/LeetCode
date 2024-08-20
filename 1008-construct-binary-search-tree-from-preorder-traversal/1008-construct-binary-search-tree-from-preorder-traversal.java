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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] numElements = new int[]{0};
        return bstFromPreorder(preorder, Integer.MAX_VALUE, numElements);
    }

    private TreeNode bstFromPreorder(int[] preorder, int bound, int[] numElements){
        if(numElements[0] == preorder.length || preorder[numElements[0]] > bound){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[numElements[0]++]);
        root.left = bstFromPreorder(preorder, root.val, numElements);
        root.right = bstFromPreorder(preorder, bound, numElements);

        return root;
    }
}