package backtracking;

import java.util.ArrayList;
/*
* Palindrome Partitioning
Problem Description

Given a string A, partition A such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of A.

Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
(len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))


Problem Constraints
1 <= len(A) <= 15



Input Format
First argument is a string A of lowercase characters.



Output Format
Return a list of all possible palindrome partitioning of s.



Example Input
Input 1:

A = "aab"
Input 2:

A = "a"


Example Output
Output 1:

 [
    ["a","a","b"]
    ["aa","b"],
  ]
Output 2:

 [
    ["a"]
  ]


Example Explanation
Explanation 1:

In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
Explanation 2:

In the given example, only partition possible is "a" .
* */
public class PalindromePartitioning {
        public ArrayList<ArrayList<String>> partition(String a) {

            return part(new ArrayList<ArrayList<String>>(),new ArrayList<String>(), a, 0);
        }

        public ArrayList<ArrayList<String>> part( ArrayList<ArrayList<String>> res, ArrayList<String> inp, String a, int index)
        {
            if(index==a.length())
            {
                res.add(new ArrayList<String>(inp));
                return res;
            }
            for(int i=index;i<a.length();i++)
            {
                if(pal(a,index,i))
                {
                    // System.out.println(a.substring(index,i+1));
                    inp.add(a.substring(index,i+1));
                    part(res,inp,a,i+1);
                    inp.remove(inp.size()-1);
                }
            }
            return res;
        }

        public boolean pal(String a, int start, int end)
        {
            while(start<end)
            {
                if(a.charAt(start)!=a.charAt(end))
                    return false;
                start++;
                end--;
            }
            return true;
        }
    }

