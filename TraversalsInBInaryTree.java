/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.List;
import java.util.ArrayList;
public class Solution {
    public static void inorderTraversal(TreeNode root,List<Integer>list){
        if(root==null){
            return;
        }
        inorderTraversal(root.left,list);
        list.add(root.data);
        inorderTraversal(root.right,list);
    }
    public static void preorderTraversal(TreeNode root,List<Integer>list){
        if(root==null){
            return;
        }
        list.add(root.data);
        preorderTraversal(root.left,list);
        preorderTraversal(root.right,list);
    }
    public static void postorderTraversal(TreeNode root,List<Integer>list){
        if(root==null){
            return;
        }
        postorderTraversal(root.left,list);
        postorderTraversal(root.right,list);
        list.add(root.data);
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
       List<List<Integer>> ans = new ArrayList<>();
        List<Integer>list1=new ArrayList<Integer>();
        List<Integer>list2=new ArrayList<Integer>();
        List<Integer>list3=new ArrayList<Integer>();
        inorderTraversal(root,list1);
        preorderTraversal(root,list2);
        postorderTraversal(root,list3);
        ans.add(list1);
        ans.add(list2);
        ans.add(list3);
        return ans;
    }
}
