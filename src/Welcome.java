import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;


public class Welcome extends JFrame implements ActionListener
{
	
	public	JButton continu=null;
	public JButton jb;
	JLabel welcome;
		
	public Welcome()
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
		// TODO Auto-generated constructor stub
		setLayout(null);
	
		welcome=new JLabel("Welcome To DataMining");
		//String link = "http://www.google.com";
//		JLabel label = new JLabel("<html><head></head><body><a href=\""+link+"\">"+link+"</a></body></html>");

	//	label.setBounds(200, 250, 200, 200);
		Font f=new Font("Verdana", Font.BOLD, 30);
		
		welcome.setFont(f);
		
		//welcome.setSize(500, 500);
		continu=new JButton("Continue");
		jb=new JButton("vinay");
		
		
		
		welcome.setBounds(10, -180, 600, 600);
	    continu.setBounds(180, 300, 120, 30);
	    jb.setBounds(180, 200, 120, 30);
	    
		this.add(BorderLayout.NORTH,welcome);
		this.add(BorderLayout.SOUTH,continu);
		//this.add(BorderLayout.WEST,jb);
		//this.add(label);
		continu.addActionListener(this);
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Welcome wel =new Welcome();
		
		wel.setVisible(true);
		wel.setSize(500, 500);	
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
    this.dispose();
	Mining min=new Mining();
	min.setSize(600, 400);
	min.setVisible(true);
	}
}
