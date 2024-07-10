class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
       return buildTree(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    public TreeNode buildTree(int []preorder,int upperbound,int i[]){
        if(i[0]==preorder.length || preorder[i[0]]>upperbound){
            return null;
        }
        TreeNode root=new TreeNode(preorder[i[0]++]);
        root.left=buildTree(preorder,root.val,i);
        root.right=buildTree(preorder,upperbound,i);
        return root;
    }
}
