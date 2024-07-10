class BSTIterator {
    Stack<TreeNode> stack= new Stack<>();
    boolean reverse;
    public BSTIterator(TreeNode root,boolean isreverse) {
        reverse=isreverse;
        pushAll(root);  
    }
    
    public int next() {
        TreeNode node=stack.pop();
        if(reverse==false)
            pushAll(node.right);
        else
            pushAll(node.left);
        return node.val;
    }
    public void pushAll(TreeNode root){
        while(root!=null){
            stack.push(root);
            if(reverse==false)
                root=root.left;
            else
                root=root.right;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        BSTIterator l=new BSTIterator(root,false);  //to store in ascending order
        BSTIterator r=new BSTIterator(root,true);  //to store in descending order
        int i=l.next();
        int j=r.next();
        while(i<j){
            if(i+j==k){
                return true;
            }
            else if(i+j<k){
                i=l.next();
            }
            else{
                j=r.next();
            }
        }
        return false;
    }
}
