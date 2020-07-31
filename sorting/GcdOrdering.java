package sorting;
/*
* Gcd Ordering
Given an array of integers A, find and return the lexicographically greatest arrangement of A which follows the below rules:

If the size of A is less than 3 it is always possible to rearrange A.

A[i] = A[i-1] + GCD(A[i-1], A[i-2]) for all i > 2, where GCD(x, y) is greatest common factor of x and y.

Return the lexicographically greatest arrangement of A which follows the above rules, if it is not possible to rearrange A according to the above rules return -1.

Note: Lexicographically means in dictionary order, i.e. if two arrangemnets are compared based on dictionary position the arrangements which comes afterwards is said to be Lexicographically greater.


Input Format

The only argument given is the integer array A.
Output Format

Return the lexicographically greatest arrangement of A  which follows the above rules,
if it is not possible to rearrange A according to the given rules return -1.
Constraints

1 <= length of the array <= 100000
0 <= A[i] <= 10^5
For Example

Input 1:
    A = [4, 6, 2, 5, 3]
Output 1:
     [2, 3, 4, 5, 6]

Input 2:
    A = [3, 8, 5]
Output 2:
    -1
    * */
public class GcdOrdering {
        public int[] solve(int[] A) {


            if(A.length<3)
            {
                if(A.length==2 && A[0]<A[1])
                {
                    int t=A[0];
                    A[0]=A[1];
                    A[1]=t;
                }
                return A;
            }
            Arrays.sort(A);
            for(int i=2;i<A.length;i++)
            {
                if(A[i]!=A[i-1]+gcd(A[i-1],A[i-2]))
                {
                    A=new int[1];
                    A[0]=-1;

                    return A;
                }
            }

            return A;


        }

        public int gcd(int a, int b)
        {
            if(a==0)
                return b;
            return gcd(b%a,a);
        }
    }

