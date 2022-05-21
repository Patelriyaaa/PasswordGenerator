/**
 *
 * @author riyapatel
 */
import java.util.Scanner;

public class Generator {
	boolean IncludeUpper=false;
	boolean IncludeLower=false;
	boolean IncludeNum=false;
	boolean IncludeSym=false;
	Alphabet alphabet;
	
	public Generator(boolean IncludeUpper,boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
		alphabet=new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
	}
	
	public Password GeneratePassword(int length) {
		final StringBuilder pass = new StringBuilder("");

		final int alphabetLength = alphabet.getAlphabet().length();
		
		int max = alphabetLength - 1; 
        int min = 0; 
        int range = max - min + 1; 
        
		
		
		for(int i=0;i<length;i++) {
			
			int index=(int)(Math.random() * range) + min; 
			
			pass.append(alphabet.getAlphabet().charAt(index));
		}
		
		return new Password(pass.toString());
		
	}
	
	
	public static void printUsefulInfo() {
		System.out.println();
		System.out.println("Use a minimum password length of 8 or more characters");
		System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols");
		System.out.println("Avoid using the same password twice or more");
		System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences, relative or pet names");
		System.out.println("Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user");
	}
	
	
	public static void requestPassword() {
		boolean IncludeUpper=false;
		boolean IncludeLower=false;
		boolean IncludeNum=false;
		boolean IncludeSym=false;
		String Input;
		final Scanner in = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Hello, welcome to the Password Generator,Please answer"
				+" the following questions by Y or N \n");
		
		
		while(true) {
			System.out.println("Do you want Lowercase letters to be used? ");
	        Input = in.nextLine();
	
	        if (Input.equals("Y") || Input.equals("Y") || Input.equals("yes")) {
	        	IncludeLower=true;
	        }
	        
	        else {
	        	if (!(Input.equals("N")) && (!Input.equals("N")) && (!Input.equals("no"))) {
	        		PasswordRequestError();
	        		break;
	        	}
	        }
	      
			System.out.println("Do you want Uppercase letters to be used? ");
			Input = in.nextLine();
	
			if (Input.equals("Y") || Input.equals("Y") || Input.equals("yes")) {
	        	IncludeUpper=true;
	        }
	        
			else {
	        	if (!(Input.equals("N")) && (!Input.equals("N")) && (!Input.equals("no"))) {
	        		PasswordRequestError();
	        		break;
	        	}
	        }
			
			System.out.println("Do you want Numbers to be used? ");
			Input = in.nextLine();
	
			if (Input.equals("Y") || Input.equals("Y") || Input.equals("yes")) {
	        	IncludeNum=true;
	        }
	        
			else {
	        	if ((Input.equals("N")==false) && (Input.equals("N")==false) && (Input.equals("no")==false)) {
	        		PasswordRequestError();
	        		break;
	        	}
	        }
			
			System.out.println("Do you want Symbols to be used? ");
			Input = in.nextLine();
	
			if (Input.equals("Y") || Input.equals("Y") || Input.equals("yes")) {
	        	IncludeSym=true;
	        }
	        
			else {
	        	if ((Input.equals("N")==false) && (Input.equals("N")==false) && (Input.equals("no")==false)) {
	        		PasswordRequestError();
	        		break;
	        	}
	        }
			
			//No Pool Selected
			if(!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
				System.out.println("You have selected no characters to generate your password at least one of your answers should be Yes");
				break;
			}
			
	        System.out.println("Great! Now enter the length of the password");
	        int length=in.nextInt();
	        
	        final Generator generator = new Generator (IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
	        
	        
	        final Password UserPass = generator.GeneratePassword(length);
	        
	        System.out.println(UserPass);
	        
	        in.close();
	        break;
		}
	}
	
	public static void PasswordRequestError() {
		System.out.println("You have entered something incorrect, You have to go over it again. \n");		
	
	}
	
	
	public static void checkPassword() {
		String input;
		final Scanner in = new Scanner(System.in);

		System.out.print("\nEnter your password:");
		input = in.nextLine();
		
		final Password p = new Password(input);
		
		System.out.println(p.calculateScore());
		
		in.close();
	}
	
	public static void printMenu() {
		System.out.println();
		System.out.println("Enter 1 - Password Generator");
		System.out.println("Enter 2 - Password Stength Check");
		System.out.println("Enter 3 - Useful Information");
		System.out.println("Enter 4 - Quit");
		System.out.print("Choice:");
	}
	
	public static void main(String[] args) {
		String Input;
		final Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Password Services " );
		printMenu();
		while (in.hasNextLine()) {
			
			Input = in.nextLine();
			
			if (Input.equals("1")) {
				requestPassword();
				printMenu();
			}
			
			else if (Input.equals("2")) {
				checkPassword();
				printMenu();
			}
			
			else if (Input.equals("3")) {
				printUsefulInfo();
				printMenu();
			}
			
			else if (Input.equals("4")) {
				break;
			}

			else {
				System.out.println();
				System.out.println("You must select one of the available options" );	
				printMenu();
			}
		}
		in.close();
	}
}
