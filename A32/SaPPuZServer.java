import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;






public class SaPPuZServer extends JFrame{
	
	/** Server Variables */
	ServerSocket serverSocket = null;
	Socket socket=null;

	boolean isServerRunning = false;
	int totalUsers = 0;
	int currentClients = 0;
	JTextArea  box;

	String data = "";
    DataInputStream input = null;
    DataOutputStream output = null;
    Socket threadSocket = null;

	void serverGUI(){
		
	JFrame frame = new JFrame();
	Server serverObj = new Server();
	JTextField  port= new JTextField("12345");
	box= new JTextArea();
	
	port.setBounds(0, 0,200,100);
	box.setBounds(0, 100,400,400);
	JButton start = new JButton("Start");
	start.setBounds(300, 0,100,100);
	box.append("Hello Welcome to SaPPuZ Server! \n Please enter the 4 digit port number then press start button. \n ");
	
	frame.add(port);
	frame.add(start);
	frame.add(box);
	frame.setSize(400,500);//400 width and 500 height  
	frame.setLayout(null);
	frame.setVisible(true);
	
	int width =  800;
	int height = 600;
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	int x = (screen.width-width);
	int y = (screen.height-height)/2;
	frame.setBounds(x,y,width,height);
	

	//start.addActionListener(e -> selectionButtonPressed());
	start.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(e.getActionCommand());
			if(e.getActionCommand() == "Start") {
				String btn1="Server started! \n"; 
				box.append(btn1);
				int portNumber=Integer.parseInt(port.getText());
				serverObj.serverStart(portNumber);
				
				
			}

		}

	       
	    });
	
	
	}
	
	class Server implements Runnable{
		

		ArrayList<ClientThread> clientList = new ArrayList<ClientThread>(5);
//
//		ArrayList<String> gameResults = new ArrayList<String>(5);
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			waitConnection();
		}


		
		void serverStart(int portNumber){
			
			try {
				serverSocket=new ServerSocket(12345);
				isServerRunning = true;
				System.out.println("Server started\n");
				Thread threadServer = new Thread(this);
				threadServer.start();
	            
	           
	            
	           

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}




		 void waitConnection() {
			// TODO Auto-generated method stub
			 while (isServerRunning==true) {

		            try{
		            
		            socket = serverSocket.accept();
		            System.out.println("Client accepted!");
//		            int test=1;
//		            String msg = "Geldin";
//		            output.writeUTF(msg);
//					outputStreamWriter.write("Hello from the other side!"+test);
//		            output.flush(); // send the message
//		            output.close(); // close the output stream when we're done.
		            
		            } 
		            catch (IOException ioe) 
		            {

		                System.out.println("IO Exception: " + ioe);
		            }
		            ClientThread threadSocket = new ClientThread(socket);
		            threadSocket.start();
		            clientList.add(threadSocket);
		            box.append("User ID:"+totalUsers+" Joined server. \n");

		        }
		}
		 
			class ClientThread extends Thread{

				
		    	String data = "";		    	
		        DataInputStream input = null;		       
		        DataOutputStream output = null;
		        Socket threadSocket = null;
		        
			    
		        public ClientThread(Socket socket) 
		        {	
		            this.threadSocket = socket;
		            totalUsers++;
		            currentClients++;
		            
		        	try 
		        	{
						input = new DataInputStream(socket.getInputStream());
						output = new DataOutputStream(socket.getOutputStream());
					} 
		        	catch (IOException e) 
		        	{
						e.printStackTrace();
					}
		        	System.out.println("Total users: "+totalUsers);
		        	

		        	
		        }
		    
		    }
		 
		 
		 

		}
	

	
		

	 

	
}
	