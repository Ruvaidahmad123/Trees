// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
// The path sum of a path is the sum of the node's values in the path.
// Given the root of a binary tree, return the maximum path sum of any non-empty path.
// Example 1:
// Input: root = [1,2,3]
// Output: 6
// Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
// Example 2:
// Input: root = [-10,9,20,null,null,15,7]
// Output: 42
// Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 class Solution {
     public int maxPathDown(TreeNode root,int maxi[]) {
        if(root==null){
            return 0;
        }
        int lh=Math.max(0,maxPathDown(root.left,maxi));
        int rh=Math.max(0,maxPathDown(root.right,maxi));
        maxi[0]=Math.max(lh+rh+root.val,maxi[0]);   
        return root.val+Math.max(lh,rh);    //hame left node se maximum value milegi ya right node se woh return kar rahe kyuki yeh jitna max hoga pathsum utna hi max hoga
    }
    public int maxPathSum(TreeNode root) {
        int maxi[]=new int[1];
        maxi[0]=Integer.MIN_VALUE;
        int temp=maxPathDown(root,maxi);
        return maxi[0];
    }
}
