/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3;

/**
 *
 * @author bong
 */
public class QuickSort extends Sort {

    public void quickSort(int low, int high) {
        if (low < high) {
            int j = partition(low, high);
            quickSort(low, j - 1);
            quickSort(j + 1, high);
        }
    }

    public int partition(int low, int high) {
        int pivot = array[low];
        int i = low + 1;
        int j = high;
        while (i <= j) {
            while (i <= high && array[i] <= pivot) {
                i++;
            }
            while (j >= low && array[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(i, j);
            }
        }
        swap(low, j);
        return j;
    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
