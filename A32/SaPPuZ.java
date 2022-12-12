import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SaPPuZ extends JFrame implements ActionListener {
	
	SaPPuZServer server=new SaPPuZServer();
	SaPPuZClient client=new SaPPuZClient();
	
	SaPPuZ(){
		
	 	JButton singlePlayer=new JButton("singlePlayer");
		JButton Client=new JButton("Client");
		JButton Server=new JButton("Server");

        JPanel panel = new JPanel();
        panel.add(singlePlayer);
        panel.add(Client);
        panel.add(Server);
        
        singlePlayer.setBounds(100, 100, 100, 100);
       
        singlePlayer.addActionListener(this);
        Client.addActionListener(this);
        Server.addActionListener(this);
        JFrame frame = new JFrame("SaPPuZ Game Launcher");
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	int width =  800;
		int height = 600;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;
		
		JPanel cards = new JPanel(new CardLayout());

		//set the location and the size of the window
		frame.setBounds(x,y,width,height);
		frame.setVisible(true);
       
         


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SaPPuZSplashScreen obj = new SaPPuZSplashScreen(5000);
//		
//		obj.showSplashWindow();
		
		
		
//		SaPPuZModel model=new SaPPuZModel();
//		SaPPuZView view=new SaPPuZView();
//		SaPPuZController controller=new SaPPuZController(model, view);
//		controller.initController();

//	System.out.print(testmodel.getList());
//		System.out.print(testmodel.getCol());
//		System.out.print(testmodel.getRow());
		SaPPuZ Launcher = new SaPPuZ();

	      
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "singlePlayer") {
			SaPPuZModel model=new SaPPuZModel();
			SaPPuZView view=new SaPPuZView();
			SaPPuZController controller=new SaPPuZController(model, view);
			controller.initController();
		}
		if(e.getActionCommand() == "Client") {
			this.dispose();
			client.startClientGUI();
		}
		if(e.getActionCommand() == "Server") {
			this.dispose();
			server.serverGUI();
				
		
		}
	}


	}
	


	


