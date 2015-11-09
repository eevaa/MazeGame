package maze;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class GameController {

CreateMazeView cmView=null;
Quest q=new Quest();
GameView gv=null;



	public GameController(CreateMazeView cmView,MazeConfig maz) {
		// TODO Auto-generated constructor stub
		this.cmView=cmView;
		gv=new GameView(cmView);
		gv.maze=maz;
		gv.quests=getQuests();
                
		System.out.println("i GOT ALL THE QUESTS");
                gv.addQuestElements();
		addAllListeners();
	}
        
        	public ArrayList<Quest> getQuests() {
		// TODO Auto-generated method stub
		ArrayList<Quest> questList=new ArrayList<Quest>();
		for(String s:gv.mainChars){
			Element e=new Element(s);
			Quest ques=q.getQuest(e);
			questList.add(ques);
		}
		
		return questList;
	}

	private void addAllListeners() {
		// TODO Auto-generated method stub
		Component[] components=gv.cmView.scView.frame.getComponents();
		for(int i=0;i<components.length;i++){
			components[i].addKeyListener(moveChar);
			components[i].setFocusable(true);
		}
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
