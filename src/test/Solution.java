package test;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;



public class Solution {


    /*
     * Complete the function below.
     */
    	 static long[] maxMin(String[] operations, int[] x) {
	        long[] product = new long[x.length];
	        int index = 0;
	        ArrayList<Integer> elements = new ArrayList<Integer>(x.length);
	        
	        try {
	            for (int iterator = 0; iterator < x.length; iterator++) {
	                if (operations[iterator].equals("push")) {
	                	elements.add(index, x[iterator]);
	                	index = elements.size();
	                } else if (operations[iterator].equals( "pop")) {
	                	int removeIndex = elements.indexOf(x[iterator]);
	                	elements.remove(removeIndex);
	                	index = elements.size();
	                	if (index != 0) {
	                		index--;
	                	}
	                	
	                }
	                
	                //index++;
	                // System.out.println("elements list is " + elements.get(iterator));
	                printList(elements);
	                int min = findMin(elements);
	                int max = findMax(elements);
                    System.out.println("min element is " + " " + min + " "+ "max element is " + " " + max);
	                product[iterator] = min*max;	                
	            }
	            
	        } catch (Exception error) {
	            System.out.println(error);
	        }
	        return product;
	    }
    	 
    	 static void printList(ArrayList<Integer> elements) {
    		 System.out.println("List Elements are");
    		 Iterator<Integer> itr = elements.iterator();
    		while (itr.hasNext()) {
    			System.out.println(itr.next());
    		}
    	 }
	 
	 static int findMin(ArrayList<Integer> arr) {
		 int current_element;
		 Iterator<Integer> itr = arr.iterator();
		 int min = Integer.MAX_VALUE;
		 //System.out.println("min element is" + min);
		 while (itr.hasNext()) {
			 current_element = itr.next();
			 //System.out.println(current_element);
			 if (current_element < min) {
				 min = current_element;
			 }
		 }
		return min; 
	 }
	 
	 static int findMax(ArrayList<Integer> arr) {
		 int current_element;
		 Iterator<Integer> itr = arr.iterator();
		 int max = Integer.MIN_VALUE;
		 while (itr.hasNext()) {
			 current_element = itr.next();
			 //System.out.println(current_element);
			 if (current_element > max) {
				 max = current_element;
			 }
		 }
		return max; 
	 }
	 
	 
	 
	 public static void deq(int arr[], int k) {
		    
		   List<Integer> list  = Arrays.stream(arr)
                   .boxed().collect(Collectors.<Integer>toList());
		    Collections.sort(list);
		    int first = 0, second = arr.length-1;
		    int l = 0, r = arr.length-1;
		    int closest_sum = Integer.MAX_VALUE;
		    while ( r > l ) {
		      
		      if ( Math.abs( k - (arr[l]+arr[r]) ) < closest_sum) {
		        closest_sum = Math.abs( k - (arr[l]+arr[r]) ) ;
		        first = l;
		        second = r;
		      }
		      
		      if ( (arr[l]+arr[r]) > k) {
		        r--;
		      } else {
		        l++;
		      }
		      
		    }
		    
		    System.out.println("firts number is" + first + "second number is" + second);
		    
		  }
	 
	 
	 public static void main(String[] args) throws IOException {
	        Scanner in = new Scanner(System.in);
	        final String fileName = System.getenv("OUTPUT_PATH");
	        BufferedWriter bw = null;
	        if (fileName != null) {
	            bw = new BufferedWriter(new FileWriter(fileName));
	        }
	        else {
	            bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        }

	        long[] res;
	        int operations_size = 0;
	        operations_size = Integer.parseInt(in.nextLine().trim());
	        
	        double doub = Double.parseDouble(in.nextLine().trim());

	        String[] operations = new String[operations_size];
	        for(int i = 0; i < operations_size; i++) {
	            String operations_item;
	            try {
	                operations_item = in.nextLine();
	            } catch (Exception e) {
	                operations_item = null;
	            }
	            operations[i] = operations_item;
	        }

	        int x_size = 0;
	        x_size = Integer.parseInt(in.nextLine().trim());

	        int[] x = new int[x_size];
	        for(int i = 0; i < x_size; i++) {
	            int x_item;
	            x_item = Integer.parseInt(in.nextLine().trim());
	            x[i] = x_item;
	        }

	        res = maxMin(operations, x);
	        for(int res_i = 0; res_i < res.length; res_i++) {
	            bw.write(String.valueOf(res[res_i]));
	            bw.newLine();
	        }

	        bw.close();
	    }
	

	
}
