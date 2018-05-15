// Java program to detect loop in a linked list
class LinkedList
{
    static Node head;  // head of list
  
    /* Linked list Node*/
    static class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
  
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
  
        /* 3. Make next of new Node as head */
        new_node.next = head;
  
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    int detectLoop()
    {
        Node slow_p = head, fast_p = head; boolean loop_exists = false;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                System.out.println("Found loop");
                loop_exists = true;
                //return 1;
                break;
            }
        }
        
        if (loop_exists) {
        	slow_p = head;        	
        	while (slow_p.next != fast_p.next) {
        		slow_p = slow_p.next;
        		fast_p = fast_p.next;
        	}
        	
        	System.out.println(fast_p.data);
        	fast_p.next = null;
        	return slow_p.data;
        }
        return 0;
    }
 
 // Function to print the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    
    /* Drier program to test above functions */
    public static void main(String args[])
    {
        LinkedList llist = new LinkedList();
 
        head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        
        head.next.next.next.next.next = head.next.next;
       
 
        System.out.println(llist.detectLoop());
        llist.printList(head);
    }
} 
/* This code is contributed by Rajat Mishra. */