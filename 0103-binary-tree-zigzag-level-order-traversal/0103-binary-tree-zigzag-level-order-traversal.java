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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagTraversal = new ArrayList<>();

        if(root == null){
            return zigzagTraversal;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        
        boolean LeftToRight = true; // true: Left --> Right AND false: Right --> Left 
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> order = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                
                TreeNode node = queue.poll();
                order.add(node.val);

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(!LeftToRight){
                Collections.reverse(order);
            }
            LeftToRight = !LeftToRight;

            zigzagTraversal.add(order);
        }

        return zigzagTraversal;
    }
}