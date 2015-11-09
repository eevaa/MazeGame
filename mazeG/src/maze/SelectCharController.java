package maze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
		scView.startGame.addActionListener(createMaze);
	}
	
	ActionListener createMaze=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			// TODO Auto-generated method stub
			if (scView.players.size()==3)
			new CreateMazeController(scView);
			
			else{
				JOptionPane.showMessageDialog(null, "Select 3 elements to proceed");
			}
			
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
			but.removeMouseListener(imageChanger);
			}
			
			
		}
	};

}
