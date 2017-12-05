package sortomania;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Note: Numbers are printed to prevent JIT from optimizing
 *  1. bucket sort / counting sort 				   100138
 *	2. bucket sort with quick sort	 		       970479    parallel radix sort as a possiblity?
 *	3. bucket sort / counting sort   			   106706     is a section of the array 75% sorted or is 75% of numbers in the correct position of the sorted array
 *												   30000      for 75% correct position
 *  4. bucket sort / counting sort with parallel   12626821
 *  5. Arrays.sort   				 			   1524293   (from challenge two (radix sort excluded (can't assume it's a string) ) )
 * @author alex
 *
 */
public class Runner {
	public static void main(String[] args) {
		test();
		//challengeOne();
		//challengeTwo();
		//challengeThree();
		//challengeFour();
		//challengeFive();
	}
	
	public static void test() {
		Team8SortCompetition t8 = new Team8SortCompetition();
		BigInteger time1 = TestCases.calculateTimeIntegerRandom(Team8SortCompetition::challengeOne, GenerateArray::generateRandomIntArr, 10);
		BigInteger time2 = TestCases.calculateTimeDoubleRandomString(Team8SortCompetition::challengeTwo, GenerateArray::generateRandomStringArr, 10);
		BigInteger time3 = TestCases.calculateTimeIntegerRandom(Team8SortCompetition::challengeThree, GenerateArray::generateSortedArr75, 10);
		BigInteger time4 = TestCases.calculateTimeDoubleRandomMat(Team8SortCompetition::challengeFour, GenerateArray::generateMultiDim, 10);
	
		System.out.println("Challenge 1: " + time1);
		System.out.println("Challenge 2: " + time2);
		System.out.println("Challenge 3: " + time3);
		System.out.println("Challenge 4: " + time4);
	
	}

	public static void challengeOne() {
		System.out.println("Challenge 1");
		
		BigInteger time2 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::radixSort, GenerateArray::generateRandomIntArr, 10);

		BigInteger time3 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::quickSort, GenerateArray::generateRandomIntArr, 10);

		BigInteger time4 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::bucketSort, GenerateArray::generateRandomIntArr, 10);
		BigInteger time1 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::countingSort, GenerateArray::generateRandomIntArr, 10);


		BigInteger time5 = TestCases.calculateTimeDoubleRandom(GenerateArray::generateRandomIntArr, 10);

		BigInteger time6 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::mergeSort, GenerateArray::generateRandomIntArr, 10);

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

		//BigInteger time1 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::quickSort, GenerateArray::generateRandomStringArr, 10);

		BigInteger time2 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::radixSort, GenerateArray::generateRandomStringArr, 10);

		BigInteger time3 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::bucketSortWithQuick, GenerateArray::generateRandomStringArr, 10);

		BigInteger time4 = TestCases.calculateTimeDoubleRandomString(GenerateArray::generateRandomStringArr, 10);

		BigInteger time5 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::mergeSort, GenerateArray::generateRandomStringArr, 10);
		
		BigInteger time6 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::bucketSortWithInsert, GenerateArray::generateRandomStringArr, 10);

		//System.out.println("Quick Sort:            " + time1);
		System.out.println("Radix Sort:            " + time2);
		System.out.println("Bucket Sort w/ Quick:  " + time3);
		System.out.println("Arrays.Sort:           " + time4);
		System.out.println("Merge Sort:            " + time5);
		System.out.println("Bucket Sort w/ Insert: " + time6);
		System.out.println();
	}

	public static void challengeThree() {
		System.out.println("Challenge 3");
		BigInteger time1 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::countingSort, GenerateArray::generateSortedArr75, 10);

		BigInteger time2 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::radixSort, GenerateArray::generateSortedArr75, 10);

		BigInteger time3 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::quickSort, GenerateArray::generateSortedArr75, 10);

		BigInteger time4 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::bucketSort, GenerateArray::generateSortedArr75, 10);

		BigInteger time5 = TestCases.calculateTimeDoubleRandom(GenerateArray::generateSortedArr75, 10);

		BigInteger time6 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::heapSort, GenerateArray::generateSortedArr75, 10);

		BigInteger time7 = TestCases.calculateTimeDoubleRandom(SortingAlgorithms::insertionSort, GenerateArray::generateSortedArr75, 10);

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

		BigInteger time2 = TestCases.calculateTimeDoubleRandomMat(SortingAlgorithms::quickSortMatrix, GenerateArray::generateMultiDim, 10);

		BigInteger time3 = TestCases.calculateTimeDoubleRandomMat(SortingAlgorithms::radixSortMatrix, GenerateArray::generateMultiDim, 10);

		BigInteger time4 = TestCases.calculateTimeDoubleRandomMat(SortingAlgorithms::bucketSortMatrix, GenerateArray::generateMultiDim, 10);

		System.out.println("Quick Sort:                    " + time2);
		System.out.println("Radix Sort:                    " + time3);
		System.out.println("Counting Sort / Bucket Sort:   " + time4);
		System.out.println();
	}

	public static  void challengeFive() {
			System.out.println("Challenge 2");


			BigInteger time1 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::quickSort, GenerateArray::generateRandomStringArr, 10);

			//BigInteger time4 = TestCases.calculateTimeDoubleRandomString(GenerateArray::generateRandomStringArr, 10);

			//BigInteger time5 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::mergeSort, GenerateArray::generateRandomStringArr, 10);
			
			//BigInteger time6 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::quickSort2, GenerateArray::generateRandomStringArr, 10);

			//BigInteger time7 = TestCases.calculateTimeDoubleRandomString(SortingAlgorithms::quickSort3, GenerateArray::generateRandomStringArr, 10);
			
			System.out.println("Quick Sort:                   " + time1);
			//System.out.println("Arrays.Sort:                  " + time4);
			//System.out.println("Merge Sort:                   " + time5);
		    //System.out.println("Quick Sort w/ Insertion Sort: " + time6);
			//System.out.println("Quick Sort w/ Heap Sort: " + time7);
			System.out.println();
		}
}
