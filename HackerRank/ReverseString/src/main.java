import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		 Scanner sc=new Scanner(System.in);
	        String A=sc.next();
	        /* Enter your code here. Print output to STDOUT. */
	 
		
		// TODO Auto-generated method stub
		StringBuilder string = new StringBuilder();
		
		for(int i = A.length()-1;i>=0;i--) {
			string.append(A.charAt(i));
		}
		
		if(string.toString().equals(A))
			System.out.println("Yes");
		
		System.out.println(string);
	}

}
