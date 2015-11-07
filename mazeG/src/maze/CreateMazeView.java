package maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CreateMazeView {
	
	
	SelectCharView scView=null;
	JPanel horPanel=null;
	int mazeDimY=12;
	int mazeDimX=22;
	JButton next=null;
	JPanel panels[][]=new JPanel[mazeDimY][mazeDimX];
	
	public CreateMazeView(SelectCharView scView){
		this.scView=scView;
		init();
	}

	
	
	
	public void init()
	{	
		scView.header.removeAll();
		scView.grid.removeAll();
                scView.pickPane.removeAll();
		scView.footer.removeAll();
		scView.mainPanel.repaint();
		scView.mainPanel.revalidate();
		
		
		
                scView.mainPanel.setLayout(new BoxLayout(scView.mainPanel, BoxLayout.Y_AXIS));
		JLabel heading=new JLabel("Click grid to create maze..");
                heading.setFont(new Font("Arial", Font.PLAIN, 24));
                scView.header.add(Box.createRigidArea(new Dimension(40, 0)));
		scView.header.add(heading);
		//scView.grid=new JPanel();
		scView.grid.setLayout(new BoxLayout(scView.grid, BoxLayout.Y_AXIS));
                
		for(int i=0;i<mazeDimY;i++){
			//String horPanName="horpan"+i;
		 horPanel=new JPanel();
                 
                 
                 horPanel.add(Box.createRigidArea(new Dimension(10, 0)));
                 horPanel.setOpaque(false);
			for(int j=0;j<mazeDimX;j++){
				
				JPanel innerPanel=new JPanel();
				//innerPanel.setBackground(Color.BLACK);
				innerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				horPanel.add(innerPanel);
				panels[i][j]=innerPanel;
                                
				
			}
			scView.grid.add(horPanel);
			horPanel.setBackground(Color.GRAY);
			horPanel.setLayout(new BoxLayout(horPanel,BoxLayout.X_AXIS));
			scView.grid.setPreferredSize(new Dimension(1078,588));
                        scView.grid.setMaximumSize(new Dimension(1078,588));
			
		}
		
		//scView.mainPanel.setPreferredSize(frame.getSize());
		
                next=new JButton("Game On");
                next.setPreferredSize(new Dimension(100, 40));
                next.setBackground(new Color(75,202,210));
                Border emptyBorder = BorderFactory.createEmptyBorder();
                next.setBorder(emptyBorder);
		next.setFont(new Font("Arial", Font.PLAIN, 18));
                scView.grid.add(Box.createRigidArea(new Dimension(0, 30)));
		scView.footer.add(next);
		
		
		
	}
}
