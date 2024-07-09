// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3
 
class Solution {
    int count=0;
    int ans=-1;
    public void inorder(TreeNode root,int k){
        if(root==null){
            return;
        }
        inorder(root.left,k);
        count++;
        if(count==k){
            ans=root.val;
            return;
        }
        inorder(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root==null || root.left==null && root.right==null){
            return root.val;
        }
        inorder(root,k);
        return ans;
    }
}
