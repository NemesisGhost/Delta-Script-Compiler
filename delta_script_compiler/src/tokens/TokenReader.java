package tokens;

import java.io.IOException;
import common.LineReader;

public class TokenReader 
{
	LineReader _reader;
	public TokenReader(LineReader reader)
	{
		_reader = reader;
	}
	
	public Token ReadTokens() throws IOException 
	{
		String line;
		Token rtValue = null;
		Token lastToken = null;
		while((line = _reader.ReadLine()) != null) 
		{
			Token token;
			if(lastToken != null && lastToken instanceof CommentToken)
			{
				token = ((CommentToken)lastToken).gobbleMore(line);
			} 
			else 
			{
				token = Token.CreateToken(line);
			}
			
			if(token != null) 
			{
				lastToken.set_NextToken(token);
				lastToken = token.get_LastToken();
				if(rtValue == null) rtValue = token;
			}
		}
		
		return rtValue;
	}
}
