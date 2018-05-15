// Java program to print all combination of size r in an array of size n
package test;

class Combinations {

	/*
	 * arr[] ---> Input Array data[] ---> Temporary array to store current
	 * combination start & end ---> Staring and Ending indexes in arr[] index
	 * ---> Current index in data[] r ---> Size of a combination to be printed
	 */
	static void combinationUtil(int arr[], int i, int n, int data[], int index,
			int r, int sum) {
		// Current combination is ready to be printed, print it
		if (index == r) {
			int actual_sum = 0;
			for (int j = 0; j < r; j++)
				actual_sum += data[j];
			if (actual_sum == sum) {
				for (int j = 0; j < r; j++) {
					System.out.print(data[j] + " ");
				}
				System.out.println("");
			}
			return;
		}

		// When no more elements are there to put in data[]
		if (i >= n)
			return;

		// current is included, put next at next location
		data[index] = arr[i];
		combinationUtil(arr, i + 1, n,  data, index + 1, r, sum);
		
		
//	    // Remove duplicates
//	    while (arr[i] == arr[i+1])
//	        i++;

		// current is excluded, replace it with next (Note that
		// i+1 is passed, but index is not changed)
		combinationUtil(arr, i+1, n,  data, index, r, sum);
	}

	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	static void printCombination(int arr[], int n, int r, int sum) {
		// A temporary array to store all combination one by one
		int data[] = new int[r];

		// Print all combination using temprary array 'data[]'
		combinationUtil(arr, 0, n, data, 0, r, sum);
	}

	/* Driver function to check for above function */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 6 };
		int n = arr.length;
		int sum = 11;
		for (int i = n; i > 0; i--) {
			printCombination(arr, n, i, sum);
		}

	}
}
/* This code is contributed by Devesh Agrawal */