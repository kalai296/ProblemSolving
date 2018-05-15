package test;

import java.util.HashSet;
import java.util.Scanner;

public class ElevatorStopping {

	public static Scanner sc = new Scanner(System.in);

	public int solution(int A[], int B[], int M, int X, int Y) {
		int iterator = 0, currentIterator = 0, bIterator = 0;
		int totalWeight = 0, totalPersons = 1, totalStops = 0;
		while (iterator < A.length) {

			for (iterator = currentIterator; iterator < A.length; iterator++) {
				if (totalWeight + A[iterator] <= Y && totalPersons <= M) {
					totalWeight += A[iterator];
					totalPersons++;
				} else {
					currentIterator = iterator;
					break;
				}
			}

			if (totalPersons == 2) {
				totalStops++;
			} else if (totalPersons == 1) {
			} else {
				// System.out.println("bIterator is" + " "+ bIterator +
				// "bIterator + totalPersons is" + " "+ (bIterator +
				// totalPersons-1));
				totalStops += stepsCount(B, bIterator, bIterator + totalPersons
						- 1);
			}
			if (totalPersons != 1) {
				totalStops++;
			}
			// System.out.println("totalStops is"+ " "+ totalStops);
			bIterator = iterator;
			totalPersons = 1;
			totalWeight = 0;
		}
		return totalStops;

	}

	public int stepsCount(int B[], int iterator, int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = iterator; i < n; i++) {
			if (!set.contains(B[i])) {
				set.add(B[i]);
			}
		}
		System.out.println("unique numbers count is" + " " + set.size());
		return set.size();
	}

	public void printNumbers(int N) {
		for (int i = 1; i <= N; i++) {
			if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0) {
				System.out.println("FizzBuzzWoof");
			} else if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0 && i % 7 == 0) {
				System.out.println("FizzWoof");
			} else if (i % 5 == 0 && i % 7 == 0) {
				System.out.println("BuzzWoof");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else if (i % 7 == 0) {
				System.out.println("Woof");
			} else {
				System.out.println(i);
			}
		}
	}

	public static void main(String args[]) {
		ElevatorStopping es = new ElevatorStopping();

		es.printNumbers(24);
		System.out.println("Enter the queue length");
		int n = sc.nextInt();
		int A[] = new int[n];
		int B[] = new int[n];
		// int A[] = {40,40,80,60,40}, B[] = {2,3,4,3,3};
		System.out.println("Enter the queue weight");
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}

		System.out.println("Enter the queue persons reachable floor");
		for (int i = 0; i < n; i++) {
			B[i] = sc.nextInt();
		}

		System.out
				.println("Enter the maximum number of persons to accomodated in elevator");
		int X = sc.nextInt();

		System.out
				.println("Enter the maximum weight to accomodated in elevator");
		int Y = sc.nextInt();

		System.out.println("Enter the maximum number of floors ");
		int M = sc.nextInt();
		// int M = 5, X = 3, Y = 200;
		for (int i = 0; i < A.length; i++) {
			System.out.println("Persons given weight" + " " + A[i]);
		}

		for (int i = 0; i < A.length; i++) {
			System.out.println("Persons floor" + " " + B[i]);
		}

		System.out.println("Maximum floors" + " " + M);
		System.out.println("Elevators maximum room for persons" + " " + X);
		System.out.println("Elevators maximum weight" + " " + Y);
		int totalStops = es.solution(A, B, M, X, Y);
		System.out.println("Elevator's total stops" + " " + totalStops);

	}
}
