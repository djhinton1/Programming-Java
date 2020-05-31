import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Etch_A_Sketch implements MouseListener, MouseMotionListener,ActionListener  // NOTE multiple interfaces
{
	JFrame window;
	Container content;
	int mouseX,mouseY,oldX,oldY;
	JLabel coords;
	JButton colorChanger;
	Color theColor;
	String[] funny = {"ahhh","oooh","ahhhhh","oooooh"};
	int index = 0;
	
	
	Color[] myColors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};

	public Etch_A_Sketch()
	{
		JFrame window = new JFrame("Classic Etch a Sketch");
		content = window.getContentPane();
		content.setLayout( new FlowLayout() );
		
		colorChanger = new JButton("Change Color");
		content.add(colorChanger);
		
		content.addMouseListener(this);        // "this" is the class that implements that listener
		content.addMouseMotionListener(this);  // "this" is the class that implements that listener
		theColor = Color.BLACK;
		colorChanger.addActionListener(this);
		window.setSize(640,480);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// ..............................................................
	// IMPLEMENTING MOUSELISTENER REQUIRES YOU TO WRITE (OVER-RIDE) THESE METHODS 

	//when you press & release with NO MOVEMENT while pressed
	public void mouseClicked( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
	
		
	}
	
	// when you press 
	public void mousePressed( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		
		//repaint();
	}

	//when you let release after dragging
	public void mouseReleased( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
	
		//repaint();
	}

	// the mouse just moved off of the JFrame
	public void mouseExited( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
	
		//repaint();
	}
	
	// the mouse just moved onto the JFrame
	public void mouseEntered( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		
		//repaint();
	}
	// ...............................................................
	// IMPLEMENTING MOUSEMOTIONLISTENER REQUIRES YOU WRITE (OVER-RIDE) THESE METHODS 

	// mouse is moving while pressed
	public void mouseDragged( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

		if (oldX ==0 )
		{
			oldX=mouseX;
			oldY=mouseY;
			return;
		}
		
		// draw  dot (actually small line segment) between old (x,y) and current (x,y)
		
		Graphics g = content.getGraphics(); // use g to draw onto the pane
		g.setColor(theColor);
		g.drawLine( oldX,oldY, mouseX, mouseY );
		oldX = mouseX;
		oldY = mouseY;
		
		//repaint();
	}
	
	// moved mouse but not pressed
	public void mouseMoved( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
	
		//repaint();
	}
	
	public void actionPerformed( ActionEvent e){
		
		Component theClickedButton = (Component) e.getSource();
		if(theClickedButton == colorChanger){
			index = (index + 1) % myColors.length;
			colorChanger.setText(funny[index]);
			theColor = myColors[index];
		}
	
	}

	// ..............................................................

	public static void main( String[] args)
	{
		new Etch_A_Sketch();
		
	}
	
}//EOF