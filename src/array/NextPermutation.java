package array;

import java.util.ArrayList;
/*
* Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order.

NOTE:

The replacement must be in-place, do not allocate extra memory.
DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.


Problem Constraints
1 <= N <= 5 * 105

1 <= A[i] <= 109



Input Format
The first and the only argument of input has an array of integers, A.



Output Format
Return an array of integers, representing the next permutation of the given array.



Example Input
Input 1:

 A = [1, 2, 3]
Input 2:

 A = [3, 2, 1]


Example Output
Output 1:

 [1, 3, 2]
Output 2:

 [1, 2, 3]


Example Explanation
Explanation 1:

 Next permutaion of [1, 2, 3] will be [1, 3, 2].
Explanation 2:

 No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
 So will rearranges it in the lowest possible order.
 * */
public class NextPermutation {
        public void nextPermutation(ArrayList<Integer> a) {


            if(a.size()>1)
            {
                int inverse=a.size()-2;

                while(inverse>=0 && a.get(inverse)>a.get(inverse+1))
                {       inverse--;

                }
                //System.out.println(inverse+" "+a.get(inverse));
                if(inverse>=0)
                {
                    for(int i=a.size()-1;i>inverse;i--)
                    {
                        //  System.out.println(a.get(i));
                        if(a.get(i)>a.get(inverse))
                        {
                            int temp=a.get(i);
                            a.set(i,a.get(inverse));
                            a.set(inverse,temp);
                            break;
                        }
                    }

                }
                // System.out.println(a);
                for(int i=inverse+1,j=a.size()-1;i<j;i++,j--)
                {
                    int temp=a.get(i);
                    a.set(i,a.get(j));
                    a.set(j,temp);
                }
            }
        }
    }

