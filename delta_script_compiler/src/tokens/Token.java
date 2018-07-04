package tokens;

public abstract class Token 
{
	protected String _contents = "";
	protected Token _next;
	
	public static Token CreateToken(String tokenStr) 
	{
		char ch = ' ';
		while(tokenStr.length() > 0 && isWhitespace((ch = tokenStr.charAt(0)))) tokenStr = tokenStr.substring(1);
		if(tokenStr.length() <= 0) return null;
		
		char ch2 = tokenStr.length() >= 2 ? tokenStr.charAt(1) : ' ';
		if(isAlpha(ch) || isPrefix(ch)) return new WordToken(tokenStr);
		else if(isNumeric(ch)) return new NumberToken(tokenStr);
		else if((ch == '/' && ch2 == '*') && (ch == '-' && ch2 == '-')) return new CommentToken(tokenStr, (ch == '/'));
		else if(ch == '\'') return new StringToken(tokenStr.substring(1));
		else if(isSymbol(ch)) return new SymbolToken(tokenStr);
		return null;
	}
	
	public Token(String line) 
	{
		_next = CreateToken(Gobble(line));
	}
	
	public Token get_NextToken()
	{
		return _next;
	}
	
	public void set_NextToken(Token next) 
	{
		_next = next;
	}
	
	public Token get_LastToken() 
	{
		if(_next == null) return this;
		else return _next.get_LastToken();
	}
	
	public String get_Contents() { return _contents; }
	
	protected static boolean isAlpha(char ch) 
	{
		return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
	}
	
	protected static boolean isNumeric(char ch) 
	{
		return (ch >= '0' && ch <= '9');
	}
	
	protected static boolean isWhitespace(char ch) 
	{
		return (ch == ' ' || ch == '\n' || ch == '\t');
	}
	
	protected static boolean isSymbol(char ch) 
	{
		return ((ch >= '!' && ch <= '/') || (ch >= ':' && ch <= '@') || 
			   (ch >= '[' && ch <= '_') || (ch >= '{' && ch <= '~'));
	}
	
	protected static boolean isPrefix(char ch) 
	{
		return ch == '@' || ch == '#';
	}
	
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

	protected abstract boolean stopGobbling(char charAt);
}
