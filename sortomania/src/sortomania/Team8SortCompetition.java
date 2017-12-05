package sortomania;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Team8SortCompetition {

	private static int median(int[] a, int len) {
		return (a[len/2-1] + a[len/2]) / 2;
	}
	
	public static int challengeOne(int[] arr) {
		int[] stored = new int[10001];
		for (int i = 0; i < arr.length; i++) {
			stored[arr[i]]++;
		}
		int resultIdx = 0;
		for (int i = 0; i < stored.length; i++) {
			for (int j=0; j<stored[i]; j++) {
	            arr[resultIdx++]=i;
	         }
		}
		return median(arr, arr.length);
	}

	private static int hashCode(String letters) {
		char c1 = letters.charAt(0);
		char c2 = letters.charAt(1);
		int l1, l2;
		if (Character.isUpperCase(c1)) {
			l1 = ((int) c1) - 65;
		} else {
			l1 = ((int) c1) - 71;
		}
		if (Character.isUpperCase(c2)) {
			l2 = ((int) c2) - 65;
		} else {
			l2 = ((int) c2) - 71;
		}
		return 52 * l1 + l2;
	}
	
	
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
	
	private static void insertionSort(String[] list1) {
		for (int i = 1; i < list1.length; i++) {
			int j = i-1;
			int k = i;
			if (list1[k] == null || list1[j] == null) {
				break;
			}
			while (j != -1 && list1[k].compareTo(list1[j]) < 0) {
				swap(list1, k, j);
				j--;
				k--;
			}
		}
	}
	
	public static int challengeTwo(String[] a, String search) {
	      String[][] bucket = new String[2704][15];
	      int matchIdx = -1;
	      int[] indices = new int[2704];
	      for (int i=0; i <a.length; i++) {
	    	  int bucketIdx = hashCode(a[i].substring(0, 3));
		  bucket[bucketIdx][indices[bucketIdx]++] = a[i];
	      }

	      for (int i=0; i < bucket.length; i++) {
	    	  if (indices[i] != 0) {
	    		  insertionSort(bucket[i]);
	    	  }
	      }

	      int pos = 0;
	      for (int i = 0; i < bucket.length; i++) {
	    	  for (int j = 0; j < bucket[i].length; j++) {
	    		  if (bucket[i][j] == null) {
				  break;
			  }
			  if (bucket[i][j].equals(search))
	    			  matchIdx = pos;
	    		  a[pos++] = bucket[i][j];
	    	  }
	      }
	     return matchIdx;
	 }

	public static int challengeThree(int[] arr) {
		int[] stored = new int[10001];
		for (int i = 0; i < arr.length; i++) {
			stored[arr[i]]++;
		}
		int resultIdx = 0;
		for (int i = 0; i < stored.length; i++) {
			for (int j=0; j<stored[i]; j++) {
	            arr[resultIdx++]=i;
	         }
		}
		return median(arr, arr.length);
	}

	private static int bucketSortMedians(int[][] arr, int[] medians) {
		  ArrayList<int[]>[] bucket = new ArrayList[20000];

		  for (int i = 0; i < bucket.length; i++) {
			  bucket[i] = new ArrayList<int[]>();
		  }
		  
	      for (int i=0; i< medians.length; i++) {
	    	  int idx = (int) (medians[i] * 2);
	    	  bucket[idx].add(arr[i]);
	      }
	      int outPos=0;
	      
	      for (int i=0; i< bucket.length; i++) {
	         for (int j=0; j < bucket[i].size(); j++) {
	        	 //System.out.println(median(bucket[i].get(j), bucket[i].get(j).length));
	             arr[outPos++] = bucket[i].get(j);
	         }
	      }

		return median(medians, 1000);
	}
	
	private static int bucketSort(int[] a) {
	      int [] bucket=new int[10001];
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
	
	public static int challengeFour(int[][] arr) {
		ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executor);
		for (final int[] row : arr) {
			Callable<Integer> c = new Callable<Integer>() {
	            @Override
	            public Integer call() {
	            	return bucketSort(row);
	            }
	        };
	        completionService.submit(c);
		}

		int received = 0;
		boolean errors = false;
		
		while(received < 1000 && !errors) {
		    Future<Integer> resultFuture = null;
			try {
				resultFuture = completionService.take();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		  try {
		     resultFuture.get();
		     received++;
		  }
		  catch(Exception e) {
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
/*
	@Override
	public int challengeFive(Object[] arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String greeting() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
