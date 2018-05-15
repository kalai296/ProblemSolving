package test;

/*
 a = [1, 2, 2, 3, 3, 4, 3, 2, 4] deg = 3  count of 2 = 3 count of 3 = 3
 [2, 2, 3, 3, 4, 3, 2]  size 7 deg 3
 [3, 3, 4, 3] size 4 deg 3 => ans = 4
 */
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class ArrayDegreeinHash {

	public void findDegree(int arr[]) {


		int degree = Integer.MIN_VALUE;

		

		HashMap<Integer, HashMap<String, Integer>> map = new HashMap<Integer, HashMap<String, Integer>>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.get(arr[i]).put("count",map.get(arr[i]).get("count") + 1);
				map.get(arr[i]).put("lastIndex", i);
				map.put(arr[i], map.get(arr[i]));
			} else {
				HashMap<String, Integer> newMap= new HashMap<String, Integer>();
				newMap.put("firstIndex", i);
				newMap.put("lastIndex", i);
				newMap.put("count", 1);
				map.put(arr[i], newMap);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]).get("count") > degree) {
				degree = map.get(arr[i]).get("count");
			}

		}
		System.out.println("degree is " + degree);
		
		int minSize = Integer.MAX_VALUE;
		int currentSize = Integer.MIN_VALUE;
		for (int i = 0 ; i < arr.length; i++) {
			if (map.get(arr[i]).get("count") == degree) {
				//System.out.println( "last indes and  first index " + map.get(arr[i]).get("lastIndex") + " " + map.get(arr[i]).get("firstIndex") );
				currentSize = map.get(arr[i]).get("lastIndex") - map.get(arr[i]).get("firstIndex") + 1;
				// System.out.println( "currentSize is " + currentSize);
			}
			
			if (minSize > currentSize && currentSize != Integer.MIN_VALUE) {
				//System.out.println("minsize before "+ minSize);
				minSize = currentSize;
				//System.out.println("minsize after "+ minSize);
			}
		}
		System.out.println("minSize final is " + minSize);
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		ArrayDegreeinHash sol = new ArrayDegreeinHash();
		System.out.println("n is " + n + "  arr length is " + arr.length);
		sol.findDegree(arr);
	}
}

/*
 * Your previous C++ content is preserved below:
 */