// Given a binary tree having n nodes. Check whether all of its nodes have the value equal to the sum of their child nodes. Return 1 if all the nodes in the tree satisfy the given properties, else it return 0.

// For every node, data value must be equal to the sum of data values in left and right children. Consider data value as 0 for NULL child.  Also, leaves are considered to follow the property.

// Example 1:

// Input:
// Binary tree
//        35
//       /   \
//      20  15
//     /  \  /  \
//    15 5 10 5
// Output: 
// 1
// Explanation: 
// Here, every node is sum of its left and right child.
class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static boolean check(Node root){
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        int leftData = (root.left != null) ? root.left.data : 0;
        int rightData = (root.right != null) ? root.right.data : 0;

        // Check if the current node satisfies the sum property
        if (root.data != leftData + rightData) {
            return false;
        }

        // Recursively check the left and right subtrees
        return check(root.left) && check(root.right);
    }
    public static int isSumProperty(Node root)
    {
        boolean p=check(root);
        if( p){
            return 1;
        }
        return 0;
    }
}
