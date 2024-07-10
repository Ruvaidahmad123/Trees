class NodeValue{
    int minnode,maxnode,maxsize;
    NodeValue(int min,int max,int maxsize){
        this.minnode=min;
        this.maxnode=max;
        this.maxsize=maxsize;
    }
}
class Solution{
    public static NodeValue findAns(Node root){
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0); // min value =max value and max value=min value to count leaf nodes as they are also a valid bst 
        }
        NodeValue left=findAns(root.left);
        NodeValue right=findAns(root.right);
        if(root.data>left.maxnode && root.data<right.minnode){
            //is a BST
            return new NodeValue(Math.min(left.minnode,root.data),Math.max(right.maxnode,root.data),left.maxsize+right.maxsize+1);
        }
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxsize,right.maxsize));
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        return findAns(root).maxsize;
        
    }
    
}
