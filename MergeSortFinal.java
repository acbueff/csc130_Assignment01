import java.util.Random;

/**
 * Using the merge sort algorithm, the MergeSortFinal class provides
 * static methods to implement the algorithm in sorting int arrays
 * and methods for calculating the median
 *  and printing the input and output
 * 
 * @author Andreas
 *
 */
public class MergeSortFinal{
	
	/**
	 * Implements merge sort algorithm using iteration
	 * @param a the array to be divided, sorted and merged
	 * @return a the sorted array
	 */
	public static int[] mergeSort(int a[]){
		
		//base case
		if(a.length <= 1){
			return a;
		}
		
		//divide array in half by creating two new arrays based off length of a[]
		int[] leftSplit = new int[a.length/2];
		int[] rightSplit = new int[a.length - leftSplit.length];
		
		//fill the two split arrays with the respective int values of a[]
		addHalfArray(leftSplit, a, 0, a.length/2);
		addHalfArray(rightSplit, a, a.length/2, a.length);
		
		//iterate till the split arrays contain 2 or less int values
		leftSplit = mergeSort(leftSplit);
		rightSplit = mergeSort(rightSplit);
		
		a = mergeArray(leftSplit, rightSplit);
		
		return a;
	}
	
	
	/**
	 * copies int values in a larger array to a smaller array
	 * @param small smaller array where values will be copied
	 * @param big larger array where values are copied from
	 * @param start location to begin copying values
	 * @param end location to end copying values
	 */
	public static void addHalfArray(int small[], int big[], int start, int end){
		
		int j = 0;
		for(int i = start; i < end; i++){
			
				small[j] = big[i];
				j++;
			
		}
		
	}
	
	
	/**
	 * Combine two arrays by comparing int values allocating placement
	 * @param left array to be combined
	 * @param right array to be combined
	 * @return temp  the final ordered combined array
	 */
	public static int[] mergeArray(int left[], int right[]){
		
		//create temp array in which to store ordered ints from left[] and righ[]
		int[] temp = new int[left.length + right.length];
		//index values to track placement in left, right, and temp array
		int indexL = 0;
		int indexR = 0;
		int indexTemp = 0;
		
		while( indexL < left.length  || indexR < right.length){
			
			if(indexL < left.length && indexR < right.length ){
				
				if(left[indexL] <= right[indexR]){
					temp[indexTemp] = left[indexL];
					indexTemp++;
					indexL++;
				}
				else{
					temp[indexTemp] = right[indexR];
					indexTemp++;
					indexR++;
				}
			}
			else if(indexL < left.length){
				temp[indexTemp] = left[indexL];
				indexTemp++;
				indexL++;
				
			}
			else if(indexR < right.length){
				temp[indexTemp] = right[indexR];
				indexTemp++;
				indexR++;
			}
		}
		
		return temp;
	}
	
	
	/**
	 * Determine the median of an array
	 * @param a the array
	 * @return median 
	 */
	public static double medianArray(int[] a){
		
		double median = 0;
		//check if not odd and add two middle values to find median
		if(!oddArray(a)){
			median = (a[a.length/2 - 1] + a[a.length/2])/2.0;
		}
		else{
			median = a[a.length/2];
		}
		
		return median;
	}
	
	
	/**
	 * Check to see if array is contains odd amount of values
	 * @param a the array
	 * @return whether true or not
	 */
	public static boolean oddArray(int[] a){
		if(a.length%2 == 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * Fill array with random int values ranging from 1 to 50
	 * @param a the array
	 * @return the filled array
	 */
	public static int[] fillArray(int[] a){
		Random random = new Random();
		for(int i = 0; i < a.length; i++){
			int value = random.nextInt(50)+1;
			a[i] = value;
		}
		return a;
	}
	
	/**
	 * Determine the whether array is even or odd and display
	 * size of array and current order of int values in array
	 * @param a the array
	 */
	public static void printInput(int[] a){
		
		//print if odd or even
		if(oddArray(a)){
			System.out.println("Odd size data set:");
		}
		else{
			System.out.println("Even size data set:");
			//System.out.println("");
		}
		
		System.out.println("");
		System.out.println("Input: ");
		System.out.println(a.length);
		System.out.println("");
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
		System.out.println("");
	}
	
	/**
	 * Print output of sorted array and display median value
	 * @param a the array
	 */
	public static void printOutput(int[] a){
		
		System.out.println("Output:");
		System.out.print("The sorted result is: ");
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("");
		System.out.println("The median is: " + medianArray(a));
		System.out.println("");
		
	}
	
	/**
	 * Fill two odd, even sized arrays; print initial values
	 * and mergesort them and print final sorted values
	 * @param args
	 */
	public static void main(String[] args){
		
		//Initialize odd and even arrays for testing 
		int[] odd = new int[13];
		int[] even = new int[12];
		
		
		fillArray(odd);
		fillArray(even);
		
		printInput(odd);
		odd = mergeSort(odd);
		printOutput(odd);
		
		printInput(even);
		even = mergeSort(even);
		printOutput(even);

		
	}

}
