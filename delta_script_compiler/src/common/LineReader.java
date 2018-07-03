package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineReader 
{
	File _file;
	FileReader _fileReader;
	BufferedReader _bufferedReader;
	boolean _closed = true;
	
	public LineReader(String path) throws FileNotFoundException 
	{
		_file = new File(path);
		_fileReader = new FileReader(_file);
		_bufferedReader = new BufferedReader(_fileReader);
		_closed = false;
	}
	
	public String ReadLine() throws IOException 
	{
		return _bufferedReader.readLine();
	}
	
	public void Close() throws IOException 
	{
		_fileReader.close();
		_closed = true;
	}
	
	public void finalize() 
	{
		if(!_closed) 
		{
			try {
				Close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
