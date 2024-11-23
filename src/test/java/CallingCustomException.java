import java.util.Scanner;

@SuppressWarnings("serial")
public class CallingCustomException  extends CustomException{

	public CallingCustomException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Enter a numerator value");
        int numerator = sc.nextInt();//nextLine() for string;nextDouble() for double;
        System.out.println("Enter denominator values");
        int denominator=sc.nextInt();
        
        try {
        	if(denominator==0)
        		throw new CustomException("Error: Cannot divide by zero");
        	int result=numerator/denominator;
        	System.out.println(result);
        }
        catch(CustomException e) {
        	System.out.print(e.getLocalizedMessage());
        }
        finally {
        	sc.close();
        }

	}

}
