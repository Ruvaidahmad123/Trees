class Solution {
    public void preorder(TreeNode p,TreeNode q,int ans[]){
        if(p==null || q==null){
            if(p==null && q!=null){
                ans[0]=-1;
            }
            if(q==null && p!=null){
                ans[0]=-1;
            }
            return;
        }
        if(p.val!=q.val){
            ans[0]=-1;
            return;
        }
        preorder(p.left,q.left,ans);
        preorder(p.right,q.right,ans);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        int ans[]=new int[1];
        preorder(p,q,ans);
        if(ans[0]!=0){
            return false;
        }
        return true;
    }
}
