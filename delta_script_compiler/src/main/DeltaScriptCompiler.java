package main;

import java.io.IOException;

import common.LineReader;
import tokens.TokenReader;

public class DeltaScriptCompiler {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String filePath = "";
		if(args.length <= 0) 
		{
			filePath = "deltaScript.sql";
		} else {
			filePath = args[0];
		}
		
		try {
			LineReader reader = new LineReader(filePath);
			TokenReader tokenReader = new TokenReader(reader);
			tokenReader.ReadTokens();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
