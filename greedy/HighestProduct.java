package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
/*
* Highest Product
Problem Description

Given an integer array A of size N.
Return the highest product possible by multiplying 3 numbers from the array.

NOTE: Solution will fit in a 32-bit signed integer.



Problem Constraints
1 <= N <= 5* 105


Input Format
The first and the only argument is an integer array A.



Output Format
Return an integer denoting the highest possible product.



Example Input
A = [0, -1, 3, 100, 70, 50]


Example Output
350000


Example Explanation
70 * 50 * 100 = 350000
* */
public class HighestProduct {
        public int maxp3(ArrayList<Integer> A) {
            PriorityQueue<Integer> p=new PriorityQueue<Integer>(Collections.reverseOrder());
            PriorityQueue<Integer> q=new PriorityQueue<Integer>();
            for(int i=0;i<A.size();i++)
            {
                if(p.size()<2)
                    p.add(A.get(i));
                else
                if(p.peek()>A.get(i))
                {
                    p.poll();
                    p.add(A.get(i));
                }

                if(q.size()<3)
                    q.add(A.get(i));
                else
                if(q.peek()<A.get(i))
                {
                    q.poll();
                    q.add(A.get(i));
                }
            }

            int b=q.poll()*q.poll();
            int max=q.poll();
            b*=max;
            int a=p.poll()*p.poll()*max;

            // System.out.println(max+" "+a+" "+b);
            return Math.max(a,b);
        }
    }

