package binarysearch;

import java.util.ArrayList;
/*
* Problem Description

Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integar B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 106



Input Format
The first argument given is the integer matrix A.
The second argument given is the integer B.



Output Format
Return 1 if B is present in A, else return 0.



Example Input
Input 1:

A = [
      [1,   3,  5,  7]
      [10, 11, 16, 20]
      [23, 30, 34, 50]
    ]
B = 3
Input 2:

A = [
      [5, 17, 100, 111]
      [119, 120, 127, 131]
    ]
B = 3


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

 3 is present in the matrix at A[0][1] position so return 1.
Explanation 2:

 3 is not present in the matrix so return 0.
 * */
public class MatrixSearch {
        public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

            int low=0;
            int high=a.size()-1;
            int row=-1;
            ArrayList<Integer> arr=new  ArrayList<Integer>();
            while(low<=high)
            {

                if(low==high)
                {
                    row=low;
                    break;
                }
                int mid=(low+high)/2;
                arr=a.get(mid);
                if( arr.get(arr.size()-1)==b)
                    return 1;

                if( arr.get(arr.size()-1)>b)
                    high=mid;
                else
                    low=mid<a.size()-1?mid+1:mid;
                // System.out.println(low+" "+high);
            }
            // System.out.println("hey "+row);
            if(row==-1)
                return 0;
            else
            {

                return search(a.get(row), b, 0, a.get(row).size()-1);
            }


        }

        public int search(ArrayList<Integer> arr, int b, int low, int high)
        {

            if(low<=high)
            {

                int mid=(low+high)/2;
                if(arr.get(mid)==b)
                    return 1;

                if(arr.get(mid)>b)
                    return search(arr,b,low,mid-1);
                else
                    return search(arr,b,mid+1,high);
            }
            return 0;
        }
    }

