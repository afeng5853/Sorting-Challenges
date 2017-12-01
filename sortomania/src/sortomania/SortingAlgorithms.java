package sortomania;

import java.util.Arrays;

public class SortingAlgorithms {
	/**
	 * Swaps two objects in an array
	 * @param list the array with the objects
	 * @param i the object to be swapped
	 * @param j them object to be swapped
	 */
	
	private static void swap(Object[] list, int i, int j) {
		Object temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	/**
	 * Swaps two integers in an array
	 * @param list the array with the integers
	 * @param i the integer to be swapped
	 * @param j them integer to be swapped
	 */
	
	private static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	/**
	 * Swaps two doubles in an array
	 * @param list the array with the doubles
	 * @param i the double to be swapped
	 * @param j them double to be swapped
	 */
	
	private static void swap(double[] list, int i, int j) {
		double temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	/**
	 * Sorts an array using insertion sort
	 * @param list1 the array to be sorted
	 */
	
	public static Void insertionSort(int[] list1) {
		for (int i = 1; i < list1.length; i++) {
			int j = i-1;
			int k = i;
			while (j != -1 && list1[k] < list1[j]) {
				swap(list1, k, j);
				j--;
				k--;
			}
		}
		return null;
	}
	
	/**
	 * Returns the minimum value in an interval of an array
	 * @param list the array to be searched through
	 * @param start the beginning index
	 * @param end the end index
	 * @return the minimum integer of an array in a set interval
	 */
	private static int min(int[] list, int start, int end) {
		if (list.length == 0) {
			return -1;
		}
		double min = list[start];
		int minIdx = start;
		for (int i = start + 1; i < end; i++) {
			if (list[i] < min) {
				min = list[i];
				minIdx = i;
			}
		}
		return minIdx;
	}
	
	/**
	 * Sorts an array using selection sort
	 * @param list1 the array to be sorted
	 */
	public static Void selectionSort(int [] list1) {
		for (int i = 0; i < list1.length; i++) {
			int minIdx = min(list1, i, list1.length);
			swap(list1, i, minIdx);
		}
		return null;
	}
	/**
	 * Sorts an array using bubble sort
	 * @param list1 the array to be sorted
	 */
	public static Void bubbleSort(String [] list1) {
		int swaps = 0;
		for (int i = 1; i < list1.length; i++) {
			if (list1[i].compareTo(list1[i-1]) < 0) {
				swap(list1, i, i-1);
				swaps++;
			}
			if (i == list1.length - 1) {
				if (swaps == 0) {
					break;
				} else {
					swaps = 0;
					i = 1;
				}
			}
		}
		return null;
	}
	
	public static int partition(int[] list, int a, int b) {
		// if list is empty
		if (list.length == 0) {
			return -1;
		}
		int pivot = list[a]; // set pivot to first item
		int j = a; // current index to swap for items less than the pivot
		int pivotIdx = a;
		for (int i = a + 1; i < b; i++) {
			if (list[i] <= pivot) {
				// track pivot index 
				if (pivotIdx == j) {
					pivotIdx = i;
				}
				// swap pivot to latest index in the small partition
				int temp = list[j];
				list[j] = list[i];
				list[i] = temp;
				j++;
			}
			
		}
		// return pivot to correct location
		int temp = list[pivotIdx];
		list[pivotIdx] = list[j];
		list[j] = temp;
		return j;
	}

	/**
	 * Sorts an array using quick sort
	 * @param arr the array to be sorted
	 * @param i the start index
	 * @param j the end index
	 */
	
	public static Void quickSort(int[] arr, int i, int j) {
		if (j - i <= 1) {
			return null; 
		}
		else {
			//CopyArrays.printArray(arr);
			int pivotIdx = partition(arr, i, j);
			quickSort(arr, i, pivotIdx);
			quickSort(arr, pivotIdx + 1, j);
			return null;
		}
	}
	
	/**
	 * Sorts an array of integers using counting sort
	 * 
	 * Pros: O(n) for integers
	 * Cons: A limited range of integers has to be specified
	 * 		 Range of integers is limited by memory
	 * 
	 * For the first iteration, record the number of occurrences of an integer in an integer array with the key being the number
	 * and the value being the number of occurrences
	 * 
	 * For the second iteration, insert each number starting from 0 to n (where n is the max) with the respective number of occurrences
	 * @param arr
	 * @return
	 */
	public static int[] countingSort(int[] arr) {
		int[] stored = new int[65536];
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			stored[num]++;
		}
		int resultIdx = 0;
		for (int i = 0; i < stored.length; i++) {
			while (stored[i] > 0) {
				result[resultIdx++] = i;
				stored[i]--;
			}
		}
		return result;
	}
	
	/**
	 * merges two sorted arrays and sorts it
	 * @param list1 a sorted array
	 * @param list2 a sorted array
	 * @return a sorted merged array
	 */
	public static String[] merge(String[] list1, String[] list2) {
		String[] result = new String[list1.length + list2.length];
		int i = 0; // list 1 index
		int j = 0; // list 2 index
		int resultIdx = 0;
		while (i < list1.length || j < list2.length) {
			if (i == list1.length) {
				result[resultIdx] = list2[j];
				j++;
			}
			else if (j == list2.length) {
				result[resultIdx] = list1[i];
				i++;
			}
			else if (list1[i].compareTo(list2[j]) < 0) {
				result[resultIdx] = list1[i];
				i++;
			}
			else {
				result[resultIdx] = list2[j];
				j++;
			}
			resultIdx++;
		}	
		
		return result;
	}
	
	/**
	 * sorts array based on the merge sort algorithm
	 * @param list the array to be sorted
	 * @return a sorted array
	 */
	public static String[] mergeSort(String[] list) {
		if (list.length <= 1) {
			return list;
		}
		else {
			int mid = list.length / 2;
			String[] split1 = Arrays.copyOfRange(list, 0, mid);
			String[] split2 = Arrays.copyOfRange(list, mid, list.length);
			return merge(mergeSort(split1), mergeSort(split2));
		}
	}
}
