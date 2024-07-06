class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         Map<Integer,Integer>map=new HashMap<Integer,Integer>();
        int i=0;
        for(i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
        return root;
    }
    public TreeNode buildTree(int[] inorder,int instart,int inend,int[] postorder,int poststart,int postend,Map<Integer,Integer>map) {
        if(poststart>postend || instart>inend)return null;
        TreeNode root=new TreeNode(postorder[postend]);
        int inRoot=map.get(postorder[postend]);
        int numsleft=inRoot-instart;
        root.left=buildTree(inorder,instart,inRoot-1,postorder,poststart,poststart+numsleft-1,map);
        root.right=buildTree(inorder,inRoot+1,inend,postorder,poststart+numsleft,postend-1,map);
        return root;
    }
}
