package binarysearch;

import java.util.ArrayList;
import java.util.List;
/*
* Problem Description

Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

Your algorithm's runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].



Problem Constraints
1 <= N <= 106

1 <= A[i], B <= 109



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].



Example Input
Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:

 A = [5, 17, 100, 111]
 B = 3


Example Output
Output 1:

 [3, 4]
Output 2:

 [-1, -1]


Example Explanation
Explanation 1:

 First occurence of 8 in A is at index 3
 Second occurence of 8 in A is at index 4
 ans = [3, 4]
Explanation 2:

 There is no occurence of 3 in the array.
 * */
public class SearchforaRange {
        public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
            ArrayList<Integer> res=new ArrayList<Integer>();
            int p=search(a,b,0,a.size()-1);
            //System.out.println(p);
            if(p==-1)
            {
                res.add(-1);res.add(-1);return res;
            }
            else
            {
                res.add(p);
                p=last(a,b,0,a.size()-1);
                res.add(p);

            }
            return res;

        }

        public int search(List<Integer> a, int b,int low, int high)
        {
            if(low<=high)
            {

                int mid=(low+high)/2;
                //  System.out.println(low+" "+mid+" "+high);
                if((mid==0|| b > a.get(mid-1)) && a.get(mid)==b)
                    return mid;
                if(a.get(mid)<b)
                    return  search(a,b,mid+1,high);
                else
                    return  search(a,b,low,mid-1) ;


            }
            return -1;
        }

        public int last(List<Integer> a, int b,int low, int high)
        {
            if(low<=high)
            {

                int mid=(low+high)/2;
                //  System.out.println(low+" "+mid+" "+high);
                if((mid==a.size()-1|| b < a.get(mid+1)) && a.get(mid)==b)
                    return mid;
                if(a.get(mid)>b)

                    return  last(a,b,low,mid-1) ;
                else
                    return  last(a,b,mid+1,high);



            }
            return -1;
        }

    }

