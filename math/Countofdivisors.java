package math;
/*
* Problem Description

Given an array of integers A, find and return the count of divisors of each element of the array.

NOTE: Order of the resultant array should be same as the input array.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 106



Input Format
The only argument given is the integer array A.



Output Format
Return the count of divisors of each element of the array in the form of an array.



Example Input
Input 1:

 A = [2, 3, 4, 5]
Input 2:

 A = [8, 9, 10]


Example Output
Output 1:

 [2, 2, 3, 2]
Output 1:

 [4, 3, 4]


Example Explanation
Explanation 1:

 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 So the count will be [2, 2, 3, 2].
Explanation 2:

 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 So the count will be [4, 3, 4].
 * */
public class Countofdivisors {
    public int[] solve(int[] A) {
        int max=Arrays.stream(A).max().getAsInt();
        int[] sieve=new int[max];

        Arrays.fill(sieve, 2);
        sieve[0]=1;
        for(int i=2;i<=max/2;i++)
        {
            int j=i;
            // System.out.println(i);
            while(i+j<=sieve.length)
            {
                // System.out.print(i+j+" ");
                sieve[i+j-1]++;
                j+=i;
            }
            //  System.out.println();

        }
        for(int i=0;i<A.length;i++)
        {

            A[i]=sieve[A[i]-1];
        }
        return A;

    }
}
