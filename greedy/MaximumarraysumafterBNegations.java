package greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
* Maximum array sum after B negations
Problem Description

Given an array of integers A and an integer B. You must modify the array exactly B number of times. In single modification, we can replace any one array element A[i] by -A[i].

You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.



Problem Constraints
1 <= length of the array <= 5*105
1 <= B <= 5 * 106
-100 <= A[i] <= 100



Input Format
First argument given is an integer array A.
Second argument given is an integer B.



Output Format
Return an integer denoting the maximum array sum after B modifications.



Example Input
Input 1:

 A = [24, -68, -29, -9, 84]
 B = 4
Input 2:

 A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 B = 10


Example Output
Output 1:

 196
Output 2:

 362


Example Explanation
Explanation 1:

 Final array after B modifications = [24, 68, 29, -9, 84]
Explanation 2:

 Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
 * */

public class MaximumarraysumafterBNegations {
    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> p=new PriorityQueue<Integer>();
        for(int i=0;i<A.size();i++)
            p.add(A.get(i));
        while(B>0)
        {
            B--;
            int val=p.poll();
            // System.out.println(B+" "+val);
            val=-val;
            p.add(val);
            if(val==0)
                break;
        }
        int sum=0;
        while(!p.isEmpty())
        {
            int val=p.poll();
            sum+=val;
            // System.out.println(val);
        }
        return sum;
    }
}
