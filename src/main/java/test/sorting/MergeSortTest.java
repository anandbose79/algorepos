package test.sorting;

public class MergeSortTest
{
    public static void main(String[] args)
    {
        int[] inputArray = {9,5,4,6,10};
        printArray(inputArray);
        mergeSort(inputArray);
        printArray(inputArray);

    }

    private static void mergeSort(int[] inputArray) {
        sort(inputArray,0,inputArray.length-1);
    }

    private static void sort(int[] inputArray, int iBegin, int iEnd) {
        if (iBegin < iEnd)
        {
            int mid = (iBegin + iEnd)/2;
            sort(inputArray,iBegin,mid);
            sort(inputArray,mid+1,iEnd);
            merge(inputArray,iBegin,mid,iEnd);
        }
    }

    private static void merge(int[] inputArray, int iBegin, int mid, int iEnd) {
        int lLength = mid- iBegin +1;
        int rLength = iEnd - mid;

        int[] L = new int[lLength];
        int[] R = new int[rLength];

        for (int i=0;i<lLength;i++)
            L[i] = inputArray[iBegin+i];
        for (int i=0;i<rLength;i++)
            R[i]= inputArray[mid+1+i];

        //merge arrays
        int i=0;
        int j=0;
        int k = iBegin;
        while (i< lLength && j<rLength)
        {
            if (L[i] <= R[j])
            {
                inputArray[k] = L[i];i++;
            }
            else
            {
                inputArray[k] = R[j];j++;
            }
            k++;
        }
        while (i<lLength)
        {
            inputArray[k] = L[i];i++;k++;
        }
        while (j<rLength)
        {
            inputArray[k] = R[j];j++;k++;
        }
    }

    private static void printArray(int[] inputArray) {
        System.out.print("[ ");
        for (int i=0;i<inputArray.length;i++)
            System.out.print(" "+inputArray[i]);
        System.out.print(" ]");

    }
}
