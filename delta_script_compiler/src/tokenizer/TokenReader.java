package tokenizer;

import java.io.IOException;

import common.LineReader;

public class TokenReader 
{
	LineReader _reader;
	public TokenReader(LineReader reader)
	{
		_reader = reader;
	}
	
	public void ReadTokens() throws IOException 
	{
		String line;
		while((line = _reader.ReadLine()) != null) 
		{
			
		}
	}
}
