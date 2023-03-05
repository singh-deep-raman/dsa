package in.singh.raman.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {
           229,  837, 246, 537, 309, 779, 734, 111, 751, 495, 252, 985, 336, 849,1
        };

        System.out.println("Array before sorting : "+ Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("Array after sorting : "+Arrays.toString(arr));
    }

    /**
     * Selection sort traverses the whole array, picks the minimum element, swap with first unsorted element of the array.
     * Above procedure is repeated for all the remaining unsorted elements.
     */
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min_idx = i;
            // traverse over unsorted elements
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            // swap the elements
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }
}
