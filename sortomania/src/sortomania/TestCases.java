package sortomania;

import java.math.BigInteger;
import java.util.function.Function;

public class TestCases {

	
	/**
	 * Only works for sorting algorithms that make copies
	 * @param a
	 * @param func
	 * @param iterations
	 * @return
	 */
	public static BigInteger calculateTimeInt(int[] a, Function<int[],int[]> func, int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		for (int i = 0; i < iterations; i++) {
			long time = System.nanoTime();
			int[] res = func.apply(a);
			assert(isSorted(res));
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
		}
		return sum.divide(BigInteger.valueOf(iterations));
	}
	
	/**
	 * Only works for sorting algorithms that make copies
	 * @param a
	 * @param func
	 * @param iterations
	 * @return
	 */
	public static BigInteger calculateTimeObj(Comparable<Object>[] a, Function<Comparable<Object>[],Comparable<Object>[]> func, int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		for (int i = 0; i < iterations; i++) {
			long time = System.nanoTime();
			Comparable<Object>[] res = func.apply(a);
			assert(isSorted(res));
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
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
	public static BigInteger calculateTimeObjVoid(Comparable<Object>[] a, Function<Comparable<Object>[],Void> func, int iterations) {
		BigInteger sum = BigInteger.valueOf(0);
		for (int i = 0; i < iterations; i++) {
			long time = System.nanoTime();
			func.apply(a);
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
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
			long time = System.nanoTime();
			func.apply(a);
			sum = sum.add(BigInteger.valueOf((System.nanoTime() - time)));
		}
		return sum.divide(BigInteger.valueOf(iterations));
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
	
	
}
