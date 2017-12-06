package sortomania;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Team8SortCompetition extends SortCompetition {

	/**
	 * gets the median of an array (truncated)
	 * @param a the array
	 * @param len length of the array
	 * @return the median of the array (truncated)
	 */
	private int median(int[] a, int len) {
		return (a[len / 2 - 1] + a[len / 2]) / 2;
	}

	/**
	 * implementation of counting sort
	 * @param arr the array to be sorted
	 * @return the median of the array
	 */
	@Override
	public int challengeOne(int[] arr) {
		int[] stored = new int[10001]; // number of buckets = max num
		for (int i = 0; i < arr.length; i++) {
			stored[arr[i]]++; // fill the buckets with the integers
		}
		int resultIdx = 0;
		for (int i = 0; i < stored.length; i++) {
			for (int j = 0; j < stored[i]; j++) {
				arr[resultIdx++] = i; // copy the numbers
			}
		}
		return median(arr, arr.length);
	}
	
	/**
	 * implementation of radix sort
	 * @param a the array to be sorted
	 * @param match the string to be searched for
	 * @return the index of the desired string
	 */
	@Override
	public int challengeTwo(String[] a, String match) {
		int n = a.length;
		int w = 5;
		int R = 256;
		int matchIdx = -1;
		String[] aux = new String[n];

		for (int d = w - 1; d >= 0; d--) {
			int[] count = new int[R + 1];
			for (int i = 0; i < n; i++)
				count[a[i].charAt(d) + 1]++;

			for (int r = 0; r < R; r++)
				count[r + 1] += count[r];

			for (int i = 0; i < n; i++)
				aux[count[a[i].charAt(d)]++] = a[i];

			for (int i = 0; i < n; i++) {
				if (aux[i].equals(match))
					matchIdx = i;
				a[i] = aux[i];
			}
		}
		return matchIdx;
	}

	/**
	 * implementation of counting sort
	 * @param arr the array to be sorted
	 * @return the median of the array
	 */
	@Override
	public int challengeThree(int[] arr) {
		int[] stored = new int[10001]; // number of buckets = max num
		for (int i = 0; i < arr.length; i++) {
			stored[arr[i]]++; // fill the buckets with the integers
		}
		int resultIdx = 0;
		for (int i = 0; i < stored.length; i++) {
			for (int j = 0; j < stored[i]; j++) {
				arr[resultIdx++] = i; // copy the numbers
			}
		}
		return median(arr, arr.length);
	}

	/**
	 * parallel counting sort
	 * @param arr the array to be sorted
	 * @return the median of the 2-d array
	 */
	@Override
	public int challengeFour(int[][] arr) {
		ExecutorService executor = Executors.newCachedThreadPool();
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executor);
		for (final int[] row : arr) {
			Callable<Integer> c = new Callable<Integer>() {
				@Override
				public Integer call() {
					return countingSort(row);
				}
			};
			completionService.submit(c);
		}
	
		int received = 0;
		boolean errors = false;
	
		while (received < 1000 && !errors) {
			Future<Integer> resultFuture = null;
			try {
				resultFuture = completionService.take();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				resultFuture.get();
				received++;
			} catch (Exception e) {
				errors = true;
			}
		}
	
		int[] medians = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int[] row = arr[i];
			medians[i] = median(row, row.length);
		}
	
		return bucketSortMedians(arr, medians);
	}
	
	/**
	 * implementation of quicksort where the object is searched using binary search
	 * @param arr the array to be sorted
	 * @param obj the object to be searched
	 */
	@Override
	public int challengeFive(Comparable[] arr, Comparable obj) {
		quickSort(arr, 0, arr.length - 1);
		return binarySearch(arr, obj);
	}

	public String greeting() {
		return "0";
	}

	private void swap(Object[] list, int i, int j) {
		Object temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

	
	private int bucketSortMedians(int[][] arr, int[] medians) {
		ArrayList<int[]>[] bucket = new ArrayList[20000];

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < medians.length; i++) {
			int idx = (int) (medians[i] * 2);
			bucket[idx].add(arr[i]);
		}
		int outPos = 0;

		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i].size(); j++) {
				// System.out.println(median(bucket[i].get(j), bucket[i].get(j).length));
				arr[outPos++] = bucket[i].get(j);
			}
		}

		return median(medians, 1000);
	}

	private int countingSort(int[] a) {
		int[] bucket = new int[10001];
		for (int i = 0; i < a.length; i++) {
			bucket[a[i]]++;
		}
		int outPos = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				a[outPos++] = i;
			}
		}
		return median(a, a.length);
	}

	private int partition(Comparable[] arr, int low, int high) {
		Comparable pivot = arr[high];
		int i = low - 1;

		for (int j = low; j <= high - 1; j++) {
			if (arr[j].compareTo(pivot) < 0) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}

	private void insertionSort(Comparable[] list1, int start, int end) {
		for (int i = start; i < end; i++) {
			int j = i - 1;
			int k = i;
			while (j != -1 && list1[k].compareTo(list1[j]) < 0) {
				swap(list1, k, j);
				j--;
				k--;
			}
		}
	}

	private void quickSort(Comparable[] arr, int i, int j) {
		int len = j - i;
		if (len < 9) {
			insertionSort(arr, i, j + 1);
			return;
		}
		while (i < j) {
			int p = partition(arr, i, j);
			if (p - i < j - p) {
				quickSort(arr, i, p - 1);
				i = p + 1;
			} else {
				quickSort(arr, p + 1, j);
				j = p - 1;
			}
		}
	}

	private int binarySearch(Comparable[] arr, Comparable obj) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (arr[m].compareTo(obj) == 0) {
				return m;
			}
			if (arr[m].compareTo(obj) < 0) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return -1;
	}

}
