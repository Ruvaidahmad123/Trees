/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void solve(TreeNode root,int arr[]){
        if(root==null){
            return;
        }
        if(root.left!=null && root.left.left==null && root.left.right==null){
            arr[0]+=root.left.val;
        }
        solve(root.left,arr);
        solve(root.right,arr);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int arr[]=new int[1];
        solve(root,arr);
        return arr[0];
    }
}
