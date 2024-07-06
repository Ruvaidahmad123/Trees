public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode>queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node==null){
                sb.append("n ");
                continue;
            }
            sb.append(node.val+" ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")return null;
        Queue<TreeNode>queue=new LinkedList<TreeNode>();
        String values[]=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for(int i=1;i<values.length;i++){
            TreeNode node=queue.poll();
            if(!values[i].equals("n")){
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                node.left=left;
                queue.add(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                node.right=right;
                queue.add(right);
            }
        }
        return root;
    }
}
