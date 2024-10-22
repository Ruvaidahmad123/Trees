class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ArrayList<Long> ans = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int n = q.size();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ans.add(sum);
        }

        if (ans.size() < k) {
            return -1;
        }

        // Sort in descending order to easily access k-th largest
        Collections.sort(ans, Collections.reverseOrder());

        return ans.get(k - 1);
    }
}
