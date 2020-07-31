package binarysearch;

import java.util.List;
/*
* Problem Description

Given a sorted array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= N <= 1000000

1 <= A[i] <= 10^9

all elements in A are disitinct.



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return index of B in array A, otherwise return -1



Example Input
Input 1:

A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4
Input 2:

A = [1]
B = 1


Example Output
Output 1:

 0
Output 2:

 0


Example Explanation
Explanation 1:


Target 4 is found at index 0 in A.
Explanation 2:


Target 1 is found at index 0 in A.
* */
public class RotatedSortedArraySearch {
        public int search(final List<Integer> a, int b) {

            int pivot=get(a,b,0,a.size()-1);
            //  System.out.println(pivot+" h");
            int res=-1;
            if(a.get(pivot)==b)
                return pivot;
            else
            if(a.get(0)<=b)

                res= s(a,b,0,pivot-1);
            else
                res= s(a,b,pivot+1,a.size()-1);
            return res;
        }

        public int get(List<Integer> a, int b,int l, int h)
        {
            if(l<=h)
            {
                int m=(l+h)/2;
                if(l==h)
                    return m;
                if(m<h && a.get(m) > a.get(m+1))
                    return m;
                if(m>l && a.get(m) < a.get(m-1))
                    return m;
                if(a.get(l)>a.get(m))
                    return get(a,b,l,m-1);
                return get(a,b,m+1,h)  ;
            }
            return -1;
        }


        public int s(List<Integer> a, int b,int l, int h)
        {
            // System.out.println(l+" "+h);
            if(l<=h)
            {
                int m=(l+h)/2;
                if(a.get(m)==b)
                    return m;
                if(a.get(m)>b)
                    return s(a,b,l,m-1);
                else
                    return s(a,b,m+1,h);
            }
            return -1;
        }

    }

