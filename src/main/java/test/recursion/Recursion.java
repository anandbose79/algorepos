package test.recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

    /*
     * Complete the function below.
     */
    static String[] generate_all_subsets(String s) {
        List<String> opl = getAll(s.toCharArray());
       String[] opArray = new String[opl.size()];
      opl.toArray(opArray);
        return opArray;
    }

    private static List<String> getAll(char[] s)
    {
        List<String> output = new ArrayList<String>();
        helper(output,s,0,"");return output;

    }

    private static void  helper(List<String> myList, char[] s , int idx , String slate)
    {
        if (s.length == idx) myList.add(slate);
        else{
            helper(myList,s,idx+1,slate);
            helper(myList,s, idx+1, slate + String.valueOf(s[idx]));
        }

    }
    public static void main(String args[])
    {
        String s="Please";
        printArray(generate_all_subsets( s));

    }

    private static void printArray(String[] s) {
        System.out.print("[");
        for (int i=0;i<s.length;i++)
            System.out.print("\""+s[i]+"\", ");
        System.out.println("]");

    }

}
