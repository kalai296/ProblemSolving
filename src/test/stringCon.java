package test;

import java.io.*;
import java.util.*;

public class stringCon {

	public static void main(String[] args) {
		
		   

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		TreeMap<Integer, TreeSet<Integer>> endTimeAndOrderNoMap = new TreeMap<Integer, TreeSet<Integer>>();

		for (int i = 0; i < n; i++) {
			int endTime = in.nextInt() + in.nextInt();

			if (endTimeAndOrderNoMap.containsKey(endTime)) {
				endTimeAndOrderNoMap.get(endTime).add(i + 1);
			} else {
				TreeSet<Integer> orderNoSet = new TreeSet<Integer>();
				orderNoSet.add(i + 1);
				endTimeAndOrderNoMap.put(endTime, orderNoSet);
			}
		}

		for (TreeSet<Integer> orderNos : endTimeAndOrderNoMap.values()) {
			for (Integer order : orderNos)
				System.out.print(order + " ");
		}

	}
}
