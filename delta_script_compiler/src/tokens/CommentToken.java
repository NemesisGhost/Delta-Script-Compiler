package tokens;

public class CommentToken extends Token
{
	private boolean _isMultiline = false;
	private int _openMultiLine = 0;
	public CommentToken(String tokenStr, boolean isMultiline) 
	{
		super(tokenStr);
		_isMultiline = isMultiline;
	}
	
	public Token gobbleMore(String tokenStr) 
	{
		String str;
		if(_isMultiline && _openMultiLine > 0)
			str = Gobble(tokenStr);
		else
			str = tokenStr;
		return Token.CreateToken(str);
	}
	
	public int get_OpenMultiLines() { return _openMultiLine; }
	
	@Override
	protected String Gobble(String line) 
	{
		boolean stopGobbling = false;
		for(int i = 0; i < line.length(); i++) 
		{
			char charAt = line.charAt(i);
			if(_isMultiline) 
			{
				char charAt2 = ' ';
				if((charAt == '/' || charAt == '*') && (i+1) < line.length()) charAt2 = line.charAt(i+1);
				if(charAt == '/' && charAt2 == '*') _openMultiLine++;
				if(charAt == '*' && charAt2 == '/') _openMultiLine--;
				if(_openMultiLine == 0) 
				{
					_contents = _contents.substring(2);
					return line.substring(i+1);
				}
			}
			_contents += line.charAt(i);
			
			if(stopGobbling) return line.substring(i);
		}
		return "";
	}
	
	@Override
	protected boolean stopGobbling(char charAt)
	{
		return true;
	}

}
