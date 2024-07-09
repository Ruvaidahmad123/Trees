class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        TreeNode temp=root;
        while(temp!=null){
            if(val>temp.val && temp.right!=null){
                temp=temp.right;
            }
            else if(val<temp.val && temp.left!=null){
                temp=temp.left;
            }
            else{
                if(val<temp.val){
                    temp.left=new TreeNode(val);
                }
                else{
                    temp.right=new TreeNode(val);
                }
                break;
            }
        }
        return root;
    }
}
