package sorting;
/*
* Alternate positive and negative elements
Problem Description

Given an array of integers A, arrange them in an alternate fashion such that every non-negative number is followed by negative and vice-versa, starting from a negative number, maintaining the order of appearance. The number of non-negative and negative numbers need not be equal.

If there are more non-negative numbers they appear at the end of the array. If there are more negative numbers, they too appear at the end of the array.

Note: Try solving with O(1) extra space.



Problem Constraints
1 <= length of the array <= 7000
-109 <= A[i] <= 109



Input Format
The first argument given is the integer array A.



Output Format
Return the modified array.



Example Input
Input 1:

 A = [-1, -2, -3, 4, 5]
Input 2:

 A = [5, -17, -100, -11]


Example Output
Output 1:

 [-1, 4, -2, 5, -3]
Output 2:

 [-17, 5, -100, -11]


Example Explanation
Explanation 1:

A = [-1, -2, -3, 4, 5]
Move 4 in between -1 and -2, A => [-1, 4, -2, -3, 5]
Move 5 in between -2 and -3, A => [-1, 4, -2, 5, -3]
* */
public class AlternatePositiveAndNegativeElements {
        public int[] solve(int[] A) {


            int out=-1;
            for(int i=0;i<A.length;i++)
            {
                // System.out.println(out+" "+i);
                if(out>=0)
                {

                    //check alternate sign number

                    if((A[out]<0 &&  A[i]>=0) || (A[out]>=0 && A[i]<0)  )
                    {
                        //  System.out.println(out+" hhh "+i);
                        int temp=A[i];
                        for(int j=i;j>out;j--)
                            A[j]=A[j-1];
                        A[out]=temp;

                        if(i-out>2)
                            out+=2;
                        else
                            out=-1;

                    }

                }


                if(out==-1)
                {

                    if((i%2==0 && A[i]>=0) ||(i%2==1 && A[i]<0))
                        out=i;
                }


            }
            return A;
        }
    }

