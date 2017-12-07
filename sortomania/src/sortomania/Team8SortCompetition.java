package sortomania;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Team8SortCompetition {

	/**
	 * gets the median of an array (truncated)
	 * @param a the array
	 * @param len length of the array
	 * @return the median of the array (truncated)
	 */
	private static int median(int[] a, int len) {
		return (a[len / 2 - 1] + a[len / 2]) / 2;
	}

	public static void fill(int[] array, int value, int start, int end) {
        int len = end + start;
        if (len > start)
           array[start] = value;
        int i = start + 1;
        for (; i < len; i += (i - start)) {
           int lsubi = len - i;
            System.arraycopy(array, start, array, i,
                ((lsubi) < i) ? lsubi : i);
        }
    }
   
    /**
    * implementation of counting sort
    * @param arr the array to be sorted
    * @return the median of the array
    */
    public static int challengeOne2(int[] arr) {
           int[] stored = new int[10001]; // number of buckets = max num
           int i, x;
           i = x = 0;
           for (; i < 10000; ++i) {
                  stored[arr[i]]++; // fill the buckets with the integers
           }
           int resultIdx = 0;
           for (; x < 10001; ++x) {
                  int count = stored[x];
                  if (count != 0) {
                        fill(arr, x, resultIdx, count);
                        resultIdx += count;
                  }
           }
           return (arr[4999] + arr[5000]) << 1;
    }
    
    public static int[] fillBuckets(int[] arr, int s, int e) {
    	int[] stored = new int[10001];
    	for (int i = s; i < e; ++i) {
			stored[arr[i]]++; // fill the buckets with the integers
		}
    	return stored;
    }
	
    public static int challengeOne(int[] arr) {
    	int[] stored = new int[10001]; // number of buckets = max num
		int i, x, y, resultIdx;
		for (i = 0; i < 10000; ++i) {
			stored[arr[i]]++; // fill the buckets with the integers
		}
		resultIdx = 0;
		for (x = 0; x < 10001; ++x) {
			for (y = 0; y < stored[x]; ++y) {
				arr[resultIdx++] = i; // copy the numbers
			}
		}
		return (arr[4999] + arr[5000]) / 2;
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
	
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
		Comparable[] aux = new Comparable[a.length];
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

        // postcondition: a[lo .. hi] is sorted
    }
	
	/**
	 * implementation of quicksort where the object is searched using binary search
	 * @param arr the array to be sorted
	 * @param obj the object to be searched
	 */
	public static int challengeFive(Comparable[] arr, Comparable obj) {
		int mid = arr.length / 2;
		ExecutorService executor = Executors.newFixedThreadPool(2);
		CompletionService<Void> completionService = new ExecutorCompletionService<Void>(executor);
		Callable<Void> c = new Callable<Void>() {
			@Override
			public Void call() {
				quickSort(arr, 0, mid);
				return null;
			}
		};
		Callable<Void> c1 = new Callable<Void>() {
			@Override
			public Void call() {
				quickSort(arr, mid + 1, arr.length - 1);
				return null;
			}
		};
		completionService.submit(c);
		completionService.submit(c1);
	
		int received = 0;
		boolean errors = false;
	
		while (received < 2 && !errors) {
			Future<Void> resultFuture = null;
			try {
				resultFuture = completionService.take();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				resultFuture.get();
				received++;
			} catch (Exception e) {
				e.printStackTrace();
				errors = true;
			}
		}
		//System.out.println(TestCases.isSorted(Arrays.copyOfRange(arr, 0, mid)));
		//System.out.println(TestCases.isSorted(Arrays.copyOfRange(arr, mid, arr.length)));
		merge(arr, 0, mid, arr.length - 1);
		return binarySearch(arr, obj);
	}

	public String greeting() {
		return "0";
	}

	private static void swap(Object[] list, int i, int j) {
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

	private static int partition(Comparable[] arr, int low, int high) {
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

	/*
	 * private static void insertionSort(Comparable[] list1, int start, int end) {
		for (int i = start; i <= end; i++) {
			int j = i - 1;
			Comparable key = list1[i];
			while (j >= 0 && list1[j].compareTo(key) > 0) {
				list1[j+1] = list1[j];
				j = j - 1;
			}
			list1[j + 1] = key;
		}
	}
	 */
	private static void insertionSort(Comparable[] list1, int start, int end) {
		for (int i = start; i <= end; i++) {
			int j = i - 1;
			int k = i;
			while (j != -1 && list1[k].compareTo(list1[j]) < 0) {
				swap(list1, k, j);
				j--;
				k--;
			}
		}
	}

	private static void quickSort(Comparable[] arr, int i, int j) {
		// does not work with parallelism
		/*
		if (i < j && j - i < 9) {
			insertionSort(arr, i, j);
		}*/
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

	private static int binarySearch(Comparable[] arr, Comparable obj) {
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

	@Override
	public int challengeFive(Object[] arr, Object item) {
		return 0;
	}

}
