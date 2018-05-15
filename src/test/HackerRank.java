package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HackerRank {

	static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {
		// Complete this function
		List<Integer> alice = new ArrayList<Integer>();
		alice.add(a0);
		alice.add(a1);
		alice.add(a2);
		List<Integer> bob = new ArrayList<Integer>();
		bob.add(b0);
		bob.add(b1);
		bob.add(b2);
		int result[] = { 0, 0 };
		for (int i = 0; i < alice.size(); i++) {
			if (alice.get(i) > bob.get(i)) {
				System.out.println(alice.get(i));
				result[0] += 1;
			} else if (alice.get(i) < bob.get(i)) {
				result[1] += 1;
			}
		}
		return result;
	}

	static void plusMinus() {
		// Complete this function
		int arr[] = { -4, 3, -9, 0, 4, 1 };
		float positiveCount = 0, negativeCount = 0, zeroCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				positiveCount++;
			} else if (arr[i] < 0) {
				negativeCount++;
			} else {
				zeroCount++;
			}
		}
		System.out.println(positiveCount);
		System.out.println(negativeCount);
		System.out.println(zeroCount);
		System.out.printf("%.5f", positiveCount / arr.length);
		System.out.printf("%.5f", negativeCount / arr.length);
		System.out.printf("%.5f", zeroCount / arr.length);
	}

	public Integer[] calculate_grade() {
		List<Integer> gradeList = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of students");
		int n = sc.nextInt();
		System.out.println("Enter the grade for the students");
		for (int i = 0; i < n; i++) {
			gradeList.add(sc.nextInt());
		}

		// Iterator<Integer> iterator = gradeList.iterator();
		for (int i = 0; i < n; i++) {
			int roundValue = gradeList.get(i) % 5;
			int difference = 5 - roundValue;
			if (gradeList.get(i) >= 38 && difference < 3) {
				gradeList.set(i, gradeList.get(i) + difference);
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(gradeList.get(i));
		}
		
		Integer[] result = (Integer[]) gradeList.toArray();
		sc.close();
		return result;
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		int a0 = in.nextInt();
//		int a1 = in.nextInt();
//		int a2 = in.nextInt();
//		int b0 = in.nextInt();
//		int b1 = in.nextInt();
//		int b2 = in.nextInt();
		// int[] result = solve(a0, a1, a2, b0, b1, b2);
		// for (int i = 0; i < result.length; i++) {
		// System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		// }
		// System.out.println("");
		HackerRank hr = new HackerRank();
		Integer[] result = hr.calculate_grade();
		in.close();
	}
}
