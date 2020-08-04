package graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
* Clone Graph
Problem Description

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.



Problem Constraints
1 <= Number of nodes <= 105



Input Format
First and only argument is a node A denoting the root of the undirected graph.



Output Format
Return the node denoting the root of the new clone graph.



Example Input
Input 1:

      1
    / | \
   3  2  4
        / \
       5   6
Input 2:

      1
     / \
    3   4
   /   /|\
  2   5 7 6


Example Output
Output 1:

 Output will the same graph but with new pointers:
      1
    / | \
   3  2  4
        / \
       5   6
Output 2:

      1
     / \
    3   4
   /   /|\
  2   5 7 6


Example Explanation
Explanation 1:

 We need to return the same graph, but the pointers to the node should be different.
 * */
public class CloneGraph {
//Definition for undirected graph.
  class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
    };
    HashMap<Integer,UndirectedGraphNode> res=new HashMap<Integer,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneG(node);

    }
    private UndirectedGraphNode cloneG(UndirectedGraphNode node)
    {
        if(node==null) return null;
        if(res.containsKey(node.label)) return res.get(node.label);
        UndirectedGraphNode clone=new UndirectedGraphNode(node.label);
        res.put(clone.label,clone);
        for(UndirectedGraphNode child:node.neighbors)
            clone.neighbors.add(cloneGraph(child));
        return clone;
    }
}
