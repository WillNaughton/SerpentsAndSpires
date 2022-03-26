package SerpentsAndSpires;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener{

    public final static int B_WIDTH = 1000;
    public final static int B_HEIGHT = 700;
    
    public static int room_y;
    public static int room_x;
    
	 private Timer timer;
	 private Spire player;
	 private Spire wall;
	 private final int DELAY = 10;

	    public Board() {

	        initBoard();
	        roomRandom();

	        checkCollisions();
	    }

	    private void initBoard() {

	        addKeyListener(new TAdapter());
	        setBackground(Color.black);
	        setFocusable(true);
		
	        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

	        player = new Spire();
	        wall = new Spire();

	        timer = new Timer(DELAY, this);
	        timer.start();
	    }

	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        doDrawing(g);
	        
	        Toolkit.getDefaultToolkit().sync();
	    }
	    
	    private void doDrawing(Graphics g) {
	        
	        Graphics2D g2d = (Graphics2D) g;
	        Graphics2D g3d = (Graphics2D) g;

	        g2d.drawImage(player.getPlayerImage(), player.getX(), 
	            player.getY(), this);
	        
	        for(int w = 0; w < room_x + 1; w++) {
	        	
	        	g3d.drawImage(wall.getWallImage(), 20 * w, 0, this);
	        	g3d.drawImage(wall.getWallImage(), 20 * w, room_y * 20, this);
	        
	        }
	        for(int h = 0; h < room_y; h++) {
	        	
	        	g3d.drawImage(wall.getWallImage(), room_x * 20, 20 * h, this);
	        	g3d.drawImage(wall.getWallImage(), 0, 20 * h, this);
	        }
	    }
	    private void roomRandom() {
	    	
	    	int r = (int) (Math.random() * 16) + 5;
	    	room_y = r;
	    	
	    	r = (int) (Math.random()  * 16) + 5;
	    	room_x = r;
	    	
	    	System.out.println(room_y);
	    	System.out.println(room_x);
	    }
	    
	    public void checkCollisions() {
	    	Rectangle pr = player.getPlayerBounds();
	    	Rectangle wr = new Rectangle(0, 0, Board.room_x * 20, Board.room_y * 20);
	    	
	    	if(pr.intersects(wr)) {
	    		Spire.PC_X = 0;
	    		Spire.PC_Y = 0;
	    	}
	    	
	    }
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        
	        step();
	    }
	    
	    private void step() {
	        
	        player.move();
	        
	        repaint(player.getX()-1, player.getY()-1, 
	                player.getWidth()+3, player.getHeight()+3);     
	    }    

	    private class TAdapter extends KeyAdapter {

	        @Override
	        public void keyReleased(KeyEvent e) {
	            player.keyReleased(e);
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
	            player.keyPressed(e);
	        }
	    }
}
