package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyDirectoryPath {
    public String simplifyPath(String inp) {
        StringBuilder res = new StringBuilder();
        String[] arr = inp.split("/");
        Deque st = new ArrayDeque();
        for(int i=0; i<arr.length; i++){
            if("".equals(arr[i]) || ".".equals(arr[i]));
            else if("..".equals(arr[i])) st.pollLast();
            else st.offerLast(arr[i]);
        }
        while(!st.isEmpty())  res.insert(0, "/" + st.pollLast());
        if(res.length() == 0) res.insert(0, "/");
        return res.toString();

    }
}
