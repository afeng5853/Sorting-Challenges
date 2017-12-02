package sortomania;

import java.math.BigInteger;
import java.util.Arrays;

public class Runner {
	public static void main(String[] args) {
		challengeOne();
		challengeTwo();
		challengeThree();
		challengeFour();
	}

	public static void challengeOne() {
		System.out.println("Challenge 1");
		BigInteger time = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::countingSort, GenerateArray::generateRandomIntArr, 1);
		System.out.println("Counting Sort: " + time);

		time = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::radixSort, GenerateArray::generateRandomIntArr, 1);
		System.out.println("Radix Sort:    " + time);

		time = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::quickSort, GenerateArray::generateRandomIntArr, 1);
		System.out.println("Quick Sort:    " + time);

		time = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::bucketSort, GenerateArray::generateRandomIntArr, 1);
		System.out.println("Bucket Sort:   " + time);

	}

	public static void challengeTwo() {
		System.out.println("Challenge 2");

		BigInteger time = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::quickSort, GenerateArray::generateRandomStringArr, 1);
		System.out.println("Quick Sort:                  " + time);

		time = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::radixSort, GenerateArray::generateRandomStringArr, 1);
		System.out.println("Radix Sort:      " + time);

		time = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::bucketSort, GenerateArray::generateRandomStringArr, 1);
		System.out.println("Bucket Sort:     " + time);
	}

	public static void challengeThree() {
		System.out.println("Challenge 3");
		BigInteger time = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::countingSort, GenerateArray::generateRandomIntArr75, 1);
		System.out.println("Counting Sort: " + time);

		time = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::radixSort, GenerateArray::generateRandomIntArr75, 1);
		System.out.println("Radix Sort:    " + time);

		time = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::quickSort, GenerateArray::generateRandomIntArr75, 1);
		System.out.println("Quick Sort:    " + time);

		time = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::bucketSort, GenerateArray::generateRandomIntArr75, 1);
		System.out.println("Bucket Sort:   " + time);
	}

	public static void challengeFour() {
		System.out.println("Challenge 4");
		BigInteger time = TestCases.calculateTimeDoubleRandomMat(SortingAlgorithms::countingSortMatrix, GenerateArray::generateMultiDim, 1);
		System.out.println("Counting Sort: " + time);

		time = TestCases.calculateTimeDoubleRandomMat(SortingAlgorithms::quickSortMatrix, GenerateArray::generateMultiDim, 1);
		System.out.println("Quick Sort:    " + time);

		time = TestCases.calculateTimeDoubleRandomMat(SortingAlgorithms::radixSortMatrix, GenerateArray::generateMultiDim, 1);
		System.out.println("Radix Sort:    " + time);

		time = TestCases.calculateTimeDoubleRandomMat(SortingAlgorithms::bucketSortMatrix, GenerateArray::generateMultiDim, 1);
		System.out.println("Bucket Sort:   " + time);
	}

	public static  void challengeFive() {
		System.out.println("Look at challenge 2");
	}
}
