package sortomania;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestCases {


	public static void printArray(int[] a) {
		for (int n : a) {
			System.out.println(n + " ");
		}
	}

	public static void printArray(Object[] a) {
		for (Object n : a) {
			System.out.println(n + " ");
		}
	}

	/**
	 * Only works for sorting algorithms that make copies
	 * @param a
	 * @param func
	 * @param iterations
	 * @return
	 */
	public static BigInteger calculateTimeDouble(int[] a, Function<int[],Double> func, int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		Double median = -1.0;
		for (int i = 0; i < iterations; i++) {
			int[] tested = Arrays.copyOfRange(a, 0, a.length);
			long time = System.nanoTime();
			median = func.apply(tested);
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
			assert(isSorted(tested));
		}
		System.out.print("median:" + median + " ");
		return sum.divide(BigInteger.valueOf(iterations));
	}

	/**
	 * Sorting (all random)
	 * @param a
	 * @param func
	 * @param iterations
	 * @return
	 */
	public static BigInteger calculateTimeDoubleRandom(Function<int[],Double> func, BiFunction<Integer, Integer, int[]> generate,  int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		Double median = -1.0;
		for (int i = 0; i < iterations; i++) {
			int[] tested = generate.apply(10000, 10000);
			long time = System.nanoTime();
			median = func.apply(tested);
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
			assert(isSorted(tested));
		}
		System.out.print("median:" + median + " ");
		return sum.divide(BigInteger.valueOf(iterations));
	}

	public static BigInteger calculateTimeDoubleRandomMat(Function<int[][],Double> func, BiFunction<Integer, Integer, int[][]> generate,  int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		Double median = -1.0;
		for (int i = 0; i < iterations; i++) {
			int[][] tested = generate.apply(1000, 10000);
			long time = System.nanoTime();
			median = func.apply(tested);
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
			assert(isSorted(tested));
		}
		System.out.print("median:" + median + " ");
		return sum.divide(BigInteger.valueOf(iterations));
	}

	public static BigInteger calculateTimeDoubleRandomString(Function<String[],Double> func, BiFunction<Integer, Integer, String[]> generate,  int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		Double median = -1.0;
		for (int i = 0; i < iterations; i++) {
			String[] tested = generate.apply(10000, 5);
			long time = System.nanoTime();
			func.apply(tested);
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
			assert(isSorted(tested));
		}
		return sum.divide(BigInteger.valueOf(iterations));
	}

	/**
	 * Sorting (all random)
	 * @param a
	 * @param func
	 * @param iterations
	 * @return
	 */
	public static BigInteger calculateTimeDoubleRandom(TriFunction<int[], Integer, Integer, Double> func, BiFunction<Integer, Integer, int[]> generate, int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		Double median = -1.0;
		for (int i = 0; i < iterations; i++) {
			int[] tested = generate.apply(10000, 10000);
			long time = System.nanoTime();
			median = func.apply(tested, 0, 10000);
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
			assert(isSorted(tested));
		}
		System.out.print("median:" + median + " ");
		return sum.divide(BigInteger.valueOf(iterations));
	}

	public static BigInteger calculateTimeDoubleRandomString(TriFunction<String[], Integer, Integer, Double> func, BiFunction<Integer, Integer, String[]> generate, int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		for (int i = 0; i < iterations; i++) {
			String[] tested = generate.apply(10000, 5);
			long time = System.nanoTime();
			func.apply(tested, 0, 10000);
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
			assert(isSorted(tested));
		}
		return sum.divide(BigInteger.valueOf(iterations));
	}


	public static BigInteger calculateTimeDoubleRandomString(BiFunction<String[], String, Integer> func, BiFunction<Integer, Integer, String[]> generate, int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		int idx = -1;
		for (int i = 0; i < iterations; i++) {
			String[] tested = generate.apply(10000, 5);
			long time = System.nanoTime();
			idx = func.apply(tested, tested[0]);
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
			assert(isSorted(tested));
		}
		System.out.print("Index: " + idx + " ");
		return sum.divide(BigInteger.valueOf(iterations));
	}

	/**
	 * Only works for sorting algorithms that make copies
	 * @param a
	 * @param func
	 * @param iterations
	 * @return
	 */
	public static BigInteger calculateTimeDouble(int[] a, TriFunction<int[], Integer, Integer, Double> func, int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		Double median = -1.0;
		for (int i = 0; i < iterations; i++) {
			int[] tested = Arrays.copyOfRange(a, 0, a.length);
			long time = System.nanoTime();
			median = func.apply(tested, 0, 10000);
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
			assert(isSorted(tested));
		}
		System.out.print("median:" + median + " ");
		return sum.divide(BigInteger.valueOf(iterations));
	}

	/**
	 * Only works for sorting algorithms that returns Void (Object)
	 * @param a
	 * @param func
	 * @param iterations
	 * @return
	 */
	public static BigInteger calculateTimeObjVoid(Comparable<Object>[] a, Function<Comparable<Object>[],Void> func, int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		for (int i = 0; i < iterations; i++) {
			Comparable<Object>[] tested = Arrays.copyOfRange(a, 0, a.length);
			long time = System.nanoTime();
			func.apply(tested);
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
			assert(isSorted(tested));
		}
		return sum.divide(BigInteger.valueOf(iterations));
	}


	/**
	 * Only works for sorting algorithms that returns Void (Object)
	 * @param a
	 * @param func
	 * @param iterations
	 * @return
	 */
	public static BigInteger calculateTimeIntVoid(int[] a, Function<int[],Void> func, int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		for (int i = 0; i < iterations; i++) {
			int[] tested = Arrays.copyOfRange(a, 0, a.length);
			long time = System.nanoTime();
			func.apply(tested);
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
			assert(isSorted(tested));
		}
		return sum.divide(BigInteger.valueOf(iterations));
	}

	public static boolean isSorted(String[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i].compareTo(a[i-1]) < 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(Comparable<Object>[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i].compareTo(a[i-1]) < 0) {
				return false;
			}
		}
		return true;
	}



	public static boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i-1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a[i].length; j++) {
				if (a[i][j] < a[i][j-1]) {
					return false;
				}
			}
		}
		return true;
	}

}
