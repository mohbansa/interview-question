package sorting;

import java.util.Map;
import java.util.TreeMap;
/*
* Team distribution
To extend the family of the Guardians of Galaxy, Groot and Rocket are conducting interviews of 2*N potential candidates.

They have reached the round of team activity where the candidates will be divided into 2 teams of size N.

Each candidate has with him associated an integer which denotes his strength.

In a battle between 2 candidates, the one with higher strength wins. If 2 candidates have the same strength, either of them can win.

This is given by an array of size 2*N.

Now Rocket wants to know if it is possible to divide the candidates into teams such that each candidate of a particular team can defeat each candidate of the other team without any uncertainty.

Find out if it is possible or not.

Constraints:

1<= Size of array <=100000
Input: An array A denoting the strength of candidates of size 2*N

Output: Yes if it is possible to form a team with given conditions else No

Example:

Input:

A:[1 2 3 2 2 4 5 10]
Output:

Yes
* */
public class TeamDistribution {
    public String solve(int[] A) {
        TreeMap<Integer,Integer> inp=new TreeMap<>();
        for(int i=0;i<A.length;i++)
        {
            if(!inp.containsKey(A[i]))
                inp.put(A[i],0);
            inp.put(A[i],inp.get(A[i])+1);

        }

        int sum=0;
        for (Map.Entry<Integer,Integer> m:inp.entrySet())
        {
            sum=sum+m.getValue();
            if(sum==A.length/2)
                return "Yes";
            if(sum>A.length/2)
                return "No";

        }
        return "No";
    }
}
