package test;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

//A recursive solution for subset sum problem
public class subset_sum {
	// Returns true if there is a subset of set[] with sum
	// equal to given sum
	static boolean isSubsetSum(int set[], int n, int sum) {

		// Base Cases
		if (sum == 0) {
			System.out.println("base case" + " " + (n) + " " + set[n - 1] + " "
					+ sum);
			return true;
		}

		if (n == 0 && sum != 0) {
			System.out.println("base case n==0" + " " + " " + " " + sum);
			return false;
		}

		// If last element is greater than sum, then ignore it
		if (set[n - 1] > sum) {
			System.out.println("inside" + " " + (n) + " " + set[n - 1] + " "
					+ sum);
			return isSubsetSum(set, n - 1, sum);
		}

		System.out.println("outside " + " " + (n) + " " + set[n - 1] + " "
				+ sum);
		/*
		 * else, check if sum can be obtained by any of the following (a)
		 * including the last element (b) excluding the last element
		 */
		return isSubsetSum(set, n - 1, sum)
				|| isSubsetSum(set, n - 1, sum - set[n - 1]);
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;
		for (int i = 0; i < set.length; i++) {
			System.out.print(set[i] + " ");
		}
		System.out.print("\n");
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset with given sum");
		else
			System.out.println("No subset with given sum");
	}
}/* This code is contributed by Rajat Mishra */

// A Dynamic Programming solution for subset sum problem
class subset_sum_dp {
	// Returns true if there is a subset of set[] with sun equal to given sum
	static boolean isSubsetSum(int set[], int n, int sum) {
		// The value of subset[i][j] will be true if there
		// is a subset of set[0..j-1] with sum equal to i
		boolean subset[][] = new boolean[sum + 1][n + 1];

		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		// If sum is not 0 and set is empty, then answer is false
		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		// Fill the subset table in botton up manner
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1])
					subset[i][j] = subset[i][j]
							|| subset[i - set[j - 1]][j - 1];
			}
		}

		// uncomment this code to print table
		for (int i = 0; i <= sum; i++) {
			for (int j = 0; j <= n; j++)
				System.out.println(subset[i][j]);
		}

		return subset[sum][n];
	}
	
	 static long[] maxMin(String[] operations, int[] x) {
	        long[] product = new long[x.length];
	        ArrayList<Integer> elements = new ArrayList<Integer>(x.length);
	        
	        try {
	            for (int iterator = 0; iterator < x.length; iterator++) {
	                if (operations[(int) iterator] == "push") {
	                	elements.add(iterator, x[ iterator]);
	                } else if (operations[iterator] == "pop") {
	                	elements.remove(x[ iterator]);
	                }
	                
	                int min = findMin(elements);
	                int max = findMax(elements);
	                product[iterator] = min*max;	                
	            }
	            
	        } catch (Exception error) {
	            System.out.println(error);
	        }
	        return product;
	    }
	 
	 static int findMin(ArrayList<Integer> arr) {
		 Iterator<Integer> itr = arr.iterator();
		 int min = Integer.MAX_VALUE;
		 while (itr.hasNext()) {
			 if (itr.next() > min) {
				 min = itr.next();
			 }
		 }
		return min; 
	 }
	 
	 static int findMax(ArrayList<Integer> arr) {
		 Iterator<Integer> itr = arr.iterator();
		 int max = Integer.MIN_VALUE;
		 while (itr.hasNext()) {
			 if (itr.next() > max) {
				 max = itr.next();
			 }
		 }
		return max; 
	 }

	/* Driver program to test above function */
	public static void main(String args[]) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset with given sum");
		else
			System.out.println("No subset with given sum");
	}
}/*
 * This code is contributed by Rajat Mishra
 */