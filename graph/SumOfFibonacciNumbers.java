package graph;


import java.util.ArrayList;

/*
* Sum Of Fibonacci Numbers
How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N? Note : repetition of number is allowed.

Example:

N = 4
Fibonacci numbers : 1 1 2 3 5 .... so on
here 2 + 2 = 4
so minimum numbers will be 2
* */

public class SumOfFibonacciNumbers {
    public int fibsum(int A) {

        if(A<=2) return 1;

        ArrayList<Integer> inp=new ArrayList<Integer>();
        inp.add(1);
        inp.add(1);

        while(inp.get(inp.size()-1)<A)
        {
            int n=inp.size();
            inp.add(inp.get(n-1)+inp.get(n-2));
        }


        int j=inp.size()-1;
        int count=0;
        while(A>0)
        {
            count+=(A/inp.get(j));
            A%=inp.get(j);
            j--;
        }
        return count;


    }
}
