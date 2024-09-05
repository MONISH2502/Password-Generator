package passwordgenerator;

import java.util.*;

public class Generator
{
	public static Scanner keyboard ;
	public Alphabet alpha ;
	Generator(Scanner scanner)
	{
		keyboard = scanner;
	}
	public void mainLoop()
	{
		System.out.println("WELCOME TO KUMARAN PASSWORD SERVICES :");
		printMenu();
		
		String option = "-1";
		
		while(!option.equals("4"))
		{
			option = keyboard.next();
			
			switch(option)
			{
			case "1":
			{
				requestPassword();
				printMenu();
				break;
			}
			case "2":
			{
				checkPassword();
				printMenu();
				break;
			}
			case "3":
			{
				printInfo();
				printMenu();
				break;
			}
			case "4":
			{
				printQuit();
				break;
			}
			default :
			{
				System.out.println();
				System.out.println("Please select one of the  available commands");
				printMenu();
			}
			}
		}
	}
	private void requestPassword()
	{		
		boolean inclupper = false;
		boolean incllower = false;
		boolean inclnumber = false;
		boolean inclsymbol = false;
		
		boolean correct;
		System.out.println();
		System.out.println("Hello, welcome to the Password Generator :) answer the following questions by Yes or No \n");
		
		do
		{
			String input;
			correct = false;
			
			do
			{
				System.out.println("Do you want Lowercase letters \\\"abcd...\\\" to be used? ");
				input = keyboard.next();
				wrongInput(input);
			}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
			
			incllower = isIclude(input);
			
			do
			{
				System.out.println("Do you want Uppercase letters \\\"ABCD...\\\" to be used? ");
				input = keyboard.next();
				wrongInput(input);
			}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
			
			inclupper = isIclude(input);
			
			do
			{
				System.out.println("Do you want Numbers \\\"123...\\\" to be used? ");
				input = keyboard.next();
				wrongInput(input);
			}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
			
			inclnumber = isIclude(input);
			
			do
			{
				System.out.println("Do you want Symbols \\\"$#@!&...\\\" to be used? ");
				input = keyboard.next();
				wrongInput(input);
			}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
			
			inclsymbol = isIclude(input);
			
			if(!inclupper && !incllower && !inclsymbol && !inclnumber)
			{
			System.out.println("You have selected no characters to generate your password, at least one of your answers should be Yes\n");
			correct = true;
			}
		}while(correct);
		System.out.println("Great now enter the length of your password :");
		int length = keyboard.nextInt();
		
		alpha = new Alphabet(inclupper,incllower,inclnumber,inclsymbol);
		String password = generatePassword(length);
		
		System.out.println("Your generated Password :  " + password);
	}
	
	
	private String generatePassword(int length)
	{	
		StringBuilder pass = new StringBuilder();
		int slength = alpha.getAlphabet().length();
		
		int range = slength-1;
		
		for(int i=0;i<length;i++)
		{
			int index = (int)(Math.random() * range);
			pass.append(alpha.getAlphabet().charAt(index));
		}
		return pass.toString();
	}
	
	
	private boolean isIclude(String s)
	{
		if(s.equalsIgnoreCase("yes"))
		{
			return true;
		}
		return false;
	}
	
	private void wrongInput(String s)
	{
		if(!s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("no"))
		System.out.println("You have entered something incorrect :( let's go over it again \n");
	}
	
	private void checkPassword() 
	{		
		String pword = "";
		System.out.println("ENTER YOUR PASSWORD :");
		pword = keyboard.next();
		
		Password p = new Password(pword);
		
		System.out.println(p.calculateScore());
	}
	
	
	private void printInfo() 
	{		
		 System.out.println();
	        System.out.println("Use a minimum password length of 8 or more characters if permitted");
	        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
	        System.out.println("Generate passwords randomly where feasible");
	        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
	        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
	                "\nusernames, relative or pet names, romantic links (current or past) " +
	                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
	        System.out.println("Avoid using information that the user's colleagues and/or " +
	                "acquaintances might know to be associated with the user");
	        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");	
	}
	
	
	private void printQuit()
	{		
	 System.out.println("Closing the progarm Bye :)");	
	}
	
	private void printMenu()
	{
		System.out.println();
		System.out.println("1 -> Password Genrator");
		System.out.println("2 -> Password Strength Check");
		System.out.println("3 -> Useful Information");
		System.out.println("4 -> Quit");
		System.out.println("Choice :");
	}
}