package test;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class SlidingWindow {
  
  public static void deq(int arr[], int k) {
    
   Deque<Integer> dq = new LinkedList<Integer>();
   int i;
    
    for (i = 0; i < k; i++) {
      
      while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
        dq.removeLast();
        
      dq.addLast(i);
  }
  
    for ( ; i < arr.length; i++) {
      
      System.out.println(arr[dq.peekFirst()]);
      
      while(!dq.isEmpty() && dq.peek() <= i-k)
       dq.removeFirst();
      
      while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
        dq.removeLast();
      
      dq.addLast(i);
    }
  }
    
  public static void main(String[] args) {
    int arr[] = {1,2,3,4,5,6,7,8,9};
    int k = 3;
    deq(arr,k);
  }
}

