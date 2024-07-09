//using concept of minimum and maximum value for node
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long minval,long maxval) {
        //if we reached end then definite its bst cux no error
        if(root==null){
            return true;
        }
        //at any particular node
        if(root.val>=maxval || root.val<=minval){
            return false;
        }
        //should be true both side
        return isValidBST(root.left,minval,root.val) && isValidBST(root.right,root.val,maxval);
    }
}
//using inorder traversal and storing it in arraylist space complexity O(N)
class Solution {
    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer>list=new ArrayList<Integer>();
        inorder(root,list);
        int idx=list.indexOf(root.val);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }
}
//using recursive approach of inorder but without any extra space 
class Solution {
    public boolean isValidBST(TreeNode root) {
        long[] prev = {Long.MIN_VALUE};
        return inorder(root, prev);
    }

    private boolean inorder(TreeNode node, long[] prev) {
        if (node == null) return true;
        // Check for left
        if (!inorder(node.left, prev)) return false;
        // Node check
        if (node.val <= prev[0]) return false;
        prev[0] = node.val;
        // Check for right
        return inorder(node.right, prev);
    }
}
