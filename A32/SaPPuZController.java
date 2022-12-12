import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.text.View;

import java.util.Timer;
import java.util.TimerTask;
public class SaPPuZController {
	
	
	
	/**
	 * View component
	 */
	private SaPPuZView view;

	/**
	 * Model component
	 */
	private SaPPuZModel model;
	
	private int seconds=0;
	Timer timer= new Timer();
	TimerTask timerTask;

	public SaPPuZController(SaPPuZModel model, SaPPuZView view) {
		this.model = model;
		this.view = view;
	}
	
	public void initController() {
		
		view.setVisible(true);
		model.generateList(3,3);
		view.createBoard(model.getRow(), model.getCol(), model.getList(),true);
		startTimer();
		model.solutionList();
		view.addListener(new MyActionListener());
	}
	public void movement(int selectedOne,int selectedTwo) {
		int oneIndex=model.getList().indexOf(selectedOne);
		int twoIndex=model.getList().indexOf(selectedTwo);
		 Collections.swap(model.getList(),oneIndex, twoIndex);
	}
	public void startTimer() {
		timerTask = new TimerTask() {
			public void run() {
				seconds++;
				view.timeCounter.setText(""+seconds+"");
			}
		};
		try {
			timer.scheduleAtFixedRate(timerTask, 0, 1000);
		}catch(Exception e){
			
		}
	}
	
	public void refresh() {
		int o=0;
		for (int i = 0; i < model.getRow(); i++){ //row
		for (int j = 0; j < model.getCol(); j++){ //column
			
			if(model.getList().get(o) == 0) {
				view.gridButton[i][j].setEnabled(false);
				view.gridButton[i][j].setText("");
			}else {
				view.gridButton[i][j].setText(""+model.getList().get(o)+"");
			}
			o++;
			}
		}
		
	}

	
	

	

	class MyActionListener  implements ActionListener{
		int numberOne,numberTwo;

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int t = 0; t < model.getRow(); t++){ //row
			for (int k = 0; k < model.getCol(); k++){ //column	
		   if (e.getSource() == view.gridButton[t][k]) {// This is where problem arises
   
		
		if(model.getSelectedOne() == 0) {
			
			for (int i = 0; i < model.getRow(); i++){ //row
				for (int j = 0; j < model.getCol(); j++){ //column	
					if(e.getSource()==view.gridButton[i][j]) {
					view.gridButton[i][j].setBackground(Color.red);
					}
				}}
		 numberOne = Integer.parseInt(e.getActionCommand());
		e.getActionCommand();
		model.setSelectedOne(numberOne);
		System.out.println(numberOne);
		}else {
			numberTwo = Integer.parseInt(e.getActionCommand());
			e.getActionCommand();
			model.setSelectedTwo(numberTwo);
			System.out.println("number one:" + model.getSelectedOne()+" number two "+model.getSelectedTwo());
			int indexOfOne = model.getList().indexOf(model.getSelectedOne());
			int indexOfTwo = model.getList().indexOf(numberTwo);
			System.out.println("selected item index number move from; "+indexOfOne+" to; "+indexOfTwo);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			
			Collections.swap(model.getList(),indexOfOne,indexOfTwo);
			for (int i = 0; i < model.getRow(); i++){ //row
				for (int j = 0; j < model.getCol(); j++){ //column	
					
					view.gridButton[i][j].setBackground(Color.white);
					
				}}

			System.out.println(model.getList());
			model.setSelectedOne(0);
			model.setSelectedTwo(0);
			refresh();

		
		}
		
		

		}
			}}
		
		if (e.getSource() == view.resetButton) {
			view.deleteBoard(model.getRow(), model.getCol());
			model.deleteList();
			refresh();
		}
        
		if (e.getSource() == view.dimSize) {
			System.out.println(view.dimSize.getSelectedIndex());
			if(view.dimSize.getSelectedIndex()==0) {
				view.deleteBoard(model.getRow(), model.getCol());
				model.deleteList();
				model.setCol(3);
				model.setRow(3);
				
				model.generateList(3,3);
				view.createBoard(3, 3, model.getList(),true);
				view.setVisible(true);
				refresh();
			}
		}else if(view.dimSize.getSelectedIndex()==1) {
			view.deleteBoard(model.getRow(), model.getCol());
			model.deleteList();
			model.setCol(4);
			model.setRow(4);
			
			model.generateList(4,4);
			view.createBoard(4, 4, model.getList(),true);
			view.setVisible(true);
			refresh();
			
			
			

		}
		
		if (e.getSource() == view.checkServerConnection) {
			 String result = JOptionPane.showInputDialog(view,"Please Enter the port number:");
			 
		          
}
		

    }  
		

		
	
	}
	
	
	
}
	




