package tokens;

public class StringToken extends Token
{
	private boolean _unclosedString = false;
	public StringToken(String tokenStr)
	{
		super(tokenStr);
	}

	public boolean get_UnclosedString() 
	{
		return _unclosedString;
	}
	
	@Override
	protected String Gobble(String line) 
	{
		for(int i = 0; i < line.length(); i++) 
		{
			char charAt = line.charAt(i);
			char charAt2 = (i + 1) < line.length() ? line.charAt(i+1) : ' ';
			_contents += charAt;
			if(charAt2 == '\'') return line.substring(i+1);
		}
		_unclosedString = true;
		return "";
	}
	
	@Override
	protected boolean stopGobbling(char charAt)
	{
		return true;
	}

}
