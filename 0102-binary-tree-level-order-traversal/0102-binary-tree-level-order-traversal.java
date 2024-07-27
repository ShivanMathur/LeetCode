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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> finalAns = new ArrayList<List<Integer>>();

        if(root == null) {
            return finalAns;
        }

        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> ans = new ArrayList<>();
            for(int i=0; i<level; i++){
                if(queue.peek().left != null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.add(queue.peek().right);
                }
                ans.add(queue.remove().val);
            }
            finalAns.add(ans);
        }
        return finalAns;
    }
}