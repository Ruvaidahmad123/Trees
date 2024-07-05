// Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.
// Note: The tree contains unique values.


// Examples : 

// Input:      
//           1
//         /   \
//       2      3
//     /  \      \
//    4    5      6
//        / \      \
//       7   8      9
//                    \
//                    10
// Target Node = 8
// Output: 7
// Explanation: If leaf with the value 
// 8 is set on fire. 
// After 1 sec: 5 is set on fire.
// After 2 sec: 2, 7 are set to fire.
// After 3 sec: 4, 1 are set to fire.
// After 4 sec: 3 is set to fire.
// After 5 sec: 6 is set to fire.
// After 6 sec: 9 is set to fire.
// After 7 sec: 10 is set to fire.
// It takes 7s to burn the complete tree.
class Solution
{
    public static void mark_parents(Node root,Map<Node,Node>parent_track){
        Queue<Node>queue=new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node curr=queue.poll();
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
    public static Node findTarget(Node root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;
        Node left = findTarget(root.left, target);
        if (left != null) return left;
        return findTarget(root.right, target);
    }
    public static int minTime(Node root, int target) 
    {
        Map<Node,Node>parent_track=new HashMap<>();
        mark_parents(root,parent_track);
        Map<Node,Boolean>visited=new HashMap<>();
        Queue<Node>queue=new LinkedList<Node>();
        Node targetNode = findTarget(root, target);
        queue.offer(targetNode);
        visited.put(targetNode,true);
        int mintime=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            int fl=0;
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    fl=1;
                    queue.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    fl=1;
                    queue.offer(node.right);
                    visited.put(node.right,true);
                }
                if(parent_track.get(node)!=null && visited.get(parent_track.get(node))==null){
                    fl=1;
                    queue.offer(parent_track.get(node));
                    visited.put(parent_track.get(node),true);
                }
            }
            if(fl==1)mintime++;
        }
        return mintime;
    }
}
