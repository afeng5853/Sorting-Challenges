package sortomania;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Note: Numbers are printed to prevent JIT from optimizing
 *  1. bucket sort   100138
 *	2. radix sort    1162271     string range?
 *	3. bucket sort   106706      is a section of the array 75% sorted or is 75% of numbers in the correct position of the sorted array
 *  4. counting sort 22755735
 *  5. Arrays.sort   1524293   (from challenge two (radix sort excluded (can't assume it's a string) ) )
 * @author alex
 *
 */
public class Runner {
	public static void main(String[] args) {
		//challengeOne();
		challengeTwo();
		//challengeThree();
		//challengeFour();
	}

	public static void challengeOne() {
		System.out.println("Challenge 1");
		BigInteger time1 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::countingSort, GenerateArray::generateRandomIntArr, 1000);

		BigInteger time2 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::radixSort, GenerateArray::generateRandomIntArr, 1000);

		BigInteger time3 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::quickSort, GenerateArray::generateRandomIntArr, 1000);

		BigInteger time4 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::bucketSort, GenerateArray::generateRandomIntArr, 1000);

		BigInteger time5 = TestCases.calculateTimeDoubleRandom(GenerateArray::generateRandomIntArr, 1000);

		BigInteger time6 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::mergeSort, GenerateArray::generateRandomIntArr, 1000);

		System.out.println("Counting Sort: " + time1);
		System.out.println("Radix Sort:    " + time2);
		System.out.println("Quick Sort:    " + time3);
		System.out.println("Bucket Sort:   " + time4);
		System.out.println("Arrays.Sort:   " + time5);
		System.out.println("Merge Sort:    " + time6);

		System.out.println();
	}

	public static void challengeTwo() {
		System.out.println("Challenge 2");

		BigInteger time1 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::quickSort, GenerateArray::generateRandomStringArr, 1000);

		BigInteger time2 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::radixSort, GenerateArray::generateRandomStringArr, 1000);

		BigInteger time3 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::bucketSort, GenerateArray::generateRandomStringArr, 1000);

		BigInteger time4 = TestCases.calculateTimeDoubleRandomString(GenerateArray::generateRandomStringArr, 1000);

		BigInteger time5 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::mergeSort, GenerateArray::generateRandomStringArr, 1000);

		System.out.println("Quick Sort:  " + time1);
		System.out.println("Radix Sort:  " + time2);
		System.out.println("Bucket Sort: " + time3);
		System.out.println("Arrays.Sort: " + time4);
		System.out.println("Merge Sort:  " + time5);
		System.out.println();
	}

	public static void challengeThree() {
		System.out.println("Challenge 3");
		BigInteger time1 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::countingSort, GenerateArray::generateRandomIntArr75, 1000);

		BigInteger time2 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::radixSort, GenerateArray::generateRandomIntArr75, 1000);

		BigInteger time3 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::quickSort, GenerateArray::generateRandomIntArr75, 1000);

		BigInteger time4 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::bucketSort, GenerateArray::generateRandomIntArr75, 1000);

		BigInteger time5 = TestCases.calculateTimeDoubleRandom(GenerateArray::generateRandomIntArr75, 1000);

		BigInteger time6 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::heapSort, GenerateArray::generateRandomIntArr75, 1000);

		BigInteger time7 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::insertionSort, GenerateArray::generateRandomIntArr75, 1000);

		System.out.println("Counting Sort:  " + time1);
		System.out.println("Radix Sort:     " + time2);
		System.out.println("Quick Sort:     " + time3);
		System.out.println("Bucket Sort:    " + time4);
		System.out.println("Arrays.Sort:    " + time5);
		System.out.println("Heap Sort:      " + time6);
		System.out.println("Insertion Sort: " + time7);
		System.out.println();
	}

	public static void challengeFour() {
		System.out.println("Challenge 4");
		BigInteger time1 = TestCases.calculateTimeDoubleRandomMat(SortingAlgorithms::countingSortMatrix, GenerateArray::generateMultiDim, 1000);

		BigInteger time2 = TestCases.calculateTimeDoubleRandomMat(SortingAlgorithms::quickSortMatrix, GenerateArray::generateMultiDim, 1000);

		BigInteger time3 = TestCases.calculateTimeDoubleRandomMat(SortingAlgorithms::radixSortMatrix, GenerateArray::generateMultiDim, 1000);

		BigInteger time4 = TestCases.calculateTimeDoubleRandomMat(SortingAlgorithms::bucketSortMatrix, GenerateArray::generateMultiDim, 1000);

		System.out.println("Counting Sort: " + time1);
		System.out.println("Quick Sort:    " + time2);
		System.out.println("Radix Sort:    " + time3);
		System.out.println("Bucket Sort:   " + time4);
		System.out.println();
	}

	public static  void challengeFive() {
		System.out.println("Look at challenge 2");
	}
}
