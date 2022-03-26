package SerpentsAndSpires;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class Serpent extends JFrame{
	
	public Serpent() {
		
		initUI();
	
	}
	
	private void initUI() {
		
		add(new Board());
		
		setResizable(false);
		pack();
		
		setTitle("Serpent And Spires");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

	       EventQueue.invokeLater(() -> {
	            JFrame ex = new Serpent();
	            ex.setVisible(true);
	        });
	}

}
