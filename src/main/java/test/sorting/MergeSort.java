package test.sorting;

public class MergeSort {
    public static void main(String[] args)
    {
        int[] inputArray = {99,100,10,38398,2,3,1};
        mergeSortWrapper(inputArray);

    }
    static void mergeSortWrapper(int[] inputArray)
    {

        printArray(inputArray);
        if(inputArray.length <=1 ) return;
        mergeSort(inputArray,0,inputArray.length -1);
        printArray(inputArray);
    }
    static void printArray(int arr[])
    {
        int n = arr.length;

        for (int i=0; i<n; ++i) {
            if (i==0) System.out.print("[ ");
            System.out.print(arr[i] + " ");
            if (i==n-1) System.out.print("]");

        }
        System.out.println();
    }

    static void mergeSort(int[] input , int iBeginIndex,int iEndIndex)
    {
        //find mid and split the arrays
        if (iBeginIndex < iEndIndex) {
            int mid = (iEndIndex + iBeginIndex) / 2 ;
            mergeSort(input, iBeginIndex, mid);
            mergeSort(input, mid + 1, iEndIndex);
            merge2arrays(input, iBeginIndex, mid, iEndIndex);
        }

    }

    static void merge2arrays(int[] input,int i,int j,int k)
    {
        int leftLength = j-i+1;
        int rightLength =k-j;
       int[] L = new int[leftLength];
        int[] R = new int[rightLength];
        //merge left and right
        for (int index=0;index<leftLength; index++)
        {
            L[index] = input[i+index];
        }
        for (int index=0;index<rightLength ;index++)
        {
            R[index] = input[j+1+index];
        }
        //merge the left and right arrays
        int x=0;
        int y=0;
        int initialIndex = i;
        while(x<leftLength && y<rightLength)
        {
            if (L[x] <= R[y]) //this means fill the current position with L[x] and increment x
            {
                input[initialIndex] = L[x];x++;

            }
            else
            {
                input[initialIndex] = R[y];y++;
            }
            initialIndex++;
        }
        //put the remaining x and y
        while (x<leftLength)
        {
            input[initialIndex] = L[x];x++;initialIndex++;
        }
        while (y<rightLength)
        {
            input[initialIndex] = R[y];y++;;initialIndex++;
        }

    }
}
