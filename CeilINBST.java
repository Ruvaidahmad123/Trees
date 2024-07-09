// Given a BST and a number X, find Ceil of X.
// Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.

// If Ceil could not be found, return -1.

// Example 1:

// Input:
//       5
//     /   \
//    1     7
//     \
//      2 
//       \
//        3
// X = 3
// Output: 3
// Explanation: We find 3 in BST, so ceil
// of 3 is 3.
// Example 2:

// Input:
//      10
//     /  \
//    5    11
//   / \ 
//  4   7
//       \
//        8
// X = 6
// Output: 7
// Explanation: We find 7 in BST, so ceil
// of 6 is 7.
// You are given a BST(Binary Search Tree) with n number of nodes and value x. your task is to find the greatest value node of the BST which is smaller than or equal to x.
// Note: when x is smaller than the smallest node of BST then returns -1.

// Example:

// Input:
// n = 7               2
//                      \
//                       81
//                     /     \
//                  42       87
//                    \       \
//                     66      90
//                    /
//                  45
// x = 87
// Output:
// 87
// Explanation:
// 87 is present in tree so floor will be 87.
// Example 2:

// Input:
// n = 4                     6
//                            \
//                             8
//                           /   \
//                         7       9
// x = 11
// Output:
// 9
class Solution {
    public static int findFloor(Node root, int x) {
        int floor = -1;
        while (root != null) {
            if (root.data == x) {
                return root.data;
            }
            if (root.data < x) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }

    public static int floor(Node root, int x) {
        if (root == null) {
            return -1;
        }
        return findFloor(root, x);
    }

    public static int findCeil(Node root, int x) {
        int ceil = -1;
        while (root != null) {
            if (root.data == x) {
                return root.data;
            }
            if (root.data > x) {
                ceil = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }

    public static int ceil(Node root, int x) {
        if (root == null) {
            return -1;
        }
        return findCeil(root, x);
    }
}
