package homework2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;







public class ErsunAnarHomeWork2 extends JFrame{

	private JPanel contentPane;
	
	
	Panel panel = new Panel();
	Thread thread = new Thread(panel);
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErsunAnarHomeWork2 frame = new ErsunAnarHomeWork2();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		


		
		
	}

	/**
	 * Create the frame.
	 */
	public ErsunAnarHomeWork2() {
		
		
		initGUI();
		thread.start();
		

	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		
	
	}
	

		 
		 
		 
		
		 
			//cnt1.setDaemon(true);
			
		
		

	
	

	



	

}
