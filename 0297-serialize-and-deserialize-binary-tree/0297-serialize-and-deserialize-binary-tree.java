/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder encodedString = new StringBuilder();

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node == null){
                    encodedString.append("n ");
                    continue;
                }
                encodedString.append(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return encodedString.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }

        String[] dataArray = data.split(" ");

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        queue.add(root);

        for(int i=1; i<dataArray.length; i++){
            TreeNode parent = queue.poll();

            if(!dataArray[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(dataArray[i]));
                parent.left = left;
                queue.add(left);
            }

            if(!dataArray[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(dataArray[i]));
                parent.right = right;
                queue.add(right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));