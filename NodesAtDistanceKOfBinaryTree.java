// Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
// Output: [7,4,1]
// Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
// Example 2:

// Input: root = [1], target = 1, k = 3
// Output: []
 
class Solution {
    public void mark_parents(TreeNode root,Map<TreeNode,TreeNode>parent_track){
        Queue<TreeNode>queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            if(curr.left!=null){
                parent_track.put(curr.left,curr);
                queue.offer(curr.left);
            }
            if(curr.right!=null){
                parent_track.put(curr.right,curr);
                queue.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>parent_track=new HashMap<>();
        mark_parents(root,parent_track);
        Map<TreeNode,Boolean>visited=new HashMap<>();
        Queue<TreeNode>queue=new LinkedList<TreeNode>();
        queue.offer(target);
        visited.put(target,true);
        int curr_level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            if(curr_level==k)
                break;
            curr_level++;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    queue.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    queue.offer(node.right);
                    visited.put(node.right,true);
                }
                if(parent_track.get(node)!=null && visited.get(parent_track.get(node))==null){
                    queue.offer(parent_track.get(node));
                    visited.put(parent_track.get(node),true);
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            ans.add(node.val);
        }
        return ans;
    }
}
