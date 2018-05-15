package test;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class HashTable {
	


	public static void solve(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	        	System.out.println(map.get(complement)+ " " + (i+1));
	        	break;
	            //return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i+1);
	    }
	    // throw new IllegalArgumentException("No two sum solution");
	}

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int money = in.nextInt();
	            int n = in.nextInt();
	            int[] arr = new int[n];
	            for(int arr_i = 0; arr_i < n; arr_i++){
	                arr[arr_i] = in.nextInt();
	            }
	            solve(arr, money);
	        }
	        in.close();
	    }
	

}
