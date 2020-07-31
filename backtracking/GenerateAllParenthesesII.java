package backtracking;

import java.util.ArrayList;
/*
* Generate all Parentheses II
Problem Description

Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.



Problem Constraints
1 <= A <= 20



Input Format
First and only argument is integer A.



Output Format
Return a sorted list of all possible paranthesis.



Example Input
Input 1:

A = 3
Input 2:

A = 1


Example Output
Output 1:

[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:

[ "()" ]


Example Explanation
Explanation 1:

 All paranthesis are given in the output list.
Explanation 2:

 All paranthesis are given in the output list.
 * */
public class GenerateAllParenthesesII {
        public ArrayList<String> generateParenthesis(int A) {

            return generate(new ArrayList<String>(),new StringBuilder(),A,0,0,0);
        }

        public ArrayList<String> generate(ArrayList<String>  res, StringBuilder sb, int A ,int open, int closed, int index)
        {
            if(open==A && closed==A)
            {
                res.add(sb.toString());
                return res;
            }

            for(int i=index;i<2*A;i++)
            {
                if(open<A)
                {
                    sb.append('(');
                    generate(res,sb,A,open+1,closed,i+1);
                    sb.deleteCharAt(sb.length()-1);
                }
                if(open>closed)
                {
                    sb.append(')');
                    generate(res,sb,A,open,closed+1,i+1);
                    sb.deleteCharAt(sb.length()-1);
                }
            }

            return res;


        }
    }

