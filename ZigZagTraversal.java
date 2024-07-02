// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null){
            return ans;
        }
        queue.offer(root);
        int ptr=0;
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer>sublist=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                sublist.add(queue.poll().val);
            }
            if(ptr%2==0){
                ans.add(sublist);
                ptr++;
            }
            else{
                Collections.reverse(sublist);
                ans.add(sublist);
                ptr++;
            }
        }
        return ans;
    }
}
