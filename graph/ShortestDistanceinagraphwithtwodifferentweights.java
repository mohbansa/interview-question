package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
/*
* Shortest Distance in a graph with two different weights
Problem Description

Given a weighted undirected graph having A nodes, a source node C and destination node D.

Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.

You are expected to do it in Time Complexity of O(A + M).

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints
1 <= A <= 105

0 <= B[i][0], B[i][1] < A

1 <= B[i][2] <= 2

0 <= C < A

0 <= D < A



Input Format
The first argument given is an integer A, representing the number of nodes.

The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].

The third argument given is an integer C, representing the source node.

The fourth argument is an integer D, representing the destination node.

Note: B[i][2] will be either 1 or 2.



Output Format
Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.



Example Input
Input 1:


A = 6
B = [   [2, 5, 1]
        [1, 3, 1]
        [0, 5, 2]
        [0, 2, 2]
        [1, 4, 1]
        [0, 1, 1] ]
C = 3
D = 2
Input 2:

A = 2
B = [   [0, 1, 1]
    ]
C = 0
D = 1


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

The path to be followed will be:
    3 -> 1 (Edge weight : 1)
    1 -> 0 (Edge weight : 1)
    0 -> 2 (Edge weight : 2)
Total length of path = 1 + 1 + 2 = 4.
Explanation 2:

 Path will be 0-> 1.
 * */
public class ShortestDistanceinagraphwithtwodifferentweights {
        public int solve(int A, int[][] B, int C, int D) {
            int[] dist=new int[A];
            ArrayList<ArrayList<int[]>> adj=new  ArrayList<ArrayList<int[]>>(A);
            for(int i=0;i<A;i++)
                adj.add(new ArrayList<int[] >());
            Arrays.fill(dist,Integer.MAX_VALUE);


            for(int i=0;i<B.length;i++)
            {
                adj.get(B[i][0]).add(new int[]{B[i][1],B[i][2]});
                adj.get(B[i][1]).add(new int[]{B[i][0],B[i][2]});
            }
            PriorityQueue<Integer> q=new PriorityQueue<Integer>((a, b)->(dist[a]-dist[b]));
            q.add(C);

            dist[C]=0;
            while(!q.isEmpty())
            {
                int u=q.poll();
                for(int i=0;i<adj.get(u).size();i++)
                {

                    int v =adj.get(u).get(i)[0];
                    int wt =adj.get(u).get(i)[1];

                    if(dist[u]!=Integer.MAX_VALUE && dist[v]>dist[u]+wt)
                    {
                        dist[v]=dist[u]+wt;
                        q.add(v);
                    }



                }

            }

            return dist[D]==Integer.MAX_VALUE?-1:dist[D];
        }
    }


