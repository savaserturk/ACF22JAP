import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;



public class SaPPuZView extends JFrame{
	
	/**
	 * Serial ID
	 */
	

	
	Timer t;
	private static final long serialVersionUID = 1L;
	
	
	
	
	//general settings
	private int row;
	private int col;
	private boolean gameMode;
	JButton[][] gridButton;
	
	

	
	
	//Top bar
	JMenuBar MenuBar = new JMenuBar();
    JMenu menu = new JMenu("Main");
    JMenu help = new JMenu("Help");
    JMenu about = new JMenu("About");
    JPanel board = new JPanel();
    
    //Left Panel
  //Board panel (Center panel)
	//JButton[][] grid= new JButton[row][col];
   
	//Right Panel
	private JPanel rightPanel = new JPanel();
	private String[] dimList={"3x3","4x4","5x5"};
	private JLabel timeLabel = new JLabel("Timelabel: ");
	
	JLabel timeCounter = new JLabel(" 00 : 00");
//	t=new Timer(1000);
//	timer.
	
	
	 JRadioButton normalOption = new JRadioButton("Normal");
	 JRadioButton hardOption = new JRadioButton("Hard");
	 JLabel dim = new JLabel("DIM");
	 JComboBox dimSize = new JComboBox(dimList);
	
	 JButton startButton = new JButton("Start");
	 JButton resetButton = new JButton("Reset");
	
	//West Panel
	  JPanel southPanel = new JPanel();
	  JTextField text = new JTextField("Texting area...    ");
	  JButton textSubmit = new JButton("Submit");
	
	
	
	SaPPuZView( ) {
	

		
		board.setLayout(new GridLayout());
		JButton[][] gridButton;
		

		
			//Top menu 
			MenuBar.add(menu);
		    MenuBar.add(help);
		    MenuBar.add(about);
		    
		    //rightpanel
		    rightPanel.setBackground(Color.LIGHT_GRAY);
		    GroupLayout groupLayout = new GroupLayout(rightPanel);
		 
		    
		    rightPanel.setLayout(groupLayout);
		    groupLayout.setAutoCreateGaps(true);
		    groupLayout.setAutoCreateContainerGaps(true);
		    
		  //Group Layout for right panel.
		    groupLayout
	        .setHorizontalGroup(groupLayout
	              .createSequentialGroup()
	              .addGroup(
	                    groupLayout
	                          .createParallelGroup(
	                                GroupLayout.Alignment.LEADING)
	                          .addComponent(timeLabel).addComponent(timeCounter)
	                          .addComponent(normalOption).addComponent(hardOption)
	                          .addComponent(dim).addComponent(dimSize)
	                          .addComponent(startButton)
	                          .addComponent(resetButton))
	              
	              );

	  groupLayout.setVerticalGroup(groupLayout
	        .createSequentialGroup()
	        .addGroup(
	              groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	                    .addComponent(timeLabel).addGap(10))
	        .addGroup(
	              groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	                    .addComponent(timeCounter).addGap(100))
	        .addGroup(
	              groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	                    .addComponent(normalOption).addGap(50))
	        .addGroup(
	              groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	                    .addComponent(hardOption).addGap(50))
	        .addGroup(
	              groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	                    .addComponent(dim).addGap(50))
	        .addGroup(
	              groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	                    .addComponent(dimSize).addGap(50))
	        .addGroup(
	              groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	                    .addComponent(startButton).addGap(50))
	        .addGroup(
	              groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	                    .addComponent(resetButton).addGap(50)
	                    ));
	  
	  
	  		//southpanel
	  
	  		  southPanel.add(text, BorderLayout.WEST);
	  		  southPanel.add(textSubmit, BorderLayout.EAST);

	  		  
		    
		    

		      this.add(board,BorderLayout.CENTER);
		      this.add(MenuBar,BorderLayout.NORTH);
		      this.add(rightPanel,BorderLayout.EAST);
		      this.add(southPanel,BorderLayout.SOUTH);
		      this.setSize(1080, 720);
		      this.setTitle("Savas Erturk's NumPuz Game");
		      this.setResizable(false);
		      this.setVisible(true);
			
		   
		      //align center
		      
		      	int width =  800;
				int height = 600;
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
				int x = (screen.width-width)/2;
				int y = (screen.height-height)/2;
				//set the location and the size of the window
				setBounds(x,y,width,height);

				
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
	
		}
	
	 boolean jButton1clicked = false;
	 void createBoard(int row, int col,  ArrayList<Integer> list, boolean gameMode){

		 if(gameMode==true) {
			
			//Board panel (Center panel)
			board.setLayout(new GridLayout(row, col));
			gridButton= new JButton[row][col];
			int o=0;
			int gridSize=row*col;
			for (int i = 0; i < row; i++){ //row
				for (int j = 0; j < col; j++){ //column	
					gridButton[i][j] = new JButton("Button [" + i + "][" + j + "]");
					board.add(gridButton[i][j]);
				
					
					if(list.get(o) ==0) {
						gridButton[i][j].setEnabled(false);
						gridButton[i][j].setText("");
					}else {
						gridButton[i][j].setText(""+list.get(o)+"");
					}
					gridButton[i][j].setBackground(Color.white);
					gridButton[i][j].setOpaque(true);  
						o++;  
				
	    }
				
	}
			
		
	}else {
		
	}
		 
		 
}
	 
	 void deleteBoard(int row, int col) {
		 for (int i = 0; i < row; i++){ //row
				for (int j = 0; j < col; j++){ //column	
					board.remove(gridButton[i][j]);	
					board.revalidate();
					board.repaint();
				}
			}
		 
		 
	 }
	

	 void addListener(ActionListener e) {
		// System.out.println(gridButton[1][1]);
			for (int i = 0; i < 3; i++){ //row
			for (int j = 0; j < 3; j++){ //column	
			gridButton[i][j].addActionListener(e);
	
			}
		}
			dimSize.addActionListener(e);
			resetButton.addActionListener(e);
	}


		
}


