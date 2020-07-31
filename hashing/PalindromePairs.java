package hashing;

import java.util.ArrayList;
import java.util.HashMap;
/*
* Palindrome Pairs
Problem Description

Given a list of unique words A, find all pairs of distinct indices (i, j) in the given list such that concatenation of the two words, i.e. A[i] + A[j] is a palindrome.

Note: A string is a palindrome if it reads the same backward as forward.



Problem Constraints
1 <= length of the list A <= 1000

1 <= lenght of words in list A <= 100



Input Format
The only argument given is the string array A.



Output Format
Return the list of all pairs of distinct indices such that concatenation of the two words, i.e. A[i] + A[j] is a palindrome.

You can return the list in any order.



Example Input
Input 1:

 A = ["abcd", "dcba", "lls", "s", "sssll"]
Input 2:

 A =  ["bat", "tab", "cat"]


Example Output
Output 1:

 [ [0,1], [1,0], [3,2], [2,4] ]
Output 2:

 [[0,1],[1,0]]


Example Explanation
Explanation 1:

 The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Explanation 2:

 The palindromes are ["battab","tabbat"]
 * */
public class PalindromePairs {
        public ArrayList<ArrayList<Integer>> solve(ArrayList<String> A) {
            HashMap<String,Integer> inp=new HashMap<String,Integer>();
            ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<A.size();i++)
                inp.put(A.get(i),i);
            for(int i=0;i<A.size();i++)
            {
                for(int j=0;j<A.get(i).length();j++)
                {
                    String s1=A.get(i).substring(0,j);
                    String s2=A.get(i).substring(j);
                    if(check(s1))
                    {
                        StringBuilder sb=new StringBuilder(s2);
                        String s2rev=sb.reverse().toString();

                        if(inp.containsKey(s2rev) && inp.get(s2rev) !=i)
                        {

                            ArrayList<Integer> temp=new ArrayList<Integer>();
                            temp.add(inp.get(s2rev));
                            temp.add(i);

                            res.add(temp);
                        }
                    }
                    if(check(s2))
                    {
                        StringBuilder sb=new StringBuilder(s1);
                        String s1rev=sb.reverse().toString();
                        if(inp.containsKey(s1rev) && inp.get(s1rev) !=i)
                        {
                            ArrayList<Integer> temp=new ArrayList<Integer>();
                            temp.add(i);
                            temp.add(inp.get(s1rev));
                            res.add(temp);
                        }
                    }
                }
            }

            return res;
        }

        public boolean check(String str)
        {
            // System.out.println(str +" "+str.length());
            int i=0;
            int j=str.length()-1;
            while(i<j)
            {
                if(str.charAt(i)!=str.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }
    }

