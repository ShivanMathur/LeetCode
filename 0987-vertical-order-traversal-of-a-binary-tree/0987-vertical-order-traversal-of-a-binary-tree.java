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

class Tuple{
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        // Map to store nodes based on vertical and level information
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodes = new TreeMap<>();
        
        // Queue for BFS traversal,
        // for instering each node with respective row(x), column(y) values
        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(root, 0, 0));

        while(!queue.isEmpty()){
            
            // Retrieve the node and its vertical and level information 
            Tuple tuple = queue.poll();

            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!nodes.containsKey(x)){
                nodes.put(x, new TreeMap<>());
            }
            if(!nodes.get(x).containsKey(y)){
                nodes.get(x).put(y, new PriorityQueue<>());
            }

            // Insert node value into map inside PriorityQueue.
            nodes.get(x).get(y).add(node.val);

            if(node.left != null){
                queue.add(new Tuple(node.left, x-1, y+1));
            }
            if(node.right != null){
                queue.add(new Tuple(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> traversalOrder = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> yn : nodes.values()){
            traversalOrder.add(new ArrayList<>());

            for(PriorityQueue<Integer> node : yn.values()){
                while(!node.isEmpty()){
                    traversalOrder.get(traversalOrder.size()-1).add(node.poll());
                }
            }
        }

        return traversalOrder;

    }
}