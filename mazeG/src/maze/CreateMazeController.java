package maze;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import maze.MazeConfig;
import maze.SelectCharView;

public class CreateMazeController {
	CreateMazeView cmView=null;
	MazeConfig maze=new MazeConfig();
	SelectCharView scView=null;
	GameController gc=null;

	public CreateMazeController(SelectCharView scView) {
		// TODO Auto-generated constructor stub
		this.scView=scView;
		this.cmView=new CreateMazeView(scView);
		addListeners();
		
		
	}

	private void addListeners() {
		// TODO Auto-generated method stub
		for(int i=0;i<cmView.mazeDimY;i++){
			for(int j=0;j<cmView.mazeDimX;j++){
				JPanel jp=cmView.panels[i][j];
				jp.addMouseListener(panelClicked);
			}
		}
		cmView.next.addMouseListener(mazeDone);
	}
	
	MouseListener mazeDone=new MouseListener() {
		
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
			gc=new GameController(cmView,maze);
			
			
		}
	};
	
	MouseListener panelClicked=new MouseListener() {
		
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
			if(arg0.isShiftDown()){
				JPanel temp=(JPanel) arg0.getSource();
				temp.setBackground(Color.BLACK);
			//	temp.setBorder(null);
				if(!(maze.walls.contains(temp)))
					maze.walls.add(temp);
			}
			
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			JPanel temp=(JPanel) arg0.getSource();
			if(temp.getBackground()==Color.BLACK){
				maze.walls.remove(temp);
				System.out.println(maze.walls.size());
				temp.setBackground(new Color(238,238,238));
			}
			else{
				System.out.println(temp.getBackground());
			temp.setBackground(Color.BLACK);
		//	temp.setBorder(null);
			if(!(maze.walls.contains(temp)))
			maze.walls.add(temp);
			}
			
			
		}
	};
}
