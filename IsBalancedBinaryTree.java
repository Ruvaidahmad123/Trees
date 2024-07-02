// Input: root = [3,9,20,null,null,15,7]
// Output: true
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lh=maxDepth(root.left);
        if(lh==-1){
            return -1;
        }
        int rh=maxDepth(root.right);
        if(rh==-1){
            return -1;          
        }
        if(Math.abs(lh-rh)>1){    //if at any point height of left substree -right subtree is greater than 1 tht means it's not balanced immediately return -1;no need to check further
            return -1;
        }
        return 1+Math.max(lh,rh);
    }
    public boolean isBalanced(TreeNode root) {
        if(maxDepth(root)==-1){
            return false;
        }
        return true;
    }
}
