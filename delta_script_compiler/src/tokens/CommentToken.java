package tokens;

public class CommentToken extends Token
{
	private boolean _isMultiline = false;
	public CommentToken(String tokenStr, boolean isMultiline) 
	{
		super(tokenStr);
		_isMultiline = isMultiline;
	}
	
	@Override
	protected String Gobble(String line) 
	{
		int multiLineStarts = 0;
		boolean stopGobbling = false;
		for(int i = 0; i < line.length(); i++) 
		{
			char charAt = line.charAt(i);
			if(_isMultiline) 
			{
				char charAt2 = ' ';
				if((charAt == '/' || charAt == '*') && (i+1) < line.length()) charAt2 = line.charAt(i+1);
				if(charAt == '/' && charAt2 == '*') multiLineStarts++;
				if(charAt == '*' && charAt2 == '/') multiLineStarts--;
				if(multiLineStarts == 0) 
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
