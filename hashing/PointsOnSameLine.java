package hashing;

import java.util.HashMap;
/*
* Points on same line
Problem Description

Given two array of integers A and B describing a pair of (A[i], B[i]) coordinates in 2D plane. A[i] describe x coordinates of the ith point in 2D plane whereas B[i] describes the y-coordinate of the ith point in 2D plane.

Find and return the maximum number of points which lie on the same line.



Problem Constraints
1 <= (length of the array A = length of array B) <= 1000

-105 <= A[i], B[i] <= 105



Input Format
First argument is an integer array A.
Second argument is an integer array B.



Output Format
Return the maximum number of points which lie on the same line.



Example Input
Input 1:

 A = [-1, 0, 1, 2, 3, 3]
 B = [1, 0, 1, 2, 3, 4]
Input 2:

 A = [3, 1, 4, 5, 7, -9, -8, 6]
 B = [4, -8, -3, -2, -1, 5, 7, -4]


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}.
Explanation 2:

 Any 2 points lie on a same line.
 * */
public class PointsOnSameLine {
        public int solve(int[] A, int[] B) {
            int max=Integer.MIN_VALUE;

            for(int i=0;i<A.length;i++)
            {
                HashMap<String,Integer> inp=new  HashMap<String,Integer>();
                int freq=0;
                int v=0;
                int overlap=0;
                for(int j=0;j<A.length;j++)
                {

                    if(i!=j)
                    {
                        if(B[j]==B[i] && A[j]==A[i] )
                        {
                            overlap++;
                            continue;
                        }
                        if(A[i]==A[j])
                            v++;
                        else
                        {
                            int y=B[j]-B[i];
                            int x=A[j]-A[i];
                            int g=gcd(Math.abs(x),Math.abs(y));
                            //System.out.println(x+" "+y+" "+g+" "+i);
                            if(x<0 && y<0 || x>0 && y>0)
                                g=g;
                            else
                                g=-g;
                            y=y/g;
                            x=x/g;
                            String key=x+"@"+y;

                            if(!inp.containsKey(key))
                                inp.put(key,1);
                            else
                                inp.put(key,inp.get(key)+1);
                            freq=Math.max(inp.get(key),freq);

                        }


                        freq=Math.max(freq,v);
                    }

                }
                // System.out.println(inp+" "+v+" "+max+" "+A[i]);

                max=Math.max(freq+overlap+1,max);

            }
            return max;

        }

        public int gcd(int x,int y)
        {

            if(x==0)
                return y;
            else
                return gcd(y%x,x);
        }
    }

