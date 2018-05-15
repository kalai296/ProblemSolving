package test;

public class BinarySearchTree {
	
	class Node {
	    int data;
	    Node left, right;
	    public Node(int data) {
	        this.data = data;
	        left = right = null;
	    }
	}
	 Node root, prev = null;
    
//    boolean isBST()  {
//        prev = null;
//        return isBST(root);
//    }
    
     boolean isBST(Node node) {
        if (node != null) {
            
            if (!isBST(node.left))
                return false;
            
            if(prev != null && node.data <= prev.data)
                return false;
            prev = node;
            
            return isBST(node.right);
                
        }
        return true;
    }
     
     public void printTree(Node node) {
    	 if(node != null) {
    		 printTree(node.left);
    		 System.out.println(node.data);
    		 printTree(node.right);
    	 }
     }
     
     public Node push() {
    	 root = new Node(4);
         root.left = new Node(2);
         root.right = new Node(5);
         root.left.left = new Node(1);
         root.left.right = new Node(3);
         return root;
     }

    public static void main (String args[]) {
        BinarySearchTree tree = new BinarySearchTree();
        //Node root = tree.push();
        tree.root = tree.new Node(4);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(5);
        tree.root.left.left = tree.new Node(1);
        tree.root.left.right = tree.new Node(3);
//        BinarySearchTree.Node treeN = tree.new Node(4);
//        treeN.left = tree.new Node(2);
//        treeN.right = tree.new Node(5);
//        treeN.left.left = tree.new Node(1);
//        treeN.left.right = tree.new Node(3);
//        boolean bst = tree.isBST(treeN);
//        System.out.println(bst);
//        tree.printTree(treeN);
        boolean bst = tree.isBST(tree.root);
        System.out.println(bst);
        tree.printTree(tree.root);
    }
}