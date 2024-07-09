class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val<p.val && root.val<q.val){     //agar dono right me h
                root=root.right;                         
            }
            else if(root.val>p.val && root.val>q.val){
                root=root.left;             //agar dono left me h
            }
            else{              //node where they split will be LCA
                return root;
            }
        }
        return null;
    }
}
