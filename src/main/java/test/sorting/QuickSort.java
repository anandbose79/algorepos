package test.sorting;

import java.util.Random;

public class QuickSort
{
    public static void main(String[] args)
    {
      //  int[] inputArray = {-1,3,100,9,5,4,4,5,88,8,1,7,1,200};
        int[] inputArray = {6,-1,3,5,3,3,2};
        printArray(inputArray);
        quickSort(inputArray);
        printArray(inputArray);

    }



    private static void quickSort(int[] inputArray) {
        sort(inputArray,0,inputArray.length-1);
    }

    private static void sort(int[] inputArray, int iBegin, int iEnd) {
        if (iBegin < iEnd)
        {
            int pi = pivotHoares(inputArray,iBegin,iEnd);
            sort(inputArray,iBegin,pi-1);
            sort(inputArray,pi+1,iEnd);
        }





    }

    private static int pivotLomuto(int[] inputArray, int iBegin, int iEnd) {

        int length = iEnd - iBegin + 1;
        Random rand = new Random();
        int iIndex = rand.nextInt(length);
        int pivot = inputArray[iBegin+iIndex];
        //swap pivot with the first element
        swap(inputArray,iBegin,iBegin+iIndex);
        //start lamutos algo
        int i = iBegin+1;
        int j = i-1;
        while (i-iBegin<length)
        {
            if (inputArray[i] < pivot)
            {
                j++;
                swap(inputArray,i,j);
            }
            i++;
        }
        //pivot should be now swapped with j
        swap(inputArray,iBegin,j);
        return j;
    }

    private static int pivotHoares(int[] inputArray, int iBegin, int iEnd) {
        int length = iEnd - iBegin + 1;
        Random rand = new Random();
        int iIndex = rand.nextInt(length);
        int pivot = inputArray[iBegin+iIndex];
        int i = iBegin;
        int j = iEnd;

        while (j>=i)
        {
            while  (inputArray[i] <= pivot) i++;
            while  (inputArray[j] > pivot ) j--;
            swap(inputArray,i,j);
        }
        //pivot should be now swapped with j


        return i;
    }



        private static void swap(int[] inputArray, int i1, int i2) {
        int temp = inputArray[i1];
        inputArray [i1] = inputArray[i2];
        inputArray[i2] = temp;
    }


    private static void printArray(int[] inputArray) {
        System.out.print("[ ");
        for (int i=0;i<inputArray.length;i++)
            System.out.print(" "+inputArray[i]);
        System.out.print(" ]");

    }
}
