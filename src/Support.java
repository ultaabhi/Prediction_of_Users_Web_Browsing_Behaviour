import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Support {
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;

	public void writeData(ArrayList arr) {
		FileOutputStream fo;
		StringBuffer sb = new StringBuffer();
		try {
			UserProcess up = new UserProcess();

			fo = new FileOutputStream("finaldata.txt");
			PrintStream ps = new PrintStream(fo);
			for (int i = 0; i < arr.size(); i++) {
				ps.println((String) arr.get(i));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updatePredictions(String id) throws IOException {
		FileReader fr = new FileReader("finaldata.txt");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("outfile.txt");
		String line;

		while ((line = br.readLine()) != null) {
			line = line.trim(); // remove leading and trailing whitespace
			if (!line.equals(" ")) // don't write out blank lines
			{
				fw.write(line, 0, line.length());

			}
		}
		fr.close();
		fw.close();
		updateBackEnd(id);

	}

	private void updateBackEnd(String uid) {

		int m=0;
		File file = new File("outfile.txt");

		try {
			// UserProcess up = new UserProcess();
			StringBuffer sb = new StringBuffer();

			FileInputStream fis = new FileInputStream(file);

			char current;

			String fp = "";
			String finalfp = "";
			while (fis.available() > 0)
			{
				current = (char) fis.read();
				String str = Character.toString(current);

				int len = str.length();
				
				for (int l = 0; l < len; l++)
				{
					if (m == 0) 
					{
						fp = str;
						DAO dao = DAO.getInstance();
						connection = dao.connector();
						try
						{
							statement = connection.createStatement();
							statement.execute("insert into m_fp(fp_user_id,fp_val) values('"+ uid + "','" + fp + "')");
						}
						catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} 
					else
						finalfp += fp;
				}

				/*
				 * System.out.println("Length"+len);
				 * 
				 * finalfp+=fp;
				 * 
				 * System.out.println("FP Value:"+fp);
				 * System.out.println("Final FP Value:"+finalfp);
				 */

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// File file = new File("outfile.txt");
		/*
		 * if (!file.exists()) { System.out.println( "file does not exist.");
		 * return; } if (!(file.isFile() && file.canRead())) {
		 * System.out.println(file.getName() + " cannot be read from."); return;
		 * } try { UserProcess up = new UserProcess(); StringBuffer sb = new
		 * StringBuffer(); FileInputStream fis = new FileInputStream(file); char
		 * current; String predictions=""; String finalpredictions=""; while
		 * (fis.available() > 0) { current = (char) fis.read(); String
		 * str=Character.toString(current);
		 * 
		 * if(!(str.equals(" "))) {
		 * 
		 * predictions=str+"-"; finalpredictions+=predictions;
		 * 
		 * 
		 * if(up.checkIDExistence(uid)) {
		 * up.updateUserPredictions(finalpredictions,uid); } else {
		 * up.insertPrediction(finalpredictions,uid); }
		 * 
		 * } }
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } catch (SQLException
		 * e) {
		 * 
		 * e.printStackTrace(); }
		 */

	}

}
