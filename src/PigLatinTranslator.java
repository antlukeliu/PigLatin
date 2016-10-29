
import java.util.Scanner;


public class PigLatinTranslator {
	
	static String vowels = "aeiou";
	//So i need to loop so that check if 
	 public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean cont = true;
			
		do{
			System.out.print("Enter a line to be translated: ");
			String line = sc.next();
			String[] myArray = line.split(" ");

			int i = findingIndex(line);
			if (i == 0){
				System.out.println(line + "way");
				
			}else {System.out.println(line.substring(i,line.length()) 
								+ line.substring(0,i) + "ay");
			}
		char response = checkingForYesOrNo();
		cont = rollingAgain(response);
		exitting(cont);
		}while(cont);
	 }
	 
	//methods 
	 
	 public static int findingIndex(String word){
		int i;
		int j;
		
		outerloop:
		for (i = 0; i<word.length(); i++){
			for(j = 0; j<vowels.length(); j++){
				if (vowels.charAt(j) == word.toLowerCase().charAt(i)){
					break outerloop;
				} 
			}	
		}
		return i;
	} //bracket for findingIndex
	
	public static char checkingForYesOrNo(){
		Scanner sc = new Scanner(System.in);
		String response = "";
		boolean cont = true;
		System.out.print("Roll again? (y/n): ");
		response = sc.next();
		while(cont){
			
			if (response.charAt(0) != 'y' && response.charAt(0) != 'n'){
				System.out.print("Translate again? Enter only y or n: ");
				response = sc.next();}
			else{
				break;
			}
		}
		return response.charAt(0);
	}
	
	public static boolean rollingAgain(char response){
		if (response == 'y'){
			return true;
		} else{
			return false;
		}
	}
	public static void exitting(boolean cont){
		if (cont == false){
			System.out.println(	"Goodbye!");
		}
	}
}//bracket for entire class
