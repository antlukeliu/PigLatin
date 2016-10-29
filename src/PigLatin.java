/* 
 Welcome to the Pig Latin Translator
 This program will find the first volume in your word and move all
 of the consonants that appear before the first vowel to the end of
 the word, then add "ay" to the end of the word
 If the word starts with a vowel, it will add "way" to the end
  */

import java.util.Scanner;

public class PigLatin {
	 
	 public static void main(String[] args) {
		
		boolean cont = true;	
		System.out.println("Welcome to the Pig Latin Translator");
		
		do{
			String []myArray = checkInput();
			StringBuilder var = translating(myArray);
			System.out.println(var);
			char response = checkingForYesOrNo();
			cont = translatingAgain(response);
			exitting(cont);
		   }
		while(cont);
	 }
	
	//Checks to make sure text is enter 
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
	 
	 //Method to find the index of where the first volume is located
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
	}
	
	//Method to check if y or no is valid 
	public static char checkingForYesOrNo(){
		Scanner sc = new Scanner(System.in);
		String response = "";
		boolean cont = true;
		System.out.print("\nTranslate again? (y/n): ");
		response = sc.nextLine();
		while(cont){
			
			if (response.toLowerCase().charAt(0) != 'y' && response.toLowerCase().charAt(0) != 'n'){
				System.out.print("Translate again? Enter only y or n: ");
				response = sc.nextLine();}
			else{
				break;
			}
		}
		return response.toLowerCase().charAt(0);
	}
	
	//Method to check if we y was enter to continue the loop
	public static boolean translatingAgain(char response){
		if (response == 'y'){
			return true;
		} else{
			return false;
		}
	}
	
	//Closing message
	public static void exitting(boolean cont){
		if (cont == false){
			System.out.println(	"\nHave an awesome day!");
		}
	}
	
	//Method to translate word and return in string form 
	public static String translating(String word, int num){
		String specialChar = "@#$%^&"; 
		
		for (int i = 0; i<word.length(); i++){
			for(int j = 0; j<specialChar.length(); j++){
				if (specialChar.charAt(j) == word.charAt(i)){
					return word;
				}
			}
		}
		if (word.matches(".*\\d+.*")){
			return word;
		}
		else if (num == 0){
			return word + "way";
			
		}else {
			return (word.substring(num, word.length()) 
					+ word.substring(0,num) + "ay");
		} 
	}
	
	//Appending each piece in the array into a complete String
	public static StringBuilder translating(String[] myArray){
		
		StringBuilder strBuilder = new StringBuilder();
		
		for (int k = 0; k<myArray.length; k++){
			int i = findingIndex(myArray[k]);
			String newWord = translating(myArray[k], i);
			strBuilder.append(newWord + " ");
		}
	return strBuilder;
	}
}
