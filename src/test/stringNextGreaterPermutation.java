package test;

import java.io.*;
import java.util.*;

public class stringNextGreaterPermutation {
    
    public static String big(String s) {
        //String ans = s;
        char arr[] = s.toCharArray();
        int l = s.length();
        int i = l-1;
        //System.out.println(i+" "+s);
        while(i > 0){
            if(arr[i-1] < arr[i])
                break;
            i--;
        }
       
        if(i == 0){             //lexicographically highest
            return "no answer";
        }
            
        int j = l-1;
        while(j >= i){
            if(arr[i-1] < arr[j])
                break;
            j--;
        }
        
        char c = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = c;
        
        for(int k = i; k < l-1; k++) {
            c = arr[k];
            arr[k] = arr[l-k+i-1];
            arr[l-k+i-1] = c;
        }

        String ans = new String(arr);
        if(ans == s)
            return "no answer";
        else
            return ans;
        
        // Arrays.toString(a)
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        sc.nextLine();
        for(int t0 = 0; t0 < t; t0++) {
            String s = sc.nextLine();
            String ans = big(s);
            System.out.println(ans);
        }
        sc.close();
        
        
        }
    
}