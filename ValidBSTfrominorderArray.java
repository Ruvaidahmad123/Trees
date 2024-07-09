// Given an array of integers arr[] representing inorder traversal of elements of a binary tree. Return true if the given inorder traversal can be of a valid Binary Search Tree.

// Note - In a valid Binary Search Tree all keys are unique.

// Examples :

// Input: arr[] = [8, 14, 45, 64, 100]
// Output: True
// Input: arr[] = [5, 6, 1, 8, 7]
// Output: False
class Solution {
    static boolean isBSTTraversal(int A[]) {   //NOTE:inorder of bst gives sorted array
        int n=A.length; boolean flag = false;
        for(int i=0;i<n-1;i++){
            if(A[i]<A[i+1])
                flag = true;
            else{
                flag = false;
                break;
            }
        }
        return flag;
    }
}
