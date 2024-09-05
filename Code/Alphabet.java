package passwordgenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Alphabet
{
	public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String NUMBERS = "123456789";
	public static final String SYMBOLS = "@!#$%^~&*)+`=(<>_-/|";
	
	public StringBuilder pool = new StringBuilder();
	
	Alphabet(boolean inclupper,boolean incllower,boolean inclnumber,boolean inclsymbol)
	{
		
		
		if(inclupper) pool.append(UPPERCASE_LETTERS);
		
		if(incllower) pool.append(LOWERCASE_LETTERS);
		
		if(inclnumber) pool.append(NUMBERS);
		
		if(inclsymbol) pool.append(SYMBOLS);
	}
	
	public String getAlphabet()
	{
		List<Character> list = new ArrayList<>();
		
		for(int i=0;i<pool.length();i++)
		{
			list.add(pool.charAt(i));
		}
		Collections.shuffle(list);
		
		pool.setLength(0);
		
		for(char ch : list)
		{
			pool.append(ch);
		}
		return pool.toString();
	}
}
