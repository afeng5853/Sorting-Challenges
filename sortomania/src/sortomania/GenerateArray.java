package sortomania;

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
		        .withinRange('a', 'z')
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
			if (i < 75000) {
				test[i] = i;
			}
			test[i] = r.nextInt(maxInt);
		}
		return test;
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
