package passwordgenerator;
class Password
{
	String Value = "";
	int Length ;
	Password(String s)
	{
		Value = s;
		Length = s.length();
	}

	public String calculateScore()
	{
		int score = passwordstrength();
		if(score == 6)
		{
			return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
		}
		else if(score >= 4)
		{
			return "This is a good password :) but you can still do better";
		}
		else if(score >= 3)
		{
			return "This is a medium password :/ try making it better";
		}
		return "This is a weak password :( definitely find a new one";
	}

	private int passwordstrength()
	{
		String s = Value;
		boolean upper = false;
		boolean lower = false;
		boolean digit = false;
		boolean symbol = false;
		int type;
		int score = 0;
		
		for(char ch : s.toCharArray())
		{
			type = charType(ch);
			
			if(type == 1) upper = true;
			if(type == 2) lower = true;
			if(type == 3) digit = true;
			if(type == 4) symbol = true;
		}
		if(upper) score++;
		if(lower) score++;
		if(digit) score++;
		if(symbol) score++;
		
		if(Length >= 8) score++;
		if(Length >= 16) score++;
		
		return score;
	}

	private int charType(char ch)
	{	
		int val =0;
		if(Character.isUpperCase(ch))
		{
			val = 1;
		}
		else if(Character.isLowerCase(ch))
		{
			val = 2;
		}
		else if(Character.isDigit(ch))
		{
			val = 3;
		}
		else
		{
			val =4;
		}
		return val;
	}
}