import java.util.Scanner;


public class PigLatin {
	
	//So i need to loop so that check if 
	 public static void main(String[] args) {
		
		boolean cont = true;	
		System.out.println("Welcome to the Pig Latin Translator");
		
		do{
			String []myArray = checkInput();
			StringBuilder var = translating(myArray);
			System.out.println(var);
			char response = checkingForYesOrNo();
			cont = rollingAgain(response);
			exitting(cont);
		   }
		while(cont);
	 }
	//methods
	 
	 public static String[] checkInput(){
		 
		 Scanner sc = new Scanner(System.in);
		 String[] myArray;
		 
		 while (true){
			 System.out.print("Enter a line to be translated: ");
			 String line = sc.nextLine();
			 if (line.equals("")) continue;
			 
			 else{
				myArray = line.split(" ");
				break;
			 }
		 }
		 return myArray;
	 }
	 
	 public static int findingIndex(String word){
		
		String vowels = "aeiou";
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
		System.out.print("\nTranslate again? (y/n): ");
		response = sc.next();
		
		while(cont){
			
			if (response.toLowerCase().charAt(0) != 'y' && response.toLowerCase().charAt(0) != 'n'){
				System.out.print("Translate again? Enter only y or n: ");
				response = sc.next();}
			else{
				break;
			}
		}
		return response.toLowerCase().charAt(0);
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
			System.out.println(	"\nHave an awesome day!");
		}
	}
	public static String translating(String word, int num){
		
		if (word.matches(".*\\d+.*")){
			return word;
		}else if(word.matches(".*@.*")){
			return word;
		}
		else if (num == 0){
			return word + "way";
			
		}else {
			return (word.substring(num, word.length()) 
					+ word.substring(0,num) + "ay");
		} 
	}
	public static StringBuilder translating(String[] myArray){
		
		StringBuilder strBuilder = new StringBuilder();
		
		for (int k = 0; k<myArray.length; k++){
			int i = findingIndex(myArray[k]);
			String newWord = translating(myArray[k], i);
			strBuilder.append(newWord + " ");
		}
	return strBuilder;
	}
}//bracket for entire class
