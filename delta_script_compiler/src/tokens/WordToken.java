package tokens;

public class WordToken extends Token
{
	public WordToken(String line) 
	{
		super(line);
	}
	
	@Override
	protected boolean stopGobbling(char charAt)
	{
		return !isAlpha(charAt) && !isNumeric(charAt); 
	}

}
