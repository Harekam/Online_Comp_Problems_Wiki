package com.code.progs;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int arr[] = { 7, 6, 5, 4, 3, 2, 1, 0, 1234, 90, 5345, 124 };
		quickSort(arr, 0, 11);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int arr[], int start, int end) {
		if (start < end) {
			int partitionIndex = partition(arr, start, end);
			quickSort(arr, start, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {

		int pivot = arr[end];
		int partitionIndex = start;
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, partitionIndex);

				partitionIndex++;
			}
		}
		swap(arr, partitionIndex, end);
		return partitionIndex;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
