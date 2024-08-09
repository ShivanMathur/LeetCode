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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> mapInoderIndex = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            mapInoderIndex.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length -1, inorder, 0, inorder.length-1, mapInoderIndex);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> mapInoderIndex){

        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootPosInorder = mapInoderIndex.get(root.val);

        int numsLeft = rootPosInorder - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, rootPosInorder, mapInoderIndex);

        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, rootPosInorder + 1, inEnd, mapInoderIndex);

        return root;
    }

}