import java.io.*;
class FileRead 
{
   public static void main(String args[])
	{
      try
      {
		 
		 
		FileInputStream fstream = new FileInputStream("D:/compress.txt");
		
		DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuffer sb = new StringBuffer();
		String strLine;
		
		while ((strLine = br.readLine()) != null) 	
		{
			sb.append(strLine);
			System.out.println(sb);
			
			
		}
		
		in.close();
		}
      catch (Exception e)
      {
			System.err.println("Error: " + e.getMessage());
      }
	}
}

