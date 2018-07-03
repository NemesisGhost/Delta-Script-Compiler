package tokens;

public class SymbolToken extends Token
{

	public SymbolToken(String line)
	{
		super(line);
	}

	@Override
	protected String Gobble(String line) 
	{
		for(int i = 0; i < line.length(); i++) 
		{
			char charAt = line.charAt(i);
			_contents += line.charAt(i);
			if(stopGobbling(charAt)) return line.substring(i);
		}
		return "";
	}
	
	@Override
	protected boolean stopGobbling(char charAt)
	{
		return true;
	}

}
