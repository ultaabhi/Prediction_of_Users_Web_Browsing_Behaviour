
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main 
{
  public static void main(String[] args) 
  {
    File file = new File("outfile.txt");
    if (!file.exists()) 
    {
      System.out.println( "file does not exist.");
      return;
    }
    if (!(file.isFile() && file.canRead())) 
    {
      System.out.println(file.getName() + " cannot be read from.");
      return;
    }
    try 
    {
    	StringBuffer sb = new StringBuffer();
    	FileInputStream fis = new FileInputStream(file);
    	char current;
    	String s="";
    	String abc = "";
    	while (fis.available() > 0) 
    	{
    		current = (char) fis.read();
    		String str=Character.toString(current);
    		
    		if(!(str.equals(" ")))
    		{

    			s=str+"-";

    			abc=abc+s;
    			
    		}
       
      }
    	
    	 System.out.println(abc);
    	
    	
    } 
    catch (IOException e) 
    {
      e.printStackTrace();
    }
  }
}
