import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class Mining extends JFrame implements ActionListener 
{
	JPanel head,bottom;
	JLabel data,support,cofidance,uid;
	JTextField field,sup,conf;
	JButton browse,mine,compress,freq;
	public Mining() throws HeadlessException 
	{
		super();
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		
	head=new JPanel();
	bottom=new JPanel();
		
	field=new JTextField(15);
	sup=new JTextField(5);
	conf=new JTextField(5);
	
	data=new JLabel("-----------------------------------------------------------------------DATA MINING---------------------------------------------------------------");
	support=new JLabel("Support");
	cofidance=new JLabel("Confidance");
	
	browse=new JButton("ok");
	
	
	mine=new JButton("Mine");
	compress=new JButton("Frequent Pattern");
	
	freq=new JButton("Frequent Patterns");
	
	head.setLayout(new GridLayout(2,2));
		
		head.add(data);
		
		bottom.setLayout(null);
		
		
		field.setBounds(200, 20, 190, 20);
		
		browse.setBounds(400, 20, 90, 20);
		
		support.setBounds(130, 70, 70, 20);
		
		conf.setBounds(380,70,90,20);
		
		cofidance.setBounds(300, 70, 90, 20);
		sup.setBounds(180, 70, 90, 20);
		
		compress=new JButton("Frequent Pattern");
		compress.setBounds(210, 270, 230, 20);
		freq.setBounds(240, 150, 150, 20);
		mine.setBounds(280, 100, 90, 20);
		bottom.add(field);
		bottom.add(browse);
		
		bottom.add(support);
		bottom.add(sup);
		bottom.add(cofidance);
		bottom.add(conf);
		bottom.add(mine);
		
		//bottom.add(freq);
		bottom.add(compress);
		
		compress.addActionListener(this);
		browse.addActionListener(this);
		mine.addActionListener(this);
		freq.addActionListener(this);
		
		
		this.add(BorderLayout.NORTH,head);
		this.add(BorderLayout.CENTER,bottom);
			
	}
	
	public static void main(String[] args) 
	{
		
		Mining mi=new Mining();
		mi.setVisible(true);
		mi.setSize(600, 400);
	
	}

	public void actionPerformed(ActionEvent e) 
	{
		
		ArrayList arr = new ArrayList();
		
		if(e.getSource()==compress)
		{
			try
			{
				UserProcess up = new UserProcess();
				StringSearch ss = new StringSearch();
				arr = ss.compress(); 
				Support sp = new Support(); 
				sp.writeData(arr);
				String uid = up.getuserId(field.getText().trim());
				sp.updatePredictions(uid);  
				Compress c=new Compress();
				c.setSize(400, 300);
				c.setVisible(true);
			}
			catch (Exception e1)
			{
				System.out.println(e1);
			}
			
		}
		
		if(e.getSource()==mine)
		{
			
			String support=sup.getText();
			String confidance=conf.getText(); 
			String file="userprofile.txt";
			
			String args[]={"-C"+confidance+"","-F"+file+"","-S"+support+""};
		
			FPgrowthApp fp=new FPgrowthApp();
			
			fp.process(args);
			
			System.out.close();
		    System.out.println("detatils"+args[0]+"file is "+args[1]+"support is"+args[2]);
			
			
				
			JOptionPane jo=new JOptionPane();
			
			jo.showMessageDialog(this, "Data Mining Successful");
			try 
			{
				Process p=Runtime.getRuntime().exec("notepad d:/out.txt");
						
				
			}
			catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==freq)
		{

			try
			{
			
			}
			catch(Exception ew)
			{
				
			}
		}
		if(e.getSource()==browse)
		{
			String uid = field.getText();
			DbaseToFile1.getUserID(uid);
				
		}	
	}
}
