package main;

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
		
	}

}
