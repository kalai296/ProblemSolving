package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class stringPermutation {

	public static int count  = 0;
    static String biggerIsGreater(String w) {
        // Complete this function
        
        biggerIsGreaterUtil(w, 0, w.length() -1 );
        return w;
    }
    
    public static void biggerIsGreaterUtil(String w, int start, int end) {
        if (start == end){
            System.out.println(w);
            count++;
            System.out.println(count);
        }
        else
        {
            for (int i = start; i <= end; i++) {
                w = swap(w, start, i);
                biggerIsGreaterUtil(w, start+1, end);
                w = swap(w, start, i);
            }
            
        }
        
    }
    
    public static String swap(String str, int start, int end) {
        char arr[] = str.toCharArray();
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        return String.valueOf(arr);
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            String w = in.next();
            String result = biggerIsGreater(w);
            System.out.println("result is " + result);
        }
        in.close();
    }
}
