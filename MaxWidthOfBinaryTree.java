// Input: root = [1,3,2,5,null,null,9,6,null,7]
// Output: 7
// Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
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
 class Pair{
    int num;
    TreeNode node;
    Pair(TreeNode _node,int _num){
        node=_node;
        num=_num;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue=new LinkedList<>();
        if(root==null){
            return 0;
        }
        queue.offer(new Pair(root,0));
        int ans=0;
        while(!queue.isEmpty()){
            int n=queue.size();
            int min=queue.peek().num;
            int first=0;
            int last=0;
            for(int i=0;i<n;i++){
                int curr_id=queue.peek().num-min;
                TreeNode node=queue.peek().node;
                queue.poll();
                if(i==0){
                    first=curr_id;
                }
                if(i==n-1){
                    last=curr_id;
                }
                if(node.left!=null){
                    queue.offer(new Pair(node.left,2*curr_id+1));
                }
                if(node.right!=null){
                    queue.offer(new Pair(node.right,2*curr_id+2));
                }
            }
            ans=Math.max(last-first+1,ans);
        }
        return ans;
    }
}
