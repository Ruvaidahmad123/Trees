// Input:
//        1
//     /     \
//    2       3
// Output: 
// 1 2 
// 1 3 
// Explanation: 
// All possible paths:
// 1->2
// 1->3

class Solution {
    static ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
    static ArrayList<Integer>list=new ArrayList<Integer>();
    public static void path(Node root){
        if(root==null){
            return;
        }
        list.add(root.data);
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(list));
        }
        else{
        path(root.left);
        path(root.right);
        }
        list.remove(list.size()-1);
        
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ans.clear();
        path(root);
        return ans;
    }
}
