import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class SaPPuZModel {
	
	private int row=0;
	private int col=0;
	private int selectedOne=0;
	private int selectedTwo=0;
	
	




	Random rd = new Random(); // creating Random numbers
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private ArrayList<Integer> solutionListArray = new ArrayList<Integer>();
	

	
	public ArrayList<Integer> getSolutionList() {
		return solutionListArray;
	}

	public void setSolutionList(ArrayList<Integer> solutionList) {
		this.solutionListArray = solutionList;
	}

	SaPPuZModel(){
		this.row=3;
		this.col=3;
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> solutionListArray = new ArrayList<Integer>();
		
	}

	void generateList(int row,int col) {
		int genNumber=(row*col);
		
	      for (int i = 1; i < genNumber; i++) {
	    	  list.add(i); 
	      }  
	      Collections.shuffle(list);
	      list.add(list.size(), 0);

		}
	
	void solutionList() {
	solutionListArray=list;
		solutionListArray.subList(0, list.size()-1);
		Collections.sort(solutionListArray.subList(0, 8));
		
	
		//System.out.println("inside model"+solutionList.subList(0, list.size()-1)+"new try"+solutionList);
		System.out.println("Solution generated: "+solutionListArray);
	}
	
	void deleteList() {
		list.removeAll(list);
	}
	

	
	
		

	public int getSelectedOne() {
		return selectedOne;
	}

	public void setSelectedOne(int selectedOne) {
		this.selectedOne = selectedOne;
	}
	
	public int getSelectedTwo() {
		return selectedTwo;
	}

	public void setSelectedTwo(int selectedTwo) {
		this.selectedTwo = selectedTwo;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public ArrayList<Integer> getList() {
		return list;
	}



	
	public void setList(ArrayList<Integer> list) {
		this.list = new ArrayList<>(list);
	}
	
	

	
	
 
}