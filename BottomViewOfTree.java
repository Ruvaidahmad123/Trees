class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}

class Solution {
    // Function to return a list of nodes visible from the bottom view
    // from left to right in Binary Tree.
    static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        // Check if the tree is empty
        if (root == null) {
            return ans;
        }

        // Map to store the top view nodes based on their vertical positions
        Map<Integer, Integer> mpp = new TreeMap<>();

        // Queue for BFS traversal, each element is a pair containing node
        // and its vertical position
        Queue<Pair<Node, Integer>> q = new LinkedList<>();

        // Push the root node with its vertical position (0) into the queue
        q.add(new Pair<>(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            // Retrieve the node and its vertical position from the front of the queue
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getFirst();
            int line = pair.getSecond();

            // If the vertical position is not already in the map, add the node's data to the map
            
            mpp.put(line, node.data);

            // Process left child
            if (node.left != null) {
                // Push the left child with a decreased vertical position into the queue
                q.add(new Pair<>(node.left, line - 1));
            }

            // Process right child
            if (node.right != null) {
                // Push the right child with an increased vertical position into the queue
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        // Transfer values from the map to the result list
        for (int value : mpp.values()) {
            ans.add(value);
        }

        return ans;
    }
