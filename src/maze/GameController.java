package maze;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import maze.MazeConfig;

import org.omg.Messaging.SyncScopeHelper;

public class GameController {

CreateMazeView cmView=null;

GameView gv=null;

	public GameController(CreateMazeView cmView,MazeConfig maz) {
		// TODO Auto-generated constructor stub
		this.cmView=cmView;
		gv=new GameView(cmView);
		gv.mainElem.addKeyListener(moveChar);
		gv.mainElem.setFocusable(true);
		gv.maze=maz;
		
	}
	
	KeyListener moveChar=new KeyListener() {
	
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("bla bla bla");
			
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
	            System.out.println("Right pressed.");
	            gv.moveRight(gv.mainElem);
	        } 
	        else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
	            System.out.println("Left pressed.");
	            gv.moveLeft(gv.mainElem);
	        } 
	        else if (e.getKeyCode() == KeyEvent.VK_UP ) {
	            System.out.println("Up pressed.");
	            gv.moveUp(gv.mainElem);
	        } 
	        else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
	            System.out.println("Down pressed.");
	            gv.moveDown(gv.mainElem);
	        }
	        else{
	            System.out.println("Key pressed: " + e.getKeyChar());
	        }
			
		}
	};

}
