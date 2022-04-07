package com.company;

import java.util.Arrays;

public class MergeSort {
    public  static  void mergeSort(int [] arr, int start, int end)
    {

        if (start < end){
            int mid = (int)Math.floor((start + end)/ 2);
            mergeSort(arr, start, mid);
            mergeSort(arr,mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void  merge(int [] arr, int start, int mid, int end)
    {
        int [] temporaryArr = new int[end - start + 1];

        int startPosition = start, midPosition = mid + 1, counterPlacer = 0;

        //sort them out
        while (startPosition <= mid && midPosition <= end){
            if (arr[startPosition] <= arr[midPosition]){
                temporaryArr[counterPlacer] = arr[startPosition];
                counterPlacer++;
                startPosition++;
            }else{
                temporaryArr[counterPlacer] = arr[midPosition];
                counterPlacer++;
                midPosition++;
            }
        }

        //remaining any last indexed element in any of the sub-array that's remaining
        while (startPosition <= mid){
            temporaryArr[counterPlacer] = arr[startPosition];
            counterPlacer++;
            startPosition++;
        }

        while (midPosition <= end){
            temporaryArr[counterPlacer] = arr[midPosition];
            counterPlacer++;
            midPosition++;
        }

        for (int i = start; i <=end; i++){
            arr[i] = temporaryArr[i - start];
        }
    }


    public static void solutionMergeSort(int [] arr, int start, int end){
        System.out.println("UnSorted Array: " + Arrays.toString(arr));
        mergeSort(arr, start, end);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
