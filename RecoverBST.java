class Solution {
    TreeNode first=null;
    TreeNode middle=null;
    TreeNode last=null;
    TreeNode prev;
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null && root.val<prev.val){
            if(first==null){      //first violation
                first=prev;
                middle=root;
            }
            else{
                last=root;        //last violation
            }
        }
        prev=root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        prev=new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){   //violations are not adjacent
            int t=first.val;
            first.val=last.val;
            last.val=t;
        }
        else if(first!=null && middle!=null){
            int t=first.val;                  //violations are adjacent
            first.val=middle.val;
            middle.val=t;
        }
    }
}
