class Solution {
    List<Integer>list=new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                list.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }
                else{
                    list.add(curr.val);
                    prev.right=null;
                    curr=curr.right;
                }
            }
        }
        return list;
    }
}
