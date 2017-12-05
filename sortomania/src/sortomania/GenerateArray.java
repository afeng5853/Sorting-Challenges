package sortomania;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.text.RandomStringGenerator;

import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

public class GenerateArray {
	public static int[] generateRandomIntArr(int size, int maxInt) {
		Random r = new Random();
		int[] test = new int[size];
		for (int i = 0; i < test.length; i++) {
			test[i] = r.nextInt(maxInt);
		}
		return test;
	}

	public static String[] generateRandomStringArr(int size, int length) {
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
		        .withinRange('A', 'z')
		        .filteredBy(LETTERS)
		        .build();
		String[] test = new String[size];
		for (int i = 0; i < test.length; i++) {
			test[i] = generator.generate(length);;
		}
		return test;
	}

	public static int[] generateRandomIntArr75(int size, int maxInt) {
		Random r = new Random();
		int[] test = new int[size];
		for (int i = 0; i < test.length; i++) {
			if (i < 7500) {
				test[i] = i;
			} else {
				test[i] = r.nextInt(maxInt);
			}
			
		}
		return test;
	}
	
	private static void swap(List<Integer> a, int i, int j) {
		int temp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);
	}
	
	public static int[] generateSortedArr75(int size, int maxInt) {
		List<Integer> test = new ArrayList<>(10000);
		List<Integer> test2 = new ArrayList<>(10000);
		for (int i = 0; i < 10000; i++) {
			test.add(i);
			test2.add(i);
		}
		Collections.shuffle(test);
		for (int i = 1; i < 1250; i++) {
			swap(test2, test.get(i-1), test.get(i));
		}
		
		return test2.stream().mapToInt(i -> i).toArray();
	}

	public static int[][] generateMultiDim(int size, int maxInt) {
		Random r = new Random();
		int[][] test = new int[size][size];
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test.length; j++) {
				test[i][j] = r.nextInt(maxInt);
			}
		}
		return test;
	}
}
