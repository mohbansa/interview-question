package hashing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
* Valid Sudoku
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

 Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
* */
public class ValidSudoku {
    public int isValidSudoku(final List<String> A) {
        Set<String> inp=new HashSet<>();
        for(int i=0;i<A.size();i++)
        {
            for(int j=0;j<A.get(i).length();j++)
            {


                if(A.get(i).charAt(j)!='.')
                {
                    String s="("+A.get(i).charAt(j)+")";
                    if(!inp.add(s+i) || !inp.add(j+s) ||!inp.add((i/3)+s+(j/3)))
                        return 0;
                }
            }
        }

        return 1;
    }
}
