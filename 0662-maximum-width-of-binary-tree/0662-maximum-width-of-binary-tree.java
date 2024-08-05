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
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        if(root == null){
            return maxWidth;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()){
            int size = queue.size();
            int minIndex = queue.peek().index;
            int firstIndex = 0, lastIndex = 0;
            
            for(int i=0; i<size; i++){
                
                int currIndex = queue.peek().index - minIndex;
                if(i == 0){
                    firstIndex = currIndex;
                }
                if(i == size-1){
                    lastIndex = currIndex;
                }

                TreeNode node = queue.poll().node;

                if(node.left != null){
                    queue.add(new Pair(node.left, 2*currIndex + 1));
                }
                if(node.right != null){
                    queue.add(new Pair(node.right, 2*currIndex + 2));
                }
            }
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1); 
        }

        return maxWidth;
    }
}

class Pair{
    TreeNode node;
    int index;

    public Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}