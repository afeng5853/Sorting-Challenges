package sortomania;

import java.math.BigInteger;
import java.util.Arrays;

public class Runner {
	public static void main(String[] args) {
		challengeOne();
	}
	
	public static  void challengeOne() {
		int[] challengeOne = GenerateArray.generateRandomIntArr(10000, 10000);
		int[] copy1 = Arrays.copyOfRange(challengeOne, 0, challengeOne.length);
		int[] copy2 = Arrays.copyOfRange(challengeOne, 0, challengeOne.length);
		int[] copy3 = Arrays.copyOfRange(challengeOne, 0, challengeOne.length);
		
		BigInteger time = TestCases.calculateTimeInt(challengeOne, SortingAlgorithms::countingSort, 10000);
		System.out.println("Counting Sort: " + time);
		
		time = TestCases.calculateTimeIntVoid(copy1, SortingAlgorithms::insertionSort, 10000);
		System.out.println("Insertion Sort: " + time);
		
		time = TestCases.calculateTimeIntVoid(copy2, SortingAlgorithms::selectionSort, 10000);
		System.out.println("Selection Sort: " + time);
	}
}
