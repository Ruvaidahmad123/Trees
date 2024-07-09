// Given the root of a Binary Search Tree. The task is to find the minimum valued element in this given BST.

// Example 1:

// Input:
//            5
//          /    \
//         4      6
//        /        \
//       3          7
//      /
//     1
// Output: 1
class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        Node temp=root;
        int minv=0;
        while(temp!=null){
            minv=temp.data;
            temp=temp.left;
        }
        return minv;
    }
}
