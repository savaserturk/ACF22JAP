import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SaPPuZSplashScreen extends JWindow{
	Timer timer;
	int i=0;
	private static final long serialVersionUID = 9054548635007527755L;

	private final int duration;

	public SaPPuZSplashScreen(int duration) {
		this.duration = duration;
	}
	
	public void showSplashWindow() {
		//create content pane
		JPanel content = new JPanel(new BorderLayout());
		content.setBackground(Color.GRAY);

	
		int width =  800;
		int height = 600;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;
		//set the location and the size of the window
		setBounds(x,y,width,height);

		JLabel label = new JLabel(new ImageIcon(getClass().getResource("SaPPuZ.jpg"))); 

		JLabel demo = new JLabel("SaPPuZ is Loading...Get ready!", JLabel.CENTER);
		demo.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
		content.add(label, BorderLayout.CENTER);
		content.add(demo, BorderLayout.SOUTH);

		Color customColor = new Color(0,255,0);
		content.setBorder(BorderFactory.createLineBorder(customColor, 10));
		
	
		JProgressBar progressBar=new JProgressBar();
		
	        progressBar.setBorderPainted(true);
	        progressBar.setStringPainted(true);
	        progressBar.setBackground(Color.WHITE);
	        progressBar.setForeground(Color.BLACK);
	        
	        progressBar.setString("Please wait game assets are loading...");
	        progressBar.setMinimum(0);
	        progressBar.setMaximum(3015);
	        
	        
	        timer=new Timer(1,new ActionListener(){
	        	  public void actionPerformed(ActionEvent ae)
	        	  {
	        	   if(i==2990)
	        	   i=0;
	        	   progressBar.setValue(i++);
	        	  }
	        	  
	        	 });
	        
	        timer.start();
	        
	        content.add(progressBar,BorderLayout.NORTH);
	        

	
		setContentPane(content);

		setVisible(true);
	

		try {

			Thread.sleep(duration); }
		catch (InterruptedException e) {
			e.printStackTrace();
			}

		dispose(); 
		
	}
}
