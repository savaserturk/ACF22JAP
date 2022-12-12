import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;



public class SaPPuZClient extends JFrame {
	Client c=new Client();
	Socket clientSocket = null;
	DataOutputStream output = null;
	DataInputStream input = null;
	Boolean isConnected=false;
	int clientId = -1;
	JButton connect = new JButton("Connect");
	JButton newGame = new JButton("New Game");
	JButton sendGame = new JButton("Send Game");
	JButton receiveGame = new JButton("Receive Game");
	JButton play = new JButton("Play");
	JTextArea console = new JTextArea();

	ArrayList<Integer> list = new ArrayList<Integer>(); 
    void newGame() {
    	generateList(3,3);
    }
    
	void generateList(int row,int col) {
		int genNumber=(row*col);
		list.removeAll(list);
	      for (int i = 1; i < genNumber; i++) {
	    	  list.add(i); 
	      }  
	      Collections.shuffle(list);
	      list.add(list.size(), 0);

		}
	
	
	void startClientGUI() {
		
		JLabel username = new JLabel("Username:");
		 JTextField usernameT = new JTextField("Savas");
		 usernameT.setPreferredSize(new Dimension(80, 25));
		JLabel server = new JLabel("Host:");
		 JTextField servert = new JTextField("localhost");
		 servert.setPreferredSize(new Dimension(80, 25));
		JLabel port = new JLabel("Port (4 digit):");
		 JTextField portt = new JTextField("12345");
		 portt.setPreferredSize(new Dimension(80, 25));
		connect = new JButton("Connect");
		JButton end = new JButton("End");
        
		newGame = new JButton("NewGame");
		sendGame = new JButton("SendGame");
		receiveGame = new JButton("ReceiveGame");
		sendGame = new JButton("SendData");
		play = new JButton("Play");
		console = new JTextArea();
		console.append("Welcome to SaPPuZ Client. \n  Please enter the hostname and port number! \n");
		console.setPreferredSize(new Dimension(300,450));

        
        this.setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel midPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
       
        topPanel.add(username);
        topPanel.add(usernameT);
        topPanel.add(server);
        topPanel.add(servert);
        topPanel.add(port);
        topPanel.add(portt);
        topPanel.add(connect);
        topPanel.add(end);
        
        
        midPanel.add(newGame);
        midPanel.add(sendGame);
        midPanel.add(receiveGame);
        midPanel.add(sendGame);
        midPanel.add(play);
 
        
        botPanel.add(console);
        
      this.add(topPanel, BorderLayout.NORTH);
      this.add(midPanel, BorderLayout.CENTER);
      this.add(botPanel, BorderLayout.SOUTH);
      
      
      this.setSize(700,500);
        int width =  800;
		int height = 600;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;
		setBounds(x,y,width,height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        
        newGame.addActionListener(new ActionListener() {
        	String text="";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "NewGame") {
					newGame();
					text="";
					text+=list;
					System.out.println(text);
					console.append("Array list generated: "+text+"\n");
					try {
						output.writeUTF(text);
						output.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						console.append("error");
					}
				}
				
			}
        	
        });
        
        connect.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(e.getActionCommand());
			if(e.getActionCommand() == "Connect") {
				int portNumber = Integer.parseInt(portt.getText());
				String hostname=servert.getText();
				if (!isConnected)
				c.connectServer(hostname,portNumber);
			}
			


		}

	       
	    });
        

    }
	
	class Client{
		
		void connectServer(String hostname, int portNumber) {
			try {
			clientSocket = new Socket(hostname,portNumber);
			output = new DataOutputStream(clientSocket.getOutputStream());
			input = new DataInputStream(clientSocket.getInputStream());
		
			
			
			isConnected = true;
			if(isConnected==true) {
				connect.setEnabled(false);
			}
			 console.append("Connected. Server status: \n"+ isConnected+"\n");
			 
//			String receivedResponse = input.readUTF();
//			System.out.println(receivedResponse);
//			String a= input.readUTF();
			
//			int test = input.readInt();


//		    PrintStream p=new PrintStream(clientSocket.getOutputStream());  
//		    p.println();  
			//console.insert("Connected to server\nID = " + clientId +"\n", console.getDocument().getLength());
			
		
			}catch (UnknownHostException uhe) 
			{
				 console.append("Unknown Host Exception: " + uhe+"\n");
	        } 
			catch (IOException e) 
			{
				 console.append("Server does not respond. Please create a server. \n"+e);
	        }
			
		}
	
}
	
}


