package main;

public class Driver {

	public static void main(String[] args) {
		System.out.println("_________________________________________________________________________");
		System.out.println("|***********************************************************************|");
		System.out.println("|*---------------------------------------------------------------------*|");
		System.out.println("|*                                                                     *|");
	    System.out.println("|*                 WELCOME TO PAYROLL SALARY MANAGEMENT                *|");
	    System.out.println("|*                                                                     *|");
	    System.out.println("|*---------------------------------------------------------------------*|");
	    System.out.println("|***********************************************************************|");
	    System.out.println("|_______________________________________________________________________|");
	    String un1=new String("admin");
	    String pw1=new String("admin");
	    java.util.Scanner sc=new java.util.Scanner(System.in);
	    System.out.println("Please enter UserName");
	    String username=sc.next();
	    System.out.println("Please enter Password");
	    String password=sc.next();
	    
	    if(username.compareTo(un1)==0 || password.compareTo(pw1)==0)
	    {
		MenuHandler mh= new MenuHandler();
		mh.handle();
	    }
	    else{
	    	System.out.println("incorrect username and password");
	    }
	}
}
