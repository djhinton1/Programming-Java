// Demonstrates JPanel, GridLayout and a few additional useful graphical features.
// adapted from an example by john ramirez (cs prof univ pgh)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class SimpleCalc{
	JFrame window;  
	Container content ;
	JButton[] digits = new JButton[12]; 
	JButton[] ops = new JButton[4];
	JTextField expression;
	JButton equals;
	JTextField result;
	
	
	public SimpleCalc(){
		window = new JFrame( "Simple Calc");
		content = window.getContentPane();
		content.setLayout(new GridLayout(2,1)); 
		ButtonListener listener = new ButtonListener();
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1,3)); 
		
		expression = new JTextField();
		expression.setFont(new Font("verdana", Font.BOLD, 16));
		expression.setText("");
		
		equals = new JButton("=");
		equals.setFont(new Font("verdana", Font.BOLD, 20 ));
		equals.addActionListener( listener ); 
		
		result = new JTextField();
		result.setFont(new Font("verdana", Font.BOLD, 16));
		result.setText("");
		
		topPanel.add(expression);
		topPanel.add(equals);
		topPanel.add(result);
						
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,2));
	
		JPanel  digitsPanel = new JPanel();
		digitsPanel.setLayout(new GridLayout(4,3));	
		
		for (int i=0 ; i<10 ; i++ ){
			digits[i] = new JButton( ""+i );
			digitsPanel.add( digits[i] );
			digits[i].addActionListener( listener ); 
		}
		digits[10] = new JButton( "C" );
		digitsPanel.add( digits[10] );
		digits[10].addActionListener( listener ); 

		digits[11] = new JButton( "CE" );
		digitsPanel.add( digits[11] );
		digits[11].addActionListener( listener ); 		
	
		JPanel opsPanel = new JPanel();
		opsPanel.setLayout(new GridLayout(4,1));
		String[] opCodes = { "+", "-", "*", "/" };
		for (int i=0 ; i<4 ; i++ ){
			ops[i] = new JButton( opCodes[i] );
			opsPanel.add( ops[i] );
			ops[i].addActionListener( listener ); 
		}
		bottomPanel.add( digitsPanel );
		bottomPanel.add( opsPanel );
		
		content.add( topPanel );
		content.add( bottomPanel );
	
		window.setSize( 640,480);
		window.setVisible( true );
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


//ACTION CLASS
//---------------------------------------------------------------------------
	class ButtonListener implements ActionListener{
		double x;
    	int index = -1;
    	int multIndex;
    	int divIndex; 
    	int addIndex; 
    	int minIndex;
    	
		public void actionPerformed(ActionEvent e){
			Component whichButton = (Component) e.getSource();
			result.setText("");
			
			//when a number button is pressed
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			for (int i=0 ; i<10 ; i++ ){
				if (whichButton == digits[i]){
					expression.setText( expression.getText() + i );
				}
			}
			
			//when "C" is pressed
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		
			if (whichButton == digits[10]){
				expression.setText("");
			}
			
			//when "CE" is pressed
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if (whichButton == digits[11]){
				String line = expression.getText();
				char [] array = line.toCharArray();
				String newString = "";
				for (int i = 0;i<line.length()-1;i++)
					 newString = newString + array[i]; 
				expression.setText(newString);
			}
			
			//when an operation is pressed
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			String[] opCodes = { "+", "-", "*", "/" };
			for (int i=0 ; i<4 ; i++ ){
				if (whichButton == ops[i]){
					expression.setText( expression.getText() + opCodes[i] );
				}
			}	
			
			//when the "=" button is pressed
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if(whichButton == equals){
				String expr = expression.getText();
				ArrayList<String> operatorList = new ArrayList<String>();
				ArrayList<String> operandList1 = new ArrayList<String>();
	
				StringTokenizer st = new StringTokenizer( expr,"+-*/", true );
				while (st.hasMoreTokens()){
					String token = st.nextToken();
					if ("+-/*".contains(token))
						operatorList.add(token);
					else
						operandList1.add(token);
    			}
    			
    			//MAKES AN ARRAYLIST OF DOUBLES INSTEAD OF STRINGS
    			ArrayList<Double> operandList = new ArrayList<Double>();
    			for (int i = 0; i < operandList1.size(); i++){
    				operandList.add(Double.parseDouble(operandList1.get(i)));
    			}
    			
    			//ORDER OF OPERATIONS
    			while(operatorList.size() > 0){
    				multIndex = operatorList.indexOf("*");
    				divIndex = operatorList.indexOf("/");
    				addIndex = operatorList.indexOf("+");
    				minIndex = operatorList.indexOf("-");
    				if(divIndex == -1 && multIndex == -1){
    					if(addIndex == -1){
    						index = minIndex;
    						operandList.set(index,subtract(operandList, index));
    					}
    					else if(minIndex == -1){
    						index = addIndex;
    						operandList.set(index,add(operandList, index));
    					}
    					else if(addIndex > minIndex){
    						index = minIndex;
    						operandList.set(index,subtract(operandList, index));	
    					}
    					else{
    						index = addIndex;
    						operandList.set(index,add(operandList, index));	
    					}	
    				}
    				else if(divIndex ==  -1 && multIndex != -1){
    					index = multIndex;
    					operandList.set(index,multiply(operandList, index));
    				}
    				else if(divIndex != -1 && multIndex ==-1){
    					index = divIndex;
    					operandList.set(index,divide(operandList, index));
    				}
    				else{
    					if(multIndex > divIndex){
    						index = divIndex;
    						operandList.set(index,divide(operandList, index));
    					}
    					else{
    						index = multIndex;
    						operandList.set(index,multiply(operandList, index));
    					}	
    				}	
    				operatorList.remove(index);
    				operandList.remove(index+1);
    			}//END WHILE LOOP (ORDER OF OPERATIONS)
    			
 				result.setText("" + operandList.get(0));
 				
			}//END IF STATEMENT (WHEN = BUTTON IS PRESSED)
		}//END METHOD (actionPerformed)
	}//END PRIVATE CLASS (ButtonListener)

//CALCULATION METHODS
//----------------------------------------------------------------------
	public static double add(ArrayList<Double> operandList, int i){
		double num = operandList.get(i) + operandList.get(i+1);
		return num;	
	}
	public static double subtract(ArrayList<Double> operandList, int i){
		double num = operandList.get(i) - operandList.get(i+1);
		return num;	
	}
	public static double multiply(ArrayList<Double> operandList, int i){
		double num = operandList.get(i) * operandList.get(i+1);
		return num;
	}
	public static double divide(ArrayList<Double> operandList, int i){
		double num = operandList.get(i) / operandList.get(i+1);
		return num;
	}
	
//MAIN METHOD	
//---------------------------------------------------------------------
	public static void main(String [] args){
		new SimpleCalc();
	}//END MAIN METHOD
}//END PUBLIC CLASS
