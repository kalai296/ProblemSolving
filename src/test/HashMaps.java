package test;

import java.util.Scanner;
import java.util.*;

public class HashMaps {

		public static int numberNeeded(String first, String second) {
	        HashMap<Character, Integer> anagram = new HashMap<Character, Integer>();
	        int numberOfDeletions = 0;
	        for(char f: first.toCharArray())
	        {
	        	if (anagram.containsKey(f))
	        		anagram.put(f, anagram.get(f)+1);
	        	else
	        		anagram.put(f, 1);
	        }
	        
	        for(char s: second.toCharArray())
	        {
	        	if (anagram.containsKey(s))
	        		anagram.put(s, anagram.get(s)-1);
	        	else
	        		numberOfDeletions++;
	        }
	        
	        
	        for(Map.Entry<Character, Integer> map: anagram.entrySet()) {
	        	if(map.getValue() != 0) {
	        		numberOfDeletions += Math.abs(map.getValue());
	        	}
	        }
	        return numberOfDeletions;
	      
	    }
	
	    public static void main(String[] args) {
	    	int no = numberNeeded("fsqoiaidfaukvngpsugszsnseskicpejjvytviya", "ksmfgsxamduovigbasjchnoskolfwjhgetnmnkmcphqmpwnrrwtymjtwxget");
	    	System.out.println(no);
//	        Scanner in = new Scanner(System.in);
//	        int m = in.nextInt();
//	        int n = in.nextInt();
//	        
//	        String magazine[] = new String[m];
//	        for(int magazine_i=0; magazine_i < m; magazine_i++){
//	            magazine[magazine_i] = in.next();
//	        }
//	        
//	        String ransom[] = new String[n];
//	        for(int ransom_i=0; ransom_i < n; ransom_i++){
//	            ransom[ransom_i] = in.next();
//	        }
//	        
//	        HashMap <String, Long> magazine_hash = new HashMap<String, Long>(magazine.length);
//	        for (int i = 0; i < magazine.length; i++) {
//	        	if ( magazine_hash.containsKey(magazine[i]) ) {
//	        		long value = magazine_hash.get(magazine[i]);
//	        		magazine_hash.put(magazine[i], value+1);
//	        		value = magazine_hash.get(magazine[i]);
//	        		System.out.println("magazine hash is " + magazine[i] + " "+ "magazine value is " + value);
//	        	} else
//	        	{
//	        	    magazine_hash.put(magazine[i], (long)1);
//	        	    long value = magazine_hash.get(magazine[i]);
//	        	    System.out.println("magazine hash is " + magazine[i] + " "+ "magazine value is " + value);
//	        	}
//	        }
//	        
//	        HashMap <String, Long> ransom_hash = new HashMap<String, Long>(ransom.length);
//	        for (int i = 0; i < ransom.length; i++) {
//	        	if ( ransom_hash.containsKey(ransom[i]) ) {
//	        		long value = ransom_hash.get(ransom[i]);
//	        		ransom_hash.put(ransom[i], value+1);
//	        		value = ransom_hash.get(ransom[i]);
//	        		System.out.println("ransom hash is " + ransom[i] + " " + "ransom value is " + value);
//	        	} else
//	        	{
//	        		ransom_hash.put(ransom[i], (long)1);
//	        		long value = ransom_hash.get(ransom[i]);
//	        	    System.out.println("ransom hash is " + ransom[i] + " "+ "ransom value is " + value);
//	        	}
//	        }
//	        boolean isRansom = false;
//	        for (int i = 0; i < ransom.length; i++) {
//	        	System.out.println("ransom hash is " + ransom_hash.get(ransom[i]) + " " + "magazine hash is "+ " "+ magazine_hash.get(ransom[i]));
//	        	if (ransom_hash.get(ransom[i]) > magazine_hash.get(ransom[i])) {
//	        		System.out.println("No");
//	        		isRansom = true;
//	        		break;
//	        	}
//	        }
//	        if (!isRansom)
//	        System.out.println("Yes");
//	        
//	        in.close();
	    }

}
