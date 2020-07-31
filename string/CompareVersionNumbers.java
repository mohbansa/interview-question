package string;
/*
* Compare Version Numbers
Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character. The . character does not represent a decimal point and is used to separate number sequences. For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
* */
public class CompareVersionNumbers {
    public class Solution {
        public int compareVersion(String s1, String s2) {
            int i=0;
            int j=0;
            while(i<s1.length() && j<s2.length())
            {
                String a="";
                String b="";
                while(i<s1.length() && s1.charAt(i)!='.')
                    a+=s1.charAt(i++);
                while(j<s2.length() && s2.charAt(j)!='.')
                    b+=s2.charAt(j++);
                int c=check(a,b);
                if(c==0)
                {
                    a="";
                    b="";
                    i++;j++;

                }
                else
                    return c;


            }

//System.out.println(i+" "+j);


            if(i<s1.length())
            {
                String sub=s1.substring(i);
                if (sub.matches("^[.0]+$")) return 0;
                return 1;
            }
            if(j<s2.length())
            {
                String sub=s2.substring(j);
                if (sub.matches("^[.0]+$")) return 0;
                return -1;
            }

            return 0;
        }

        public int check(String a, String b)
        {

            a=a.replaceFirst("^0+(?!$)", "");
            b=b.replaceFirst("^0+(?!$)", "");
            if(a.length()>b.length()) return 1;
            if(a.length()<b.length()) return -1;

            int i=0;
            while(i<a.length())
            {
                if(a.charAt(i)==b.charAt(i))
                {
                    i++;
                    continue;
                }

                return Character.compare(a.charAt(i), b.charAt(i))>0?1:-1;


            }
            return 0;

        }
    }

}
