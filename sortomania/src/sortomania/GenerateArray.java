package sortomania;

import java.util.Random;

public class GenerateArray {
	public static int[] generateRandomIntArr(int size, int maxInt) {
		Random r = new Random();
		int[] test = new int[size];
		for (int i = 0; i < test.length; i++) {
			test[i] = r.nextInt(maxInt);
		}
		return test;
	}
}
