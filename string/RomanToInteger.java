package string;
/*
* Roman To Integer
Given a string A representing a roman numeral. Convert A into integer.

A is guaranteed to be within the range from 1 to 3999.

NOTE: Read more details about roman numerals at Roman Numeric System


Input Format

The only argument given is string A.
Output Format

Return an integer which is the integer verison of roman numeral string.
For Example

Input 1:
    A = "XIV"
Output 1:
    14

Input 2:
    A = "XX"
Output 2:
    20
    * */
public class RomanToInteger {
        public int romanToInt(String A) {

            int num=0;
            int res=0;
            for(int i=0;i<A.length();i++)
            {
                int val=num(A.charAt(i));
                if(i+1<A.length())
                {
                    int val2=num(A.charAt(i+1));
                    if(val>=val2)
                        res+=val;
                    else
                    {
                        res+=val2-val;
                        i++;
                    }
                }
                else
                    res+=val;
            }
            return res;

        }


        public int num(char c)
        {
            switch(c)
            {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
            }
            return -1;
        }
    }

