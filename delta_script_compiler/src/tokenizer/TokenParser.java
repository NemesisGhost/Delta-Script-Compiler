package tokenizer;

import java.util.List;

public class TokenParser 
{
	String _line;
	boolean _isAlphaNumeric;
	boolean _isNumeric;
	boolean _isComment;
	boolean _isMultiLineComment;
	boolean _isString;
	
	public TokenParser(String line) 
	{
		_line = line;
	}
	
	public List<String> ParseLine() 
	{
		for(int i = 0; i < _line.length(); ++i) 
		{
			char ch = _line.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) 
			{
				
			} 
			else if(ch >= '0' && ch <= '9') 
			{
				
			}
			else if((ch == ' ') || (ch =='\n') || (ch == '\t')) 
			{
				
			} 
			else if((ch == '(') || (ch == ')') || (ch == '*')) 
			{
				
			}
		}
		
		return null;
	}
	
	private void Reset() 
	{
		_isAlphaNumeric = _isNumeric = _isComment = _isMultiLineComment = _isString = false;
	}
}
