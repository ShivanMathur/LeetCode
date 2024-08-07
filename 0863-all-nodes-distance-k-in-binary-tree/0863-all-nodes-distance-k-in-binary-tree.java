/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private void markParentChild(TreeNode root, Map<TreeNode, TreeNode> parentChildMap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode.left != null){
                parentChildMap.put(currentNode.left, currentNode);
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                parentChildMap.put(currentNode.right, currentNode);
                queue.add(currentNode.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentChildMap = new HashMap<>();

        // Mark the parent node of each child
        markParentChild(root, parentChildMap);

        int dist = 0;
        HashMap<TreeNode, Boolean> visited = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.put(target, true);

        while(!queue.isEmpty()){
            int size = queue.size();
            if(dist == k){
                break;
            }
            dist++;
            for(int i=0; i<size; i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null && visited.get(currentNode.left)==null){
                    queue.add(currentNode.left);
                    visited.put(currentNode.left, true);
                }
                if(currentNode.right != null && visited.get(currentNode.right)==null){
                    queue.add(currentNode.right);
                    visited.put(currentNode.right, true);
                }
                if(parentChildMap.get(currentNode)!=null && visited.get(parentChildMap.get(currentNode)) == null){
                    queue.add(parentChildMap.get(currentNode));
                    visited.put(parentChildMap.get(currentNode), true);
                }
            }
        }


        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        
        return ans;
    }
}