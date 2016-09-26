
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class StringSearch 
{

	/**
	 * @param args
	 */
	
	
	
	public ArrayList getDataFromFile(String file2)	
	{
		
	ArrayList at=new ArrayList();
	
	
	File file = new File("D:\\out.txt");
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    DataInputStream dis = null;
 ArrayList ar=new ArrayList();
 ArrayList sc=new ArrayList();




try 
{
    	
      fis = new FileInputStream(file);

      // Here BufferedInputStream is added for fast reading.
      bis = new BufferedInputStream(fis);
      dis = new DataInputStream(bis);
      ArrayList dp=new ArrayList();
      // dis.available() returns 0 if the file does not have more lines.
      while (dis.available() != 0) {

     //System.out.println(dis.readLine());
    	  
    
     
     sc.add(dis.readLine());
     
     
     
     
    	//  StringTokenizer st1 = new StringTokenizer(dis.readLine(), " ");
    	  
    	  // int count=st1.countTokens();
    	   
    	  // String scout[]=new String[count];
    	   
    	   
    	/*   
    	  while(st1.hasMoreTokens())
    		  
    	  {
    	  
    		  sc.add(st1.nextToken());
    		  
    	  }
  
    	  
    	  
    	  at.add(sc);
  */
    	  
      	  
    	 
    	  
    	  
    	//  dp.addAll(sc);
         	  
        
      }
   
      System.out.println("array list valuessc"+sc);
      HashSet hs= new HashSet(dp);
      
      ArrayList asr=new ArrayList(hs);
            
      // dispose all the resources after using them.
      fis.close();
      bis.close();
      dis.close();

    }
catch (FileNotFoundException e) 
    {
      e.printStackTrace();
    } 
catch (IOException e) 
    {
      e.printStackTrace();
    }
	
		
	return sc;
			
	}
	
	
	public ArrayList compress()
	{
		 ArrayList compress = new ArrayList();
		
		try
		{

			System.out.println("Compress Method ------------------------------ ");
			StringSearch sc=new StringSearch();
			ArrayList ar=sc.getDataFromFile("");
			
			
			//System.out.println("arraylist size is"+ar.size());
			
			 
			  compress.add(ar.get(0));
			for(int i=0;i<ar.size()-1;i++)
			{
						
				
			//	System.out.println("now compress"+compress);
				
				int j=i;
				
				
				int k=++j;
				
				
				if(((String)ar.get(k)).length()==((String)compress.get(compress.size()-1)).length())
				{
				
//					System.out.println("inside equal");
					
					if(((String)ar.get(k)).lastIndexOf((String)compress.get(compress.size()-1))>=0)
					{
//						System.out.println(compress.remove(compress.size()-1));
						compress.add(compress.size()-1,ar.get(k));
					}
					else{
						compress.add(ar.get(k));
						System.out.println("now--------------"+compress);
					}		
					
				}
				
				else if(((String)ar.get(k)).length()>((String)compress.get(compress.size()-1)).length())
				{
					System.out.println("-------- inside greater");
					if(((String)ar.get(k)).lastIndexOf(( String)compress.get(compress.size()-1))>=0)
					{
						
						
						System.out.println("removed--------- "+compress.remove(compress.size()-1));
						
						compress.add(compress.size()-1,ar.get(k));
									
						
					}
					else{
						compress.add(ar.get(k));
						
						System.out.println("added-----------");
					}			
					
				}
				else if(((String)ar.get(k)).length()<((String)compress.get(compress.size()-1)).length())
				{
					System.out.println("inside less-------------");
					
					if(((String)compress.get(compress.size()-1)).lastIndexOf((String)ar.get(k))>=0)
					{
						//(String)compress.get(i)
						//((String)ar.get(k))
						System.out.println(compress.remove(compress.size()-1));
						compress.add(compress.size()-1,ar.get(k));
					}
					else{
						compress.add(ar.get(k));
					}		
					
				}
					
				
			}
			
			System.out.println("compresed"+compress);
			
			Collections.sort(compress);
			
			
			
			System.out.println("After sorting compresed---------------->>> "+compress);
			
			FileOutputStream fo=new FileOutputStream("D:\\compress.txt",true);
			 PrintStream ps=new PrintStream(fo);
			
			for(int i=0;i<compress.size();i++)
			{
				
				ps.println((String)compress.get(i)); 
				
				
			}
			System.out.println("--------------------------------------- "); 
		}
		catch(Exception e)
		{
			System.out.println(e); 
			
		}
		return compress;
		
		
	}
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		try
		{

		System.out.println("before");
		StringSearch sc=new StringSearch();
		ArrayList ar=sc.getDataFromFile("");
		
		
		System.out.println("arraylist size is"+ar.size());
		
		  ArrayList compress=new ArrayList();
		  compress.add(ar.get(0));
		for(int i=0;i<ar.size()-1;i++)
		{
			
			System.out.println("now compress"+compress);
			
			int j=i;
			
			
			int k=++j;
			
			
			if(((String)ar.get(k)).length()==((String)compress.get(compress.size()-1)).length())
			{
			
				System.out.println("inside equal");
				
				if(((String)ar.get(k)).lastIndexOf((String)compress.get(compress.size()-1))>=0)
				{
					System.out.println(compress.remove(compress.size()-1));
					compress.add(compress.size()-1,ar.get(k));
				}
				else{
					compress.add(ar.get(k));
					System.out.println("now"+compress);
				}		
				
			}
			
			else if(((String)ar.get(k)).length()>((String)compress.get(compress.size()-1)).length())
			{
				System.out.println("inside greater");
				if(((String)ar.get(k)).lastIndexOf((String)compress.get(compress.size()-1))>=0)
				{
					
					
					System.out.println("removed"+compress.remove(compress.size()-1));
					
					compress.add(compress.size()-1,ar.get(k));
								
					
				}
				else{
					compress.add(ar.get(k));
					
					System.out.println("added");
				}			
				
			}
			else if(((String)ar.get(k)).length()<((String)compress.get(compress.size()-1)).length())
			{
				System.out.println("inside less");
				
				if(((String)compress.get(compress.size()-1)).lastIndexOf((String)ar.get(k))>=0)
				{
					//(String)compress.get(i)
					//((String)ar.get(k))
					System.out.println(compress.remove(compress.size()-1));
					compress.add(compress.size()-1,ar.get(k));
				}
				else{
					compress.add(ar.get(k));
				}		
				
			}
				
			
		}
		
		System.out.println("compresed-------------"+compress);
		
		Collections.sort(compress);
		
		
		
		System.out.println("A fter sorting compresed------------------>>"+compress);
		FileOutputStream fo=new FileOutputStream("D:\\compress.txt",true);
		 PrintStream ps=new PrintStream(fo);
		
		for(int i=0;i<compress.size();i++)
		{
			
			ps.println((String)compress.get(i));
			System.out.println("--------->>>---->>> "+compress.get(i)); 
			
		}
		
		
		
		
	/*	String string = "Madam, I am Adam"; 
		
		boolean b = string.startsWith("Mad"); // true // Ends with 
		//b = string.endsWith("dam"); // true // Anywhere 
		b = string.indexOf("I am") > 0; 
		System.out.println("iam"+b);
		
		
	/*	String p1="53 52";
		
		//System.out.println("p1 length"+p1.length());
		
		
		String p2="54 53 52";
		
		System.out.println("p2 length"+p2.length());
		String p3="54 52";
		
		boolean bb2=p2.indexOf(p3)>0;
				
		boolean bb=p2.indexOf(p1)>0;
		System.out.println(p2.indexOf(p1));
		System.out.println("result"+bb2);
			*/
		}
		catch(Exception e)
		{
			
		}
	}

}
