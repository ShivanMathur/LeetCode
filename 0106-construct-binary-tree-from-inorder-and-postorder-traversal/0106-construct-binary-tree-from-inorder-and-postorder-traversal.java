/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> mapInorderIndex = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            mapInorderIndex.put(inorder[i], i);
        }

        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, mapInorderIndex);

        return root;
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
            HashMap<Integer, Integer> mapInorderIndex) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootPosInorder = mapInorderIndex.get(root.val);
        int numsLeft = rootPosInorder - inStart;

        root.left = buildTree(inorder, inStart, rootPosInorder - 1, postorder, postStart, postStart + numsLeft - 1,
                mapInorderIndex);
        root.right = buildTree(inorder, rootPosInorder + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1,
                mapInorderIndex);

        return root;
    }
}