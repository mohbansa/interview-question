package graph;

import java.util.*;
/*
* Batches
Problem Description

A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.

Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.

All students who know each other are placed in one batch.

Strength of a batch is equal to sum of the strength of all the students in it.

Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.

Find the number of batches selected.

NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.



Problem Constraints
1 <= A <= 105

1 <= M <= 2*105

1 <= B[i] <= 104

1 <= C[i][0], C[i][1] <= A

1 <= D <= 109



Input Format
The first argument given is an integer A.
The second argument given is an integer array B.
The third argument given is a matrix C.
The fourth argument given is an integer D.



Output Format
Return the number of batches selected in IB.



Example Input
Input 1:

 A = 7
 B = [1, 6, 7, 2, 9, 4, 5]
 C = [  [1, 2]
        [2, 3]
       `[5, 6]
        [5, 7]  ]
 D = 12
Input 2:

 A = 5
 B = [1, 2, 3, 4, 5]
 C = [  [1, 5]
        [2, 3]  ]
 D = 6


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 Initial Batches :
    Batch 1 = {1, 2, 3} Batch Strength = 1 + 6 + 7 = 14
    Batch 2 = {4} Batch Strength = 2
    Batch 3 = {5, 6, 7} Batch Strength = 9 + 4 + 5 = 18
    Selected Batches are Batch 1 and Batch 2.
Explanation 2:

 Initial Batches :
    Batch 1 = {1, 5} Batch Strength = 1 + 5  = 6
    Batch 2 = {2, 3} Batch Strength = 5
    Batch 3 = {4} Batch Strength = 4
    Selected Batch is only Batch 1.
    * */
public class Batches {
        public int solve(int A, int[] C, int[][] B, int D) {
            ArrayList<ArrayList<Integer>> inp=new ArrayList<ArrayList<Integer>>(A+1);
            int n=B.length;
            for(int i=0;i<=A;i++)
                inp.add(new ArrayList<Integer>());
            for(int i=0;i<n;i++)
            {
                // System.out.println(B[i][0]+" "+B[i][1]);
                inp.get(B[i][0]).add(B[i][1]);
                inp.get(B[i][1]).add(B[i][0]);
            }
            int[] color=new int[A+1];
            Arrays.fill(color, -1);
            for(int i=1;i<color.length;i++)
            {
                if(color[i]==-1)
                    fill(color,inp,i,i);
            }
            int sum=0;
            HashMap<Integer,Integer> res=new HashMap<Integer,Integer>();
            for(int i=1;i<color.length;i++)
            {
                if(!res.containsKey(color[i]))
                    res.put(color[i],0);
                res.put(color[i],res.get(color[i]) + C[i-1]);
            }

            for(Map.Entry<Integer,Integer> r:res.entrySet())
            {
                //System.out.println(res.getKey()+" "+res.getValue());
                if(r.getValue()>=D) sum++;
            }
            // System.out.println(sum);
            return sum;
        }

        public static void fill(int[] color, ArrayList<ArrayList<Integer>> inp , int s, int num )
        {
            color[s]=num;
            Queue<Integer> q=new LinkedList<Integer>();
            q.add(s);
            while(!q.isEmpty())
            {

                int u=q.poll();


                for(int i=0;i<inp.get(u).size();i++)
                {
                    int v=inp.get(u).get(i);

                    if(color[v]==-1)
                    {
                        color[v]=num;
                        q.add(v);

                    }


                }

            }
            return ;
        }
    }



