//LEETCODE 987
public class Info {
  // Class to store node information for traversal
  int hd;
  int vd;
  int data;

  public Info(int hd, int vd, int data) {
    this.hd = hd;
    this.vd = vd;
    this.data = data;
  }
}

class Solution {
  List<Info> list;

  public void fun(TreeNode root, int h, int v) {
    if (root == null) {
      return;
    }
    // Create Info object with current node's data, horizontal distance, and vertical distance
    Info info = new Info(h, v, root.val);
    list.add(info);
    fun(root.left, h - 1, v + 1); // Recursively traverse left subtree with adjusted distances
    fun(root.right, h + 1, v + 1); // Recursively traverse right subtree with adjusted distances
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    list = new ArrayList<>();
    fun(root, 0, 0); // Start traversal from root with initial distances

    // Sort list of Info objects based on horizontal distance, then vertical distance, then data value
    Collections.sort(list, Comparator.comparingInt((Info info) -> info.hd)
        .thenComparingInt(info -> info.vd)
        .thenComparingInt(info -> info.data));

    // Iterate through sorted list and build the result
    int i = 0;
    while (i < list.size()) {
      ArrayList<Integer> dummy = new ArrayList<>();
      int check = list.get(i).hd;
      while (i < list.size() && list.get(i).hd == check) {
        dummy.add(list.get(i).data);
        i++;
      }
      ans.add(new ArrayList<>(dummy));
    }

    return ans;
  }
}
