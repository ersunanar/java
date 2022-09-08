package homework2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable {

	int posX = 50;
	int posY = 50;
	int deltaX = 1;
	int deltaY = 1;
	int x1;
	int y1;
	int x2;
	int y2;
	Object lock = new Object();
	
	boolean isPaused = false;
	
	public Panel() {
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				repaint();
				
				isPaused = false;
				
				synchronized (lock){
					
					lock.notify();				

			}
				
				posX = e.getX()-25;
				posY = e.getY()-25;
				x2 = e.getX();
				y2 = e.getY();
				
				if (x2 > x1) {
					deltaX = 1;						
					
				} else if (x2 < x1) {
					deltaX = -1;						
					
				}
				
				
				if (y2 > y1) {
					
					deltaY = 1;						
					
				} else if (y2 < y1) {
					deltaY = -1;						
					
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				isPaused = true;
				repaint();
				
				posX = e.getX()-25;
				posY = e.getY()-25;
				x1 = e.getX();
				y1 = e.getY();
				
			}
			
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				
				isPaused = false;

				repaint();
				posX = e.getX()-25;
				posY = e.getY()-25;
				
				x2 = e.getX();
				y2 = e.getY();
				
				if (x2 > x1) {
					deltaX = 1;						
					
				} else if (x2 < x1) {
					deltaX = -1;						
					
				}
				
				if (y2 > y1) {
					
					deltaY = 1;						
					
				} else if (y2 < y1) {
					deltaY = -1;						
					
				}
				
			}
		});
	}
	
	@Override
	public void run() {
		
		while (true) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (posX + 50 >= getWidth()) {
				
				deltaX = -1;
			} 
			
			if (posX <= 0) {
				
				deltaX = 1;
			}
			
			if (posY + 50 >= getHeight()) {
				deltaY = -1;
			} 
			
			if (posY <= 0) {
				deltaY = 1;
			}
			
			posX +=deltaX;						
			posY +=deltaY;
			
			synchronized (lock) {
				
				if (isPaused==true) {
					
					try {
						lock.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					

				}
				
			}
			
			repaint();
			
		}
		
	}	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D pen = (Graphics2D)g;		
	
		pen.setColor(Color.red);
		pen.fillArc(posX, posY, 50, 50, 0, 360);
		
	}

}
