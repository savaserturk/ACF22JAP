import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.*;
import javax.swing.*;


public class GameController extends JFrame{
	Container Container= getContentPane();
	

	
	 Color bgc=Color.LIGHT_GRAY;
	
	 int row=5;
	 int col=5;
	
	
	public GameController() {
		
		//Top Menu bar
		JMenuBar MenuBar = new JMenuBar();
	    JMenu menu = new JMenu("Main");
	    JMenu help = new JMenu("Help");
	    JMenu about = new JMenu("About");
	    MenuBar.add(menu);
	    MenuBar.add(help);
	    MenuBar.add(about);
	    
	    //Board panel (Center panel)
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(row, col));
		JButton[][] grid= new JButton[row][col];
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   
	   
	  
	    for (int i = 0; i < row; i++){ //row
	        for (int j = 0; j < col; j++){ //column
	            grid[i][j] = new JButton();
	            grid[i][j].setBorder(new LineBorder(Color.BLACK));
	            grid[i][j].setPreferredSize(new Dimension(80, 80));
	            grid[i][j].setText(i+" "+j);
	            if((i+j)%2==0) {
	            	 grid[i][j].setBackground(Color.red);
	            }
	            grid[i][j].setOpaque(true);
	            board.add(grid[i][j]);
	        }
	    }
	    
	    
	    //Right user Panel (EAST Panel)
	    JPanel rightPanel = new JPanel();
	    rightPanel.setBackground(bgc);
	    GroupLayout groupLayout = new GroupLayout(rightPanel);
	 
	    
	    rightPanel.setLayout(groupLayout);
	    groupLayout.setAutoCreateGaps(true);
	    groupLayout.setAutoCreateContainerGaps(true);
	    
   
	    String[] dimList={"3x3","4x4","5x5"};
	    JLabel timeLabel = new JLabel("Timelabel: ");
	    JLabel timer = new JLabel(" 00 : 00");
	    JRadioButton normalOption = new JRadioButton("Normal");
	    JRadioButton hardOption = new JRadioButton("Hard");
	    JLabel dim = new JLabel("DIM");
	    JComboBox dimSize = new JComboBox(dimList);
	    dimSize.setMaximumSize( dimSize.getPreferredSize() );
	    JButton startButton = new JButton("Start");
	    JButton resetButton = new JButton("Reset");
	    
	    
	    
	    
	    //Group Layout for right panel.
	    groupLayout
        .setHorizontalGroup(groupLayout
              .createSequentialGroup()
              .addGroup(
                    groupLayout
                          .createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                          .addComponent(timeLabel).addComponent(timer)
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
                    .addComponent(timer).addGap(100))
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
  
  
  
  
  //West Panel
  JPanel westPanel = new JPanel();
  JTextField text = new JTextField("Texting area...    ");
  JButton textSubmit = new JButton("Submit");
  westPanel.add(text, BorderLayout.WEST);
  westPanel.add(textSubmit, BorderLayout.EAST);


	    
	    

	      this.add(board,BorderLayout.CENTER);
	      this.add(MenuBar,BorderLayout.NORTH);
	      this.add(rightPanel,BorderLayout.EAST);
	      this.add(westPanel,BorderLayout.SOUTH);
	      this.setSize(1080, 720);
	      this.setTitle("Savas Erturk's NumPuz Game");
	      this.setResizable(false);
	      this.setVisible(true);
		
	      
	      
	
		
	}
	

	
	
}
