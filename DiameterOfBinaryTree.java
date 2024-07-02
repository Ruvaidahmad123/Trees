// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
// The length of a path between two nodes is represented by the number of edges between them.
class Solution {
     public int maxDepth(TreeNode root,int maxi[]) {
        if(root==null){
            return 0;
        }
        int lh=maxDepth(root.left,maxi);
        int rh=maxDepth(root.right,maxi);
        maxi[0]=Math.max(lh+rh,maxi[0]);   //sabhi node pe hame lh and rh ki value mil rhi toh wahi check kar lenge maximum value of lh+rh;
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int maxi[]=new int[1];
        int temp=maxDepth(root,maxi);
        return maxi[0];
    }
}
