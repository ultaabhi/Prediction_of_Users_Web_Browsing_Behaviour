import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class Compress extends JFrame implements ActionListener
{
	JButton home,view;
	public Compress() throws HeadlessException 
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
		
		setLayout(null);
		home=new JButton("Home");
		view=new JButton("View FP Data");
		home.addActionListener(this);
		view.addActionListener(this);
		home.setBounds(100, 30, 90, 20);
		view.setBounds(100, 100, 190, 20);
		this.add(BorderLayout.NORTH,home);
		this.add(view);
	}

	public static void main(String[] args) 
	{
		Compress c=new Compress();
		c.setSize(400, 300);
		c.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==view)
		{
			try
			{
				Process p=Runtime.getRuntime().exec("notepad d:/compress.txt");
			}
			catch(Exception ew)
			{
					
			}
		}
		if(e.getSource()==home)
		{
			this.dispose();
			Welcome w=new Welcome();
			w.setSize(500, 500);
			w.setVisible(true);
		}
	}
}
