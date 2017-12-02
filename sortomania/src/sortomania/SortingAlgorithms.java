package sortomania;

import java.util.ArrayList;
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

	public static double insertionSort(int[] list1) {
		for (int i = 1; i < list1.length; i++) {
			int j = i-1;
			int k = i;
			while (j != -1 && list1[k] < list1[j]) {
				swap(list1, k, j);
				j--;
				k--;
			}
		}
		return median(list1, 10000);
	}

	/**
	 * string version
	 * @param list1
	 * @return
	 */
	public static double insertionSort(String[] list1) {
		for (int i = 1; i < list1.length; i++) {
			int j = i-1;
			int k = i;
			while (j != -1 && list1[k].compareTo(list1[j]) < 0) {
				swap(list1, k, j);
				j--;
				k--;
			}
		}
		return 0;
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
	public static double selectionSort(int [] list1) {
		for (int i = 0; i < list1.length; i++) {
			int minIdx = min(list1, i, list1.length);
			swap(list1, i, minIdx);
		}
		return median(list1, 10000);
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

	public static int partition(String[] list, int a, int b) {
		// if list is empty
		if (list.length == 0) {
			return -1;
		}
		String pivot = list[a]; // set pivot to first item
		int j = a; // current index to swap for items less than the pivot
		int pivotIdx = a;
		for (int i = a + 1; i < b; i++) {
			if (list[i].compareTo(pivot) < 0) {
				// track pivot index
				if (pivotIdx == j) {
					pivotIdx = i;
				}
				// swap pivot to latest index in the small partition
				swap(list, i, j);
				j++;
			}

		}
		// return pivot to correct location
		swap(list, pivotIdx, j);
		return j;
	}

	/**
	 * Sorts an array using quick sort
	 * @param arr the array to be sorted
	 * @param i the start index
	 * @param j the end index
	 */

	public static double quickSort(int[] arr, int i, int j) {
		if (j - i <= 1) {
			return 0;
		}
		else {
			//CopyArrays.printArray(arr);
			int pivotIdx = partition(arr, i, j);
			quickSort(arr, i, pivotIdx);
			quickSort(arr, pivotIdx + 1, j);
			return median(arr, arr.length);
		}
	}

	/**
	 * string version
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	public static double quickSort(String[] arr, int i, int j) {
		if (j - i <= 1) {
			return 0;
		}
		else {
			//CopyArrays.printArray(arr);
			int pivotIdx = partition(arr, i, j);
			quickSort(arr, i, pivotIdx);
			quickSort(arr, pivotIdx + 1, j);
			return 0;
		}
	}

	private static double median(int[] a, int len) {
		return (a[len/2-1] + a[len/2]) / 2;
	}

	private static double median(double[] a, int len) {
		return (a[len/2-1] + a[len/2]) / 2;
	}

	public static double bucketSort(int[] a) {
	      int [] bucket=new int[10001];

	      for (int i=0; i<bucket.length; i++) {
	         bucket[i]=0;
	      }

	      for (int i=0; i<a.length; i++) {
	         bucket[a[i]]++;
	      }

	      int outPos=0;
	      for (int i=0; i<bucket.length; i++) {
	         for (int j=0; j<bucket[i]; j++) {
	            a[outPos++]=i;
	         }
	      }
	     return median(a, a.length);
	 }

	public static int mapChar(char letter) {
		if (Character.isLowerCase(letter)) {
			return ((int) letter) - 97;
		} else {
			System.out.println("woops mr levin, i thought string was alpha only");
		}
		return -1;
	}

	public static int bucketSort(String[] a, String search) {
	      String[][] bucket = new String[26][10000];
	      String[][] trimmedBucket = new String[26][];
	      int matchIdx = -1;
	      int[] indices = new int[26];
	      for (int i=0; i <a.length; i++) {
	    	  String current = a[i];
	    	  int bucketIdx = mapChar(current.charAt(0));
	          bucket[bucketIdx][indices[bucketIdx]++] = current;
	      }

	      for (int i=0; i<bucket.length; i++) {
	    	  trimmedBucket[i] = Arrays.copyOf(bucket[i], indices[i]);
	      }

	      for (int i=0; i< trimmedBucket.length; i++) {
	    	  quickSort(trimmedBucket[i], 0, trimmedBucket[i].length);
	      }

	      int pos = 0;
	      for (int i = 0; i < trimmedBucket.length; i++) {
	    	  for (int j = 0; j < trimmedBucket[i].length; j++) {
	    		  if (trimmedBucket[i][j].equals(search))
	    			  matchIdx = pos;
	    		  a[pos++] = trimmedBucket[i][j];
	    	  }
	      }
	     return matchIdx;
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
	public static double countingSort(int[] arr) {
		int[] stored = new int[10001];
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			stored[num]++;
		}
		int resultIdx = 0;
		for (int i = 0; i < stored.length; i++) {
			while (stored[i] > 0) {
				arr[resultIdx] = i;
				stored[i]--;
				resultIdx++;
			}
		}
		return median(arr, arr.length);
	}

	private static void countingSort(int[] arr, int exp) {
		int[] stored = new int[10];
		int[] result = new int[arr.length];
		int i;
		for (i = 0; i < arr.length; i++) {
			int num = arr[i];
			stored[(num / exp) % 10]++;
		}
		for (i = 1; i < 10; i++) {
			stored[i] += stored[i - 1];
		}

	    for (i = arr.length-1 ; i >= 0; i--)
	    {
	    	result[stored[ (arr[i]/exp)%10 ] - 1] = arr[i];
	    	stored[ (arr[i]/exp)%10 ]--;
	    }

	    for (i = 0; i < arr.length; i++)
	        arr[i] = result[i];
	}


	private static int max(int[] a) {
		int max = a[0];
		for (int i = 1; i < 10000; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}

	public static double radixSort(int[] arr) {
		//int max = max(arr);
		for (int exp = 1; exp < 10000; exp *= 10) {
			countingSort(arr, exp);
		}
		return median(arr, arr.length);
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

	/**
	 * https://algs4.cs.princeton.edu/51radix/LSD.java.html
	 * @param a
	 * @param w
	 */
	public static int radixSort(String[] a, String match) {
        int n = a.length;
        int w = 5;
        int R = 256;   // extend ASCII alphabet size
        int matchIdx = -1;
        String[] aux = new String[n];

        for (int d = w-1; d >= 0; d--) {
            // sort by key-indexed counting on dth character

            // compute frequency counts
            int[] count = new int[R+1];
            for (int i = 0; i < n; i++)
                count[a[i].charAt(d) + 1]++;

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // move data
            for (int i = 0; i < n; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            // copy back
            for (int i = 0; i < n; i++) {
            	if (aux[i].equals(match))
            		matchIdx = i;
                a[i] = aux[i];
            }
        }
        return matchIdx;
    }

	public static double insertionSortMedians(int[][] arr, double[] medians) {
		for (int i = 1; i < medians.length; i++) {
			int j = i-1;
			int k = i;
			while (j != -1 && medians[k] < medians[j]) {
				swap(arr, k, j);
				swap(medians, k, j);
				j--;
				k--;
			}
		}
		return median(medians, 1000);
	}

	public static double countingSortMatrix(int[][] arr) {
		double[] medians = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			medians[i] = countingSort(arr[i]);
		}
		return insertionSortMedians(arr, medians);
	}

	public static double quickSortMatrix(int[][] arr) {
		double[] medians = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			medians[i] = quickSort(arr[i], 0, 1000);
		}
		return insertionSortMedians(arr, medians);
	}

	public static double radixSortMatrix(int[][] arr) {
		double[] medians = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			medians[i] = radixSort(arr[i]);
		}
		return insertionSortMedians(arr, medians);
	}

	public static double bucketSortMatrix(int[][] arr) {
		double[] medians = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			medians[i] = bucketSort(arr[i]);
		}
		return insertionSortMedians(arr, medians);
	}
}
