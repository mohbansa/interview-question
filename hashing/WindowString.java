package hashing;

import java.util.HashMap;
/*
* Window String
Problem Description

Given a string A and a string B, find the window with minimum length in A which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in minimum window in A should be at least x.

Note:

If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index )


Problem Constraints
1 <= size(A), size(B) <= 106



Input Format
First argument is a string A.
Second argument is a string B.



Output Format
Return a string denoting the minimum window.



Example Input
Input 1:

 A = "ADOBECODEBANC"
 B = "ABC"
Input 2:

 A = "Aa91b"
 B = "ab"


Example Output
Output 1:

 "BANC"
Output 2:

 "a91b"


Example Explanation
Explanation 1:

 "BANC" is a substring of A which contains all characters of B.
Explanation 2:

 "a91b" is the substring of A which contains all characters of B.
 * */
public class WindowString {
        public String minWindow(String A, String B) {

            HashMap<Character,Integer> inp=new HashMap<Character,Integer> ();
            for(int i=0;i<B.length();i++)
            {
                if(!inp.containsKey(B.charAt(i)))
                    inp.put(B.charAt(i),1);
                else
                    inp.put(B.charAt(i),inp.get(B.charAt(i))+1);
            }
            int c=B.length();
            int d=Integer.MAX_VALUE;
            int begin=0;
            int head=0;
            for(int i=0;i<A.length();i++)
            {
                if(inp.containsKey(A.charAt(i)))
                {
                    inp.put(A.charAt(i),inp.get(A.charAt(i))-1);
                    if(inp.get(A.charAt(i))>=0)
                        c--;
                }
                while(c==0)
                {
                    if(i-begin<d)
                    {
                        d=i-begin;
                        head=begin;
                    }
                    if(inp.containsKey(A.charAt(begin)))
                    {
                        inp.put(A.charAt(begin),inp.get(A.charAt(begin))+1);
                        if(inp.get(A.charAt(begin))>0)
                            c++;


                    }
                    begin++;
                }
            }
            //System.out.println(head+" "+d);
            return d==Integer.MAX_VALUE?"":A.substring(head,head+d+1);


        }
    }

