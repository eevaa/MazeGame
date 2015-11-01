package maze;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class SelectCharController {
	
	SelectCharView scView=null;
	
	public SelectCharController(SelectCharView scView) {
		// TODO Auto-generated constructor stub
		
		this.scView=scView;
		addListeners();
	}

	private void addListeners() {
		// TODO Auto-generated method stub
		for(JButton j:scView.elements){
			j.addMouseListener(imageChanger);
		}
		scView.startGame.addMouseListener(createMaze);
	}
	
	MouseListener createMaze=new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			new CreateMazeController(scView);
		}
	};
	
	
	MouseListener imageChanger=new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			JButton but=(JButton) arg0.getSource();
			if(scView.players.size()<3){
			scView.players.add(but.getName());
			scView.changeImage(but);
			}
			
			
		}
	};

}
