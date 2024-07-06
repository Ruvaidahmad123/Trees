// Geek wants to know the traversals required to construct a unique binary tree. Given a pair of traversal, return true if it is possible to construct unique binary tree from the given traversals otherwise return false.

// Each traversal is represented with an integer: preorder - 1, inorder - 2, postorder - 3.   

// Example 1:

// Input:
// a = 1, b=2
// Output: 1
// Explanation: We can construct binary tree using inorder traversal and preorder traversal. 
class Solution{
    
    public static boolean isPossible(int a, int b){
        // Code here  // we need atleast inorder with preorder and postorder to construct unique binary tree
        if(a==1 && b==2 || a==2 && b==1){
            return true;
        }
        if(a==1 && b==3){
            return false;
        }
        if(a==3 && b==2 || a==2 && b==3){
            return true;
        }
        return false;
    }
}
