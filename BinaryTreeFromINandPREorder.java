class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer>map=new HashMap<Integer,Integer>();
        int i=0;
        for(i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=buildTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1,map);
        return root;
    }
    public TreeNode buildTree(int[] inorder,int instart,int inend,int[] preorder,int prestart,int preend,Map<Integer,Integer>map) {
        if(prestart>preend || instart>inend)return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        int inRoot=map.get(preorder[prestart]);
        int numsleft=inRoot-instart;
        root.left=buildTree(inorder,instart,inRoot-1,preorder,prestart+1,prestart+numsleft,map);
        root.right=buildTree(inorder,inRoot+1,inend,preorder,prestart+numsleft+1,preend,map);
        return root;
    }
}
