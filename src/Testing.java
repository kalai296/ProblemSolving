import java.util.Scanner;

public class Testing {
	public static String statics = "static";
	public String nonstatics = "nonstatic";
	
	Testing() {
		System.out.println(nonstatics);
		// System.out.println(new Testing().nonstatics);
		Testing.staticmethod();
		staticmethod2();
	}
	
	public void nonstaticmethod() {
		System.out.println(statics);
		//System.out.println(new Testing().nonstatics);
		System.out.println(nonstatics);
		System.out.println(statics);
		//staticmethod2();
		//new Testing().staticmethod2();
		//Testing.staticmethod();
	}
	
	public void staticmethod2() {
		System.out.println(statics);
		// System.out.println(new Testing().nonstatics);
		System.out.println(nonstatics);
		System.out.println(statics);
		this.staticmethod();
		this.nonstaticmethod();
	}
	
	public static void staticmethod() {
		System.out.println(statics);
		// this.staticmethod2();
		// System.out.println(new Testing().nonstatics);
		//System.out.println(nonstatics);
		//System.out.println(new Testing().nonstatics);
		// System.out.println(new Testing().statics);
		// new Testing().nonstaticmethod();
	}
	
	static Scanner scan = new Scanner(System.in); //Creating object
	static String number = scan.nextLine(); // Getting input
	// 
	
	public static void main(String args[]) {
		int i = Integer.MIN_VALUE;
		System.out.println(i);
		System.out.println(Integer.parseInt(number)); 
		// System.out.println(Testing.statics);
		// System.out.println(new Testing().nonstatics);
		//
		// staticmethod();
	}
	
	 static{  
		  System.out.println("static block is invoked");  
		 // System.exit(0);  
		  }  
}
