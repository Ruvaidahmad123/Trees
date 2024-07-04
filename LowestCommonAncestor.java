/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }
        //left and right jaao agar milta hai toh usi ko return kar do
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //agar left se nahi milta mtlb right se mila toh usko return kardo
        if(left==null){
            return right;
        }
        //agar left se mila right se nahi toh usko return kardo
        else if(right==null){
            return left;
        }
        //agar dono mil rhe jis root pe toh woh LCA hoga
        else{
            return root;
        }
    }
}
