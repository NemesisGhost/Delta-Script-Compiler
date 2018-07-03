package tokens;

public class NumberToken extends Token
{
	public NumberToken(String tokenStr)
	{
		super(tokenStr);
	}
	
	@Override
	protected boolean stopGobbling(char charAt)
	{
		return !isNumeric(charAt); 
	}

}
