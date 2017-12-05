package sortomania;

public abstract class SortCompetition {
	
	
	public abstract int challengeOne(int[] arr);
	
	public abstract int challengeTwo(String[] arr, String search);
	
	public abstract int challengeThree(int[] arr);
	
	public abstract int challengeFour(int[][] arr);
	
	public abstract int challengeFive(Object[] arr, Object item);
	
	//Add a custom greeting so your sorter can introduce itself
	public abstract String greeting();

}