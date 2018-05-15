package test;

import java.util.Stack;

public class LinkedListLoop {
	
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	Node head;
	
	public void pushNode(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	public void displayList(Node node) {
		while(node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	public boolean findLoop(Node node) {
		Node slowPtr = head, fastPtr = head;
		
		while (slowPtr != null && fastPtr != null) {
			
			slowPtr = slowPtr.next;
			
			if (slowPtr == null)
				return false;
			
			fastPtr = fastPtr.next.next;
			
			if(fastPtr == null)
				return false;
			
			if(slowPtr == fastPtr)
				return true;
		}
		return false;
			
	}
	
	public static boolean isBalanced(String expression) {
        char brackets[] = expression.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        if (brackets.length%2 != 0)
        	return false;
        else
        	for(char c: brackets) {
        		switch(c) {
        		case '[':
        			stack.push(']');
        			break;
        		case '(':
        			stack.push(')');
        			break;
        		case '{':
        			stack.push('}');
        			break;
        		default:
        			if(stack.isEmpty() || stack.peek() != c)
        				return false;
        		}
        	}
        return stack.isEmpty();
    }
	
	 static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
        	stackNewestOnTop.push(value);
        }

        public T peek() {
             if (stackOldestOnTop.isEmpty()) {
            	 while(!stackNewestOnTop.isEmpty()) {
            		 stackOldestOnTop.push(stackNewestOnTop.pop());
            	 }
             }
             return stackOldestOnTop.peek();
        }

        public T dequeue() {
        	if (stackOldestOnTop.isEmpty()) {
           	 while(!stackNewestOnTop.isEmpty()) {
           		 stackOldestOnTop.push(stackNewestOnTop.pop());
           	 }
            }
        	return stackOldestOnTop.pop();
        }
    }
	
	public static void main (String args[]) {
		LinkedListLoop list = new LinkedListLoop();
		list.head = list.new Node(1);
		list.head.next = list.new Node(2);
		list.head.next.next = list.new Node(3);
		list.head.next.next.next = list.new Node(4);
		list.head.next.next.next.next = list.new Node(5);
		list.head.next.next.next.next.next = list.new Node(6);
		//list.head.next.next.next.next.next.next = list.head.next.next;
		System.out.println(list.findLoop(list.head));
		//list.displayList(list.head);
		
	}

}
