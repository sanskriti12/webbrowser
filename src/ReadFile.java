import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
public class ReadFile extends JFrame {
	private JTextField addressBar;
	private JEditorPane display;
//constructor
	public ReadFile()
	{
		super("My Browser");
		addressBar= new JTextField("enter a URL host");
		addressBar.addActionListener
		(
			new ActionListener()//whenever enter is pressed actionperformed method is called
			{
				public void actionPerformed(ActionEvent event)
				{
					loadCrap(event.getActionCommand());//load html file and then display on screen
					
				}
			}
	   );
		add(addressBar,BorderLayout.NORTH);
		display=new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
				new HyperlinkListener()
				{
					public void hyperlinkUpdate(HyperlinkEvent event)//this method is called when hyperlink is clicked
					{
						if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED)//diff types of events that can happen like click
						{
							loadCrap(event.getURL().toString());
						}
					}
				}
		);
		add(new JScrollPane(display),BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
	}
		
	private void loadCrap(String userText)
	{
		try{
			display.setPage(userText);
			addressBar.setText(userText);
			
		}
		catch(Exception e)
		{
			System.out.println("crap!");
		}
	}
		
}	