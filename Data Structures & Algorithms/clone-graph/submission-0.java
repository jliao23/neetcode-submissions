/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Node root = new Node(node.val);
        if (visited.containsKey(root.val)) {
            return visited.get(root.val);
        }
        visited.put(root.val, root);

        for (Node neighbor : node.neighbors) {
            root.neighbors.add(cloneGraph(neighbor));
        }


        // from starting node, traverse to all its neighbors
        // for each neighbor, checking the adj list and traverse to all neighbors excluding the node we came from
        // when there is no more neighbors to traverse, terminate

        // at each node, create new node with same val and same adj list
        return root;
    }


}