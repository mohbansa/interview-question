package string;

import java.util.ArrayList;
/*
* Longest Common Prefix
Problem Description

Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Problem Constraints
0 <= sum of length of all strings <= 1000000



Input Format
The only argument given is an array of strings A.



Output Format
Return the longest common prefix of all strings in A.



Example Input
Input 1:

A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:

A = ["abab", "ab", "abcd"];


Example Output
Output 1:

"a"
Output 2:

"ab"


Example Explanation
Explanation 1:

Longest common prefix of all the strings is "a".
Explanation 2:

Longest common prefix of all the strings is "ab".
* */
public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> A) {
        String prefix=A.get(0);


        for(int i=1;i<A.size();i++)
        {
            while(prefix.length()>0 && A.get(i).indexOf(prefix)!=0)
            {
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }

        return prefix;
    }
}
