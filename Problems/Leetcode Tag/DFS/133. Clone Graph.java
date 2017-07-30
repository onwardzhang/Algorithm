/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    // // iteration
    // public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    //     if (node == null) {
    //         return null;
    //     }
    //     Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    //     Queue<UndirectedGraphNode> queue = new LinkedList<>(); // or stack
    //     queue.offer(node);
    //     map.put(node.label, new UndirectedGraphNode(node.label));
    //     while (!queue.isEmpty()) {
    //         UndirectedGraphNode tmp = queue.poll();
    //         UndirectedGraphNode cloned = map.get(tmp.label);
    //         for (UndirectedGraphNode neighbor : tmp.neighbors) {
    //             if (!map.containsKey(neighbor.label)) {
    //                 map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
    //                 queue.offer(neighbor); // should inside the if clasue, because labels are unique and avoid infinite loop(cycle)
    //             }
    //             cloned.neighbors.add(map.get(neighbor.label));
    //         }
    //     }
    //     return map.get(node.label);
    // }
    
    
    // recursion
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfsHelper(node, map);
    }
    
    private UndirectedGraphNode dfsHelper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) { // clone node & its neighbors, return the cloned node
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
        map.put(clonedNode.label, clonedNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clonedNode.neighbors.add(dfsHelper(neighbor, map));
        }
        return clonedNode;
    }
}