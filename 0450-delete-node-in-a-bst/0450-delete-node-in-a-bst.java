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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(root.val == key){
            return deletionHelper(root);
        }

        TreeNode cur = root;
        while(cur != null){
            if(cur.val > key){
                if(cur.left != null && cur.left.val == key){
                    cur.left = deletionHelper(cur.left);
                    break;
                }
                else{
                    cur = cur.left;
                }
            }
            else{
                if(cur.right != null && cur.right.val == key){
                    cur.right = deletionHelper(cur.right);
                    break;
                }
                else{
                    cur = cur.right;
                }
            }
        }

        return root;
    }

    private TreeNode deletionHelper(TreeNode node){
        if(node.left == null){
            return node.right;
        }
        if(node.right == null){
            return node.left;
        }

        TreeNode rightChild = node.right;
        TreeNode lastRightChild = findLastRightNode(node.left);
        lastRightChild.right = rightChild;
        
        return node.left;
    }

    private TreeNode findLastRightNode(TreeNode node){
        while(node.right != null){
            node = node.right;
        }

        return node;
    }
}