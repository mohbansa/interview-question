package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
* Smallest Multiple With 0 and 1
Problem Description

You are given an integer A. You have to find smallest multiple of A which consists of digits 0 and 1 only.

Since this multiple could be large, return it in form of a string.

NOTE: Returned string should not contain leading zeroes.



Problem Constraints
1 <= A <= 105



Input Format
First and only argument is an integer A.



Output Format
Return a string denoting the above answer.



Example Input
Input 1:

 A = 55
Input 2:

 A = 2


Example Output
Output 1:

 110
Output 2:

 10


Example Explanation
Explanation 1:

 110 is the smallest multiple of 55 which consist of only 0 and 1.
Explanation 2:

 10 is the smallest multiple of 2 which consist of only 0 and 1.
 * */
public class SmallestMultipleWith0and1 {
/*public class Solution {
    HashMap<String, Integer> inp=new HashMap<String, Integer>();
    public String multiple(int A) {
        if(A==1) return "1";
        Queue<String> q=new LinkedList<String>();
        Set<Integer> set=new HashSet<Integer>();
        q.add("1");

        inp.put("1",1);
        while(!q.isEmpty())
        {
            String str=q.poll();
            int rem=check(str,A);

            if(rem==0)
                return str;


            if(!set.contains(rem))
            {
                set.add(rem);
            q.add(str+"0");
            q.add(str+"1");
            }

        }
        return null;
    }

    public int check(String s, int n)
    {


        if(s.length()>1)
            {
               // System.out.println(s+" "+inp.get(s.substring(0,s.length()-1)));
                int r=inp.get(s.substring(0,s.length()-1));
                r=r*10+(s.charAt(s.length()-1)-'0');
                r= r%n;

                inp.put(s,r);
                return r;


            }

        return 1;





    }
}*/


        public String multiple(int A) {
            int[] par=new int[A+1];
            int[] val=new int[A+1];
            int[] flag=new int[A+1];
            Arrays.fill(par,-1);
            Arrays.fill(val,-1);
            Arrays.fill(flag,0);
            par[1%A]=-1;
            val[1%A]=1;
            flag[1%A]=1;

            Queue<Integer> q=new LinkedList<Integer>();
            q.add(1%A);
            while(!q.isEmpty())
            {
                int p=q.poll();

                if(p==0)
                {
                    StringBuilder sb=new StringBuilder();

                    while(p!=-1)
                    {

                        sb.append(val[p]);
                        p=par[p];
                    }
                    return sb.reverse().toString();
                }


                int p1=(p*10)%A;
                int p2=((p*10)+1)%A;
                if(flag[p1]==0)
                {
                    par[p1]=p;
                    val[p1]=0;
                    flag[p1]=1;
                    q.add(p1);
                }

                if(flag[p2]==0)
                {

                    par[p2]=p;
                    val[p2]=1;
                    flag[p2]=1;
                    q.add(p2);
                }

            }

            return "";

        }

    }

