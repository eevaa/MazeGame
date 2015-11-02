package maze;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateMazeView {
	
	
	SelectCharView scView=null;
	JPanel horPanel=null;
	int mazeDim=10;
	JButton next=null;
	JPanel panels[][]=new JPanel[mazeDim][mazeDim+5];
	
	public CreateMazeView(SelectCharView scView){
		this.scView=scView;
		init();
	}

	
	
	
	public void init()
	{	
		scView.header.removeAll();
		scView.grid.removeAll();
		scView.footer.removeAll();
		scView.mainPanel.repaint();
		scView.mainPanel.revalidate();
		
		
		
                scView.mainPanel.setLayout(new BoxLayout(scView.mainPanel, BoxLayout.Y_AXIS));
		JLabel heading=new JLabel("Click grid to create maze..");
		scView.header.add(heading);
		//scView.grid=new JPanel();
		scView.grid.setLayout(new BoxLayout(scView.grid, BoxLayout.Y_AXIS));
                
		for(int i=0;i<mazeDim;i++){
			//String horPanName="horpan"+i;
		 horPanel=new JPanel();
                 horPanel.add(Box.createRigidArea(new Dimension(10, 0)));
			for(int j=0;j<mazeDim+5;j++){
				
				JPanel innerPanel=new JPanel();
				//innerPanel.setBackground(Color.BLACK);
				innerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				horPanel.add(innerPanel);
				panels[i][j]=innerPanel;
                                //innerPanel.setSize(new Dimension(50,50));
				
			}
			scView.grid.add(horPanel);
			horPanel.setBackground(Color.GRAY);
			horPanel.setLayout(new BoxLayout(horPanel,BoxLayout.X_AXIS));
			
			
		}
		
		//scView.mainPanel.setPreferredSize(frame.getSize());
		
	 next=new JButton("Game On");
		
		scView.footer.add(next);
		
		
		
	}
}
