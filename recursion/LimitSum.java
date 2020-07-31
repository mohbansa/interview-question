package recursion;

import java.util.ArrayList;
/*
* Limit Sum
Problem Description

Given an array A of N integers, return the number of subsets of A that have a sum less than or equal to B.



Problem Constraints
1 <= N <= 40
1 <= A[i], B[i] <= 1e9


Input Format
The first argument is an array of integer, A.
The second argument is an integer, B.


Output Format
Return a string representation of the number of subsets that satisfy the given condition.


Example Input
Input 1:

A = [4, 1, 3]
B = 3
Input 2:

A = [2, 1, 4]
B = 3


Example Output
Output 1:

3
Output 2:

4


Example Explanation
Explanation 1:

3 subsets have a sum less than or equal to 3:
    => []
    => [1]
    => [3]
Explanation 2:

4 subsets have a sum less than or equal to 3:
    => []
    => [2]
    => [1]
    => [1, 2]
    * */
public class LimitSum {
    public String solve(ArrayList<Integer> a, int B) {

            ArrayList<Integer> a1=new ArrayList<Integer>();
            ArrayList<Integer> a2=new ArrayList<Integer>();

            for(int i=0;i<a.size();i++)
            {
                if(a.get(i)>B) continue;
                if(i<a.size()/2)
                    a1.add(a.get(i));
                else
                    a2.add(a.get(i));
            }

            //  System.out.println(a1);
            //   System.out.println(a2);
            int mask1=1<<a1.size();
            int mask2=1<<a2.size();

            ArrayList<Long> s1=new ArrayList<Long>();
            ArrayList<Long> s2=new ArrayList<Long>();


            //calculating subset sum for all element of a1
            for(int i=0;i<mask1;i++)
            {
                long sum=0;
                for(int j=0;j<a1.size();j++)
                {
                    if((i&(1<<j))!=0)
                        sum+=a1.get(j);
                }

                if(sum<=B)
                    s1.add(sum);
            }

            for(int i=0;i<mask2;i++)
            {
                long sum=0;
                for(int j=0;j<a2.size();j++)
                {
                    if((i&(1<<j))!=0)
                        sum+=a2.get(j);
                }

                if(sum<=B)
                    s2.add(sum);
            }




            Collections.sort(s2);
            //  System.out.println(s1);
            // System.out.println(s2);

            long count=0;
            for(int i=0;i<s1.size();i++)
            {
                // System.out.println(s1.get(i)+" "+upper(s2,s2.size(),B-s1.get(i)));
                long c=upper(s2,s2.size(),B-s1.get(i));
                // System.out.println(s1.get(i)+"==>"+c);
                count+=c;

            }

            return String.valueOf(count);


        }


        public long upper(ArrayList<Long> a, int length, Long val)
        {
            // System.out.println(val+" h");
            int low=0;
            int high=length;
            while(low<high)
            {

                int mid=(low+high)/2;
                // System.out.println(low+" "+mid+" "+high);
                if(val>=a.get(mid))
                    low=mid+1;
                else
                    high=mid;
            }
            return low;
        }

    }
