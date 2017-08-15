package cWS;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIO {

	public static String ReadFile(String file,String encode) throws IOException{
		File f=new File(file);
		FileInputStream fis=new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis,encode);
		BufferedReader reader = new BufferedReader(isr);
		StringBuffer sb=new StringBuffer();
		String s;
		while((s=reader.readLine()) != null){
			sb.append(s+"\n");
		}
		reader.close();
		isr.close();
		fis.close();
		return sb.toString();
	}
	
	public static void WriteFile(String path,String output,boolean append) throws IOException
	{
		FileWriter fw=new FileWriter(path,append);
	    fw.write(output);
	    fw.close();
	}
	
}
