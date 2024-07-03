class Solution {
    List<Integer>ans=new ArrayList<>();
    public void reversepreorder(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(level==ans.size()){
            ans.add(root.val);
        }
        reversepreorder(root.right,level+1);
        reversepreorder(root.left,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        reversepreorder(root,0);
        return ans;
    }
}
