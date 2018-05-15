package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StackOfCards {
	public HashMap<String, HashSet<String>> hashSet = new HashMap<String, HashSet<String>>();
	HashMap<String, Integer> newdataSet = new HashMap<String, Integer>();

	public HashMap<String, Integer> getReportees(HashMap<String, String> map) {

		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (hashSet.containsKey(entry.getValue())) {
				if (!entry.getValue().contentEquals(entry.getKey())) {
					HashSet<String> hs = hashSet.get(entry.getValue());
					hs.add(entry.getKey());
					hashSet.put(entry.getValue(), hs);
				}

			} else {
				if (!entry.getValue().contentEquals(entry.getKey())) {
					HashSet<String> hs = new HashSet<String>();
					hs.add(entry.getKey());
					hashSet.put(entry.getValue(), hs);
				}
			}
		}
		System.out.println(hashSet);

		return calculateReporteescount(map);
	}

	public HashMap<String, Integer> calculateReporteescount(
			HashMap<String, String> map) {

		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (!newdataSet.containsKey(entry.getValue())) {
				int reportees_count = hashSet.get(entry.getValue()).size();
				ArrayList<String> list = new ArrayList<String>(
						hashSet.get(entry.getValue()));
				reportees_count += calculateRecursively(list, 0);
				newdataSet.put(entry.getValue(), reportees_count);
			}

		}
		return newdataSet;
	}

	public int calculateRecursively(ArrayList<String> list, int reportees_count) {

		for (int i = 0; i < list.size(); i++) {
			if (hashSet.containsKey(list.get(i))) {
				reportees_count += hashSet.get(list.get(i)).size();
				ArrayList<String> newlist = new ArrayList<String>(
						hashSet.get(list.get(i)));
//				if (newdataSet.containsKey(list.get(i))) {
//					reportees_count += newdataSet.get(list.get(i));
//				} else {
					reportees_count += calculateRecursively(newlist, 0);
				//}
				
			}
		}
		return reportees_count;
	}

	public static void main(String args[]) {
		HashMap<String, String> dataSet = new HashMap<String, String>();
		dataSet.put("A", "F");
		dataSet.put("B", "C");
		dataSet.put("C", "D");
		dataSet.put("D", "A");
		dataSet.put("E", "F");
		dataSet.put("F", "F");

		StackOfCards obj = new StackOfCards();
		HashMap<String, Integer> reportees = obj.getReportees(dataSet);
		System.out.println(reportees);
	}

}