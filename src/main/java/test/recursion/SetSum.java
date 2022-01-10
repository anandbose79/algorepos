package test.recursion;

import java.util.ArrayList;
import java.util.List;

public class SetSum {

    /*
     * Complete the function below.
     */

    private static List<String> sumList = new ArrayList();
    private static boolean result = false;
    private static int match = 0;
    static boolean checksum(int k) {
        int[] numbs = {1,2,3,4,5};
       // String[] opArray = new String[opl.size()];
        //opl.toArray(opArray);

        match = k;
        String slate ="";
        helper(numbs,0,0,slate);
        printArray(sumList);
        return result;
    }



    private static void helper(int[] input, int idx , int sum , String slate)
    {
        if (sum == match && slate.length() >=2) { result = true;sumList.add(slate);return;}
        if (input.length != idx)
        //{ }
     //   else
        {
            helper(input,idx+1,sum,slate);
          //  slate.add(input[idx+1]);
            helper(input,idx+1, sum+input[idx] , slate + String.valueOf(input[idx]));
        }

    }
    public static void main(String args[])
    {
       int k=9;
       System.out.print(checksum(k));


    }

    private static void printArray(String[] s) {
        System.out.print("[");
        for (int i=0;i<s.length;i++)
            System.out.print("\""+s[i]+"\", ");
        System.out.println("]");

    }
    private static void printArray(List<String> input) {
        System.out.print("[");
        for (String i : input )
            System.out.print("\""+i +"\", ");
        System.out.println("]");

    }

}
