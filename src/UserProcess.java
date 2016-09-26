/**
 * @author Soumya
 *May 10, 2012 12:07:36 PM
 *Project:-Web Mining User Profile
 *Package:-Default
 *File:-UserProcess.java
 */

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.*;




public class UserProcess
{
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;
	static UserProcess userProcess=null;
	 UserProcess()
	{
		
	}
	public static UserProcess getInstance()
	{
		if(userProcess == null)
		{
			userProcess= new UserProcess();
		}
		return userProcess;
	}

	public boolean createInputFile(int xuserid)
	{
		int i=0; 
		String[] rowVal=null;
		boolean flag = false;
		try
		{
			FileWriter fstream = new FileWriter("userprofile.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_track where m_userid='"+xuserid+"'");
			while(resultSet.next())
			{
			i++;
			}
            
			rowVal=new String[i];
            i=0;
            resultSet = statement.executeQuery("select m_urlid from m_track where m_userid='"+xuserid+"'");
            while(resultSet.next())
			{
               rowVal[i]=resultSet.getString(1);
               i++;
			}
                      
            System.out.println("Length of rowVal "+rowVal.length);
                      
             for(int j=0; j < rowVal.length;j++)
             {
                 rowVal[j]=rowVal[j].replace("-"," ");
                 
                 out.write(rowVal[j].toString().substring(1, rowVal[j].length()));
                 out.write("\n");
                 System.out.println("Test -->"+ rowVal[j]);
              }
              out.close();
              flag = true;
		}
		catch(Exception e)
		{
			System.out.println("Error: "+ e);
		}
		return flag;
	}
	
	
	
	public String getuserId(String uid) throws SQLException 
	{
		String userid="";
		DAO dao = DAO.getInstance();
		connection = dao.connector();
		statement = connection.createStatement();
		String query = "select m_user from m_user where m_id = '"+uid+"'";
		resultSet = statement.executeQuery(query);
		while(resultSet.next())
		{
			userid = resultSet.getString("m_user");
		}
		
		return userid;
	}

	public boolean checkIDExistence(String id) throws SQLException  
	{
		boolean flag = false;
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		String query = "select * from prediction where m_id = '"+id+"'";
		resultSet= statement.executeQuery(query);
		while(resultSet.next())
		{
			flag = true;
		}
		
		
		return flag;
		
	}
	public void insertPrediction(String pred , String id) throws SQLException  
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		statement.execute("insert into prediction (m_id,m_predictions) values ('"+id+"','"+pred+"')"); 
		
	}
	public void updateUserPredictions(String finalpredictions,String id) throws SQLException 
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		String query="update prediction set m_predictions='"+finalpredictions.trim()+"' where m_id = '"+id+"'";
		statement.executeUpdate(query); 
		
	}

	
}
