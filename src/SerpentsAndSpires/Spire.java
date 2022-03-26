package SerpentsAndSpires;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Spire {
	

    private final int PC = 10;
    
    public static int PC_X;
    public static int PC_Y;
    private int w;
    private int h;
    
    private int CY = Board.B_HEIGHT / 2;
    private int CX = Board.B_WIDTH / 2;

    private int x = 30;
    private int y = 30;
    
    private Board board;
    
    private boolean inGame = true;
    
    private Image playerCharacter;
    private Image wallImage;
    
    public Spire() {
    	
    	loadImages();
    }
    

    private void loadImages() {
    	
    	ImageIcon iid = new ImageIcon("src/resources/transFerdMRK3.png");
    	playerCharacter = iid.getImage();
    	
    	ImageIcon wid = new ImageIcon("src/resources/WallMRK1.png");
    	wallImage = wid.getImage();
    	
    	w = 22;
    	h = 22;
    	
    }
    
    
//    private void gameOver(Graphics g) {
//        
//        String msg = "Game Over";
//        Font small = new Font("Helvetica", Font.BOLD, 14);
//        FontMetrics metr = getFontMetrics(small);
//
//        g.setColor(Color.white);
//        g.setFont(small);
//        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
//    }
    
    
    public void move() {
    	
    	x += PC_X;
    	y += PC_Y;
    	

    }
    
    
    public int getX() {
        
        return x;
    }

    public int getY() {
        
        return y;
    }
    
    public int getWidth() {
        
        return w;
    }
    
    public int getHeight() {
        
        return h;
    }    

    public Image getPlayerImage() {
        
        return playerCharacter;
        
    }
    
    public Image getWallImage() {
    	return wallImage;
    }
    
    public Rectangle getPlayerBounds() {
    	
        return new Rectangle(x, y, 22, 22);
        
    }
    public Rectangle getWallBounds() {
    	
    	return new Rectangle(0, 0, Board.room_x * 20, Board.room_y * 20);
    	
    }
    
    public void borderCollision() {
    	if(x <= 0) {
    		x = 0;
    	}
    	if(x >= Board.B_WIDTH - w) {
    		x = Board.B_WIDTH - w;
    	}
    	if(y <= 0) {
    		y = 0;
    	}
    	if(y >= Board.B_HEIGHT - h) {
    		y = Board.B_HEIGHT- h;
    	}

    	
    }
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT && x > 0) {
            PC_X = -2;
        }  

        if (key == KeyEvent.VK_RIGHT && x < Board.B_WIDTH - w) {
            PC_X = 2;
        }

        if (key == KeyEvent.VK_UP && y > 0) {
            PC_Y = -2;
        } 

        if (key == KeyEvent.VK_DOWN && y < Board.B_HEIGHT - h) {
            PC_Y = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            PC_X = 0;
            borderCollision();
        }

        if (key == KeyEvent.VK_RIGHT) {
            PC_X = 0;
            borderCollision();
        }

        if (key == KeyEvent.VK_UP) {
            PC_Y = 0;
            borderCollision();
        }

        if (key == KeyEvent.VK_DOWN) {
            PC_Y = 0;
            borderCollision();
        }
    }
}
