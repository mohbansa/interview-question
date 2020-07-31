package hashing;

import java.util.ArrayList;
/*
* Lightsabers
Given two array of integers A and B of size N and M respectively.

The goal is to select some continuous interval in A such that there are exactly B[0] elements with value 1, B[1] elements with value 2 and so on ending with B[m-1] elements with value m.

However, it is not always possible to select such an interval form the given array therefore it is allowed to remove some elements from A in order to achieve the goal.

Find and return the minimum number of elements to be removed from A in order to achieve the goal. If it is not possible to achieve the goal return -1 instead.


Input Format

The first argument given is the integer array A.
The second argument given is the integer array B.
Output Format

Return the minimum number of elements to be removed from A in order to achieve the goal and
if it is not possible to achieve the goal return -1 instead.
Constraints

1 <= N, M <= 100000
1 <= A[i] <= M
0 <= B[i] <= N
For Example

Input 1:
    A = [1, 2, 3, 4, 1]
    B = [2, 1, 1, 0]
Output 1:
    1   (Reomve element 4 and consider all the remaining elements).

Input 2:
    A = [1, 1, 2, 2, 2]
    B = [1, 2, 1]
Output 2:
    -1
    * */
public class Lightsabers {
        public int solve(ArrayList<Integer> A, ArrayList<Integer> B)
        {
            int m = B.size();
            int[] freq = new int[m + 1];
            int count = 0, min = Integer.MAX_VALUE;
            for(int i = 0; i < m; i++)
            {
                freq[i + 1] = freq[i + 1] - B.get(i);
                count = count - B.get(i);
            }
            int sum = -1 * count;
            int i = 0, j = 0, n = A.size();
            while(i < n)
            {
                if(freq[A.get(i)] < 0)
                    count++;
                freq[A.get(i)]++;
                while(j < i && count == 0)
                {
                    if((i - j + 1) < min)
                    {
                        min = i - j + 1;
                    }
                    if(freq[A.get(j)] == 0)
                    {
                        count--;
                    }
                    freq[A.get(j)]--;
                    j++;
                }
                i++;
            }
            //System.out.println(min);
            return min == Integer.MAX_VALUE ? -1 : min - sum;
        }
    }
