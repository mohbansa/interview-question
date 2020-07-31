package bitmanipulation;
/*
* Problem Description

Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.

NOTE: INT_MAX = 2^31 - 1



Problem Constraints
-231 <= A, B <= 231-1

B!= 0



Input Format
First argument is an integer A denoting the dividend.
Second argument is an integer B denoting the divisor.



Output Format
Return an integer denoting the floor value of the division.



Example Input
Input 1:

 A = 5
 B = 2
Input 2:

 A = 7
 B = 1


Example Output
Output 1:

 2
Output 2:

 7


Example Explanation
Explanation 1:

 floor(5/2) = 2

 */
public class DivideIntegers {
        public int divide(int A, int B) {
            int sign=1;
            long l;
            if((A>0 && B<0) || (A<0 && B>0))
                sign=-1;

            long a=Math.abs((long)A);
            long b=Math.abs((long)B);
            // System.out.println(a+" "+b);



            if(a==0 && a<b )
                return 0;

            l=get(a,b);
            if(l>Integer.MAX_VALUE)
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            return (int)(l*sign);
        }
        public long get(long A,long B)
        {
            if(A<B)
                return 0;
            long m=1;
            long s=B;
            while(s+s<=A)
            {
                m+=m;
                s+=s;
            }
            return m+get(A-s,B);
        }
    }

