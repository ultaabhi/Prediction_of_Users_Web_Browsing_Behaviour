
/**
 * @author Soumya
 * May 10, 2012 12:07:36 PM
 * Project:-Web Mining User Profile
 * Package:-Default
 * File:-DbaseToFile1.java
 **/




public class DbaseToFile1 
{

    
   


public static void getUserID(String uid) 
{
	try
	{
		
		UserProcess dao=new UserProcess();
		int user_id = Integer.parseInt(uid);
		boolean flag =dao.createInputFile(user_id);
	}
	catch (Exception e)
	{
	 System.err.println("Error: " + e.getMessage());  
	}
	
	
}


}

