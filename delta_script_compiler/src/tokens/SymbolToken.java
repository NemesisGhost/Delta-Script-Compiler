package tokens;

public class SymbolToken extends Token
{

	public SymbolToken(String line)
	{
		super(line);
	}

	@Override
	protected boolean stopGobbling(char charAt)
	{
		return isSymbol(charAt);
	}

}
